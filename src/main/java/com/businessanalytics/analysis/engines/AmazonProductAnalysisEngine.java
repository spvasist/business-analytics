package com.businessanalytics.analysis.engines;

import com.businessanalytics.analysis.engines.result.beans.AmazonProductAnalysisResult;
import com.businessanalytics.analysis.modules.basic.WordSentenceAnalysisModule;
import com.businessanalytics.analysis.modules.basic.result.beans.WordSentenceAnalysisResult;
import com.businessanalytics.content.beans.amazon.AmazonProduct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class AmazonProductAnalysisEngine implements AnalysisEngine<AmazonProduct, AmazonProductAnalysisResult> {
    @Autowired
    WordSentenceAnalysisModule wordSentenceAnalysisModule;
    @Override
    public AmazonProductAnalysisResult run(AmazonProduct content) {
        WordSentenceAnalysisResult wordSentenceAnalysisResult = wordSentenceAnalysisModule.run(content.description);
        AmazonProductAnalysisResult amazonProductAnalysisResult = new AmazonProductAnalysisResult();
        return amazonProductAnalysisResult;
    }
}
