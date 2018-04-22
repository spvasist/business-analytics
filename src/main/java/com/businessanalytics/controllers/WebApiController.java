package com.businessanalytics.controllers;

import com.businessanalytics.analysis.engines.AmazonProductAnalysisEngine;
import com.businessanalytics.analysis.engines.AnalysisEngine;
import com.businessanalytics.content.ContentRequest;
import com.businessanalytics.content.beans.amazon.AmazonProduct;
import com.businessanalytics.content.beans.toi.ToiNewsArticle;
import com.businessanalytics.content.retrievers.AmazonProductContentRetriever;
import com.businessanalytics.content.retrievers.ToiNewsArticleContentRetriever;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WebApiController {
    private final
    ToiNewsArticleContentRetriever toiNewsArticleContentRetriever;
    private final
    AmazonProductContentRetriever amazonProductContentRetriever;
    @Autowired
    AmazonProductAnalysisEngine amazonProductAnalysisEngine;

    @Autowired
    public WebApiController(ToiNewsArticleContentRetriever toiContentEngine
            , AmazonProductContentRetriever amazonProductContentRetriever) {
        this.toiNewsArticleContentRetriever = toiContentEngine;
        this.amazonProductContentRetriever = amazonProductContentRetriever;
    }

    public void performAnalysis(ContentRequest<String> contentRequest) {
        switch (contentRequest.getContentType()) {
            case TOI_NEWS:
                String url = contentRequest.getDataSource();
                ToiNewsArticle toiNewsArticle = toiNewsArticleContentRetriever.fetchContent(url);

                break;
            case AMAZON_PRODUCT:
                url = contentRequest.getDataSource();
                AmazonProduct amazonProduct = amazonProductContentRetriever.fetchContent(url);
                amazonProductAnalysisEngine.run(amazonProduct);
                break;
        }

    }
}
