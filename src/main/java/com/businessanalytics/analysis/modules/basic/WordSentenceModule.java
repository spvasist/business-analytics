package com.businessanalytics.analysis.modules.basic;

import com.businessanalytics.analysis.modules.AnalysisModule;
import com.businessanalytics.analysis.modules.beans.WordSentenceAnalysisResult;
import com.businessanalytics.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WordSentenceModule implements AnalysisModule<String, WordSentenceAnalysisResult> {

    @Override
    public WordSentenceAnalysisResult run(String content) {
        String[] strings = content.split("\\.");
        strings = StringUtil.removeEmptyStrings(strings);
        WordSentenceAnalysisResult result = new WordSentenceAnalysisResult();
        result.setSentenceCount(strings.length);

        String dataWord = content.replaceAll("\\.", " ");
        strings = dataWord.split(" ");
        strings = StringUtil.removeEmptyStrings(strings);
        result.setWordCount((int) Arrays.stream(strings).distinct().count());


        result.setWordOccurrenceMap(computeWordOccurrences(strings));

        return result;
    }

    private Map<String, Long> computeWordOccurrences(String[] strings) {
        Map<String, Long> map ;
        List<String> list = Arrays.asList(strings);
        map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<Map.Entry<String,Long>> mapList =
                new LinkedList<>(map.entrySet());
        mapList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        Map<String, Long> result = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : mapList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
