package com.businessanalytics.analysis.engines.amazon;

import com.businessanalytics.analysis.decomposers.WordSentenceDecomposer;
import com.businessanalytics.analysis.decomposers.beans.WordSentenceDecomposerResult;
import com.businessanalytics.analysis.engines.AnalysisEngine;
import com.businessanalytics.analysis.engines.result.beans.AmazonProductAnalysisResult;
import com.businessanalytics.analysis.engines.result.beans.AmazonProductCommentAnalysisResult;
import com.businessanalytics.analysis.modules.basic.WordSentenceAnalysisModule;
import com.businessanalytics.analysis.modules.basic.result.beans.WordSentenceAnalysisResult;
import com.businessanalytics.content.beans.amazon.AmazonProduct;
import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class AmazonProductAnalysisEngine implements AnalysisEngine<AmazonProduct, AmazonProductAnalysisResult> {
    private final
    WordSentenceAnalysisModule wordSentenceAnalysisModule;

    private final
    WordSentenceDecomposer wordSentenceDecomposer;

    private final
    AmazonProductCommentAnalysisEngine amazonProductCommentAnalysisEngine;

    @Autowired
    public AmazonProductAnalysisEngine(WordSentenceAnalysisModule wordSentenceAnalysisModule
            , WordSentenceDecomposer wordSentenceDecomposer
            , AmazonProductCommentAnalysisEngine amazonProductCommentAnalysisEngine) {
        this.wordSentenceAnalysisModule = wordSentenceAnalysisModule;
        this.wordSentenceDecomposer = wordSentenceDecomposer;
        this.amazonProductCommentAnalysisEngine = amazonProductCommentAnalysisEngine;
    }

    @Override
    public AmazonProductAnalysisResult run(AmazonProduct content) {
        int informativeComments = 0;
        List<AmazonProductCommentAnalysisResult> commentAnalysisResults = new ArrayList<>();
        for (AmazonProductComment comment : content.amazonProductComments) {
            AmazonProductCommentAnalysisResult analysisResult = amazonProductCommentAnalysisEngine.run(comment);
            if (analysisResult.isInformative()) {
                informativeComments++;
            }
            commentAnalysisResults.add(analysisResult);
        }
        AmazonProductAnalysisResult amazonProductAnalysisResult = new AmazonProductAnalysisResult();
        amazonProductAnalysisResult.setTotalComments(content.getAmazonProductComments().size());
        amazonProductAnalysisResult.setInformativeComments(informativeComments);
        amazonProductAnalysisResult.setAmazonProductCommentAnalysisResults(commentAnalysisResults);
        return amazonProductAnalysisResult;
    }
}
