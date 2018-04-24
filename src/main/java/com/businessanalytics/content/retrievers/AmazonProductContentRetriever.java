package com.businessanalytics.content.retrievers;

import com.businessanalytics.content.beans.amazon.AmazonProduct;
import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class AmazonProductContentRetriever implements ContentRetriever<AmazonProduct> {
    @Override
    public AmazonProduct fetchContent(String source) {
        AmazonProduct amazonProduct = new AmazonProduct();
        Document document;
        try {
            document = Jsoup.connect(source).get();
            amazonProduct.setId(document.getElementById("ASIN").attr("value"));
            amazonProduct.amazonProductComments = fetchProductComments(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return amazonProduct;
    }


    private List<AmazonProductComment> fetchProductComments(Document document) {
        if (document == null)
            return null;

        List<AmazonProductComment> amazonProductComments = new ArrayList<>();
        try {

            //Fetch all comments
            {
                Element element = document.getElementById("centerCol").getElementById("acrCustomerReviewLink");
                if (element != null) {
                    String url = element.absUrl("href");
                    //Fetch first comments page
                    Document commentsPage = Jsoup.connect(url).get();
                    //Find total page count
                    Element pageBarElement = commentsPage.getElementById("cm_cr-pagination_bar");
                    int pageCount = 1;
                    if (pageBarElement != null) {
                        Elements elements = pageBarElement.getElementsByClass("page-button");
                        if (elements != null && elements.size() > 0) {
                            pageCount = Integer.parseInt(elements.last().text());
                        }
                    }
                    for (int i = 0; i < pageCount; i++) {
                        amazonProductComments
                                .addAll(retrieveProductCommentFromPage(url + "&pageNumber=" + (i + 1)));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return amazonProductComments;
    }

    public List<AmazonProductComment> retrieveProductCommentFromPage(String url) {
        List<AmazonProductComment> amazonProductComments = new ArrayList<>();
        Document document;
        try {
            document = Jsoup.connect(url).get();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        Elements elements = document.getElementsByClass("a-section review");
        if (elements == null || elements.size() == 0)
            return null;
        for (Element element : elements) {
            AmazonProductComment amazonProductComment = new AmazonProductComment();
            amazonProductComment.setId(element.attr("id"));
            //Get star
            try {
                String star = element.getElementsByAttributeValue("data-hook", "review-star-rating").text();
                if (star != null) {

                    amazonProductComment.stars = Double.parseDouble(StringUtils.split(star, " ")[0]);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Get title
            amazonProductComment.title = element.getElementsByAttributeValue("data-hook", "review-title").text();

            //Get author
            amazonProductComment.username =
                    element.getElementsByAttributeValue("data-hook", "review-author")
                            .select("a")
                            .text();

            //Get verified purchase
            Elements verifiedTagElements = element.getElementsByAttributeValue("data-hook", "avp-badge");
            amazonProductComment.verifiedPurchaser = verifiedTagElements != null && verifiedTagElements.size() > 0;

            //Get date
            String dateString = element.getElementsByAttributeValue("data-hook", "review-date")
                    .text().replace("on ", "");
            DateFormat format = new SimpleDateFormat("dd MMMM yyyy", Locale.ENGLISH);
            try {
                amazonProductComment.time = format.parse(dateString);
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            //Get body
            amazonProductComment.body = element.getElementsByAttributeValue("data-hook", "review-body").text();
            amazonProductComments.add(amazonProductComment);
        }
        return amazonProductComments;
    }

}
