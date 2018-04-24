package com.businessanalytics.analysis.decomposers.beans;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class WordSentenceDecomposerResult {
    public List<String> words;
    public List<String> sentences;
    public Map<String, Long> wordOccurrences;
}
