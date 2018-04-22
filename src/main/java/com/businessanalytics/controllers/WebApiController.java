package com.businessanalytics.controllers;

import com.businessanalytics.analysis.engines.AnalysisEngine;
import com.businessanalytics.content.ContentRequest;
import com.businessanalytics.content.beans.toi.ToiNewsArticle;
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
    AnalysisEngine analysisEngine;

    @Autowired
    public WebApiController(AnalysisEngine analysisEngine, ToiNewsArticleContentRetriever toiContentEngine) {
        this.analysisEngine = analysisEngine;
        this.toiNewsArticleContentRetriever = toiContentEngine;
    }

    public void performAnalysis(ContentRequest<String> contentRequest) {
        switch (contentRequest.getContentType()) {
            case TOI_NEWS:
                String url = contentRequest.getDataSource();
                ToiNewsArticle content = toiNewsArticleContentRetriever.fetchContent(url);
                break;
            case AMAZON_PRODUCT:

                break;
        }

    }
}
