package com.businessanalytics.content.retrievers;

import com.businessanalytics.content.beans.toi.ToiNewsArticle;
import com.businessanalytics.utils.FileUtil;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class ToiNewsArticleContentRetriever implements ContentRetriever {

    @Override
    public ToiNewsArticle fetchContent(String source) {
        ToiNewsArticle toiNewsArticle = new ToiNewsArticle();
        toiNewsArticle.setBody(FileUtil.readFileString(source));
        return toiNewsArticle;
    }
}
