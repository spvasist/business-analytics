package com.businessanalytics.analysis;

import com.businessanalytics.beans.content.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class AnalysisEngine {
    @Autowired
    WordSentenceModule wordSentenceEngine;
    public Object run(Content content)
    {
        return wordSentenceEngine.run(content);
    }
}
