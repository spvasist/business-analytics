package com.businessanalytics.handlers;

import com.businessanalytics.apis.WebApi;
import com.businessanalytics.beans.analysisresults.WordSentenceAnalysisResult;
import com.businessanalytics.beans.content.ContentRequest;
import com.businessanalytics.contentengines.ContentTypes;
import com.businessanalytics.controllers.WebApiController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WebApiHandler implements WebApi {
    @Autowired
    WebApiController webApiController;
    @Autowired
    WebApiHandler webApiHandler;

    @Override
    public void analyze(ContentRequest contentRequest) {
        contentRequest.setContentType(ContentTypes.TOI);
        contentRequest.setRequestData("D:\\news.txt");
        webApiController.performAnalysis(contentRequest);
    }
}
