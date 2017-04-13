package com.businessanalytics.controllers;

import com.businessanalytics.analysis.AnalysisEngine;
import com.businessanalytics.beans.analysisresults.WordSentenceAnalysisResult;
import com.businessanalytics.beans.content.Content;
import com.businessanalytics.beans.content.ContentRequest;
import com.businessanalytics.contentengines.ToiContentEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.businessanalytics.contentengines.ContentTypes.*;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WebApiController {
    @Autowired
    ToiContentEngine toiContentEngine;
@Autowired
    AnalysisEngine analysisEngine;
    public void performAnalysis(ContentRequest contentRequest) {
        Content content = null;
        switch (contentRequest.getContentType()) {
            case TOI:
                String url = String.valueOf(contentRequest.getRequestData());
                content = toiContentEngine.fetchContent(url);
                break;

        }
        analysisEngine.run(content);

    }
}
