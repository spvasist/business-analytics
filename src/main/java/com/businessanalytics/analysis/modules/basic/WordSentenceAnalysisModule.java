package com.businessanalytics.analysis.modules.basic;

import com.businessanalytics.analysis.decomposers.WordSentenceDecomposer;
import com.businessanalytics.analysis.decomposers.beans.WordSentenceDecomposerResult;
import com.businessanalytics.analysis.modules.AnalysisModule;
import com.businessanalytics.analysis.modules.basic.result.beans.WordSentenceAnalysisResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WordSentenceAnalysisModule implements AnalysisModule<String, WordSentenceAnalysisResult> {
    public static final int MEANINGFUL_WORD_LENGTH = 3;


    private final WordSentenceDecomposer wordSentenceDecomposer;

    public WordSentenceAnalysisModule(WordSentenceDecomposer wordSentenceDecomposer) {
        this.wordSentenceDecomposer = wordSentenceDecomposer;
    }

    @Override
    public WordSentenceAnalysisResult run(String content) {
        WordSentenceDecomposerResult decomposerResult = wordSentenceDecomposer.decompose(content);
        WordSentenceAnalysisResult result = new WordSentenceAnalysisResult();
        result.setSentenceCount(decomposerResult.getSentences().size());


        result.setWordCount(decomposerResult.getWords().size());

        result.setWordOccurrenceMap(decomposerResult.getWordOccurrences());
        result.setMeaningfulWordCount((int) decomposerResult.getWordOccurrences().entrySet().stream()
                .filter(i -> i.getKey().length() >= MEANINGFUL_WORD_LENGTH)
                .count());
        return result;
    }
}
