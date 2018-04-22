package com.businessanalytics.analysis.engines;

import com.businessanalytics.analysis.engines.result.beans.AmazonProductAnalysisResult;
import com.businessanalytics.content.beans.amazon.AmazonProduct;
import lombok.Data;

@Data
public class AmazonProductAnalysisEngine implements AnalysisEngine<AmazonProduct, AmazonProductAnalysisResult> {
    @Override
    public AmazonProductAnalysisResult run(AmazonProduct content) {
        return null;
    }
}
