package com.businessanalytics.analysis.engines.amazon;

import com.businessanalytics.analysis.decomposers.WordSentenceDecomposer;
import com.businessanalytics.analysis.decomposers.beans.WordSentenceDecomposerResult;
import com.businessanalytics.analysis.engines.AnalysisEngine;
import com.businessanalytics.analysis.engines.result.beans.AmazonProductCommentAnalysisResult;
import com.businessanalytics.analysis.modules.basic.WordSentenceAnalysisModule;
import com.businessanalytics.analysis.modules.basic.result.beans.WordSentenceAnalysisResult;
import com.businessanalytics.content.beans.amazon.AmazonProductComment;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class AmazonProductCommentAnalysisEngine
        implements AnalysisEngine<AmazonProductComment, AmazonProductCommentAnalysisResult> {
    public static final int WORD_THRESHOLD_FOR_INFORMATIVE_COMMENT = 20;

    private final WordSentenceDecomposer wordSentenceDecomposer;
    private final WordSentenceAnalysisModule wordSentenceAnalysisModule;

    @Autowired
    public AmazonProductCommentAnalysisEngine(WordSentenceDecomposer wordSentenceDecomposer
            , WordSentenceAnalysisModule wordSentenceAnalysisModule) {
        this.wordSentenceDecomposer = wordSentenceDecomposer;
        this.wordSentenceAnalysisModule = wordSentenceAnalysisModule;
    }

    @Override
    public AmazonProductCommentAnalysisResult run(AmazonProductComment content) {
        WordSentenceAnalysisResult wordSentenceAnalysisResult = wordSentenceAnalysisModule.run(content.getBody());
        AmazonProductCommentAnalysisResult result = new AmazonProductCommentAnalysisResult();
        result.setAmazonProductComment(content);
        result.setInformative(
                wordSentenceAnalysisResult.getMeaningfulWordCount() > WORD_THRESHOLD_FOR_INFORMATIVE_COMMENT
        );
        return result;
    }
}
