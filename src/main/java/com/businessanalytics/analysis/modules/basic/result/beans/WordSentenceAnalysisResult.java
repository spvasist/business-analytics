package com.businessanalytics.analysis.modules.basic.result.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import java.util.Map;
import com.businessanalytics.analysis.modules.basic.WordSentenceAnalysisModule;

/**
 * Created by srikanth on 13-04-2017.
 */
@AllArgsConstructor
@NoArgsConstructor
@JsonComponent
@Data
public class WordSentenceAnalysisResult {
    int sentenceCount;
    int wordCount;
    /**
     * Character length more than {@link WordSentenceAnalysisModule#MEANINGFUL_WORD_LENGTH}.
     */
    int meaningfulWordCount;
    Map<String, Long> wordOccurrenceMap;
}
