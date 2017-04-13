package com.businessanalytics.analysis;

import com.businessanalytics.beans.analysisresults.WordSentenceAnalysisResult;
import com.businessanalytics.beans.content.Content;
import com.businessanalytics.utils.StringUtil;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by srikanth on 13-04-2017.
 */
@Component
public class WordSentenceModule implements AnalysisModule<WordSentenceAnalysisResult> {

    @Override
    public WordSentenceAnalysisResult run(Content content) {
        String data = content.getData();
        String[] strings = data.split("\\.");
        strings = StringUtil.removeEmptyStrings(strings);
        WordSentenceAnalysisResult result = new WordSentenceAnalysisResult();
        result.setSentenceCount(strings.length);

        String dataWord = data.replaceAll("\\.", " ");
        strings = dataWord.split(" ");
        strings = StringUtil.removeEmptyStrings(strings);
        result.setWordCount((int) Arrays.stream(strings).distinct().count());


        result.setWordOccurrenceMap(computeWordOccurrences(strings));

        return result;
    }

    private Map<String, Long> computeWordOccurrences(String[] strings) {
        Map<String, Long> map ;

        List<String> list = Arrays.asList(strings);
        list.stream().distinct().toArray();
        map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<Map.Entry<String,Long>> mapList =
                new LinkedList<>(map.entrySet());

        Collections.sort(mapList, new Comparator<Map.Entry<String, Long>>() {
            public int compare(Map.Entry<String, Long> o1, Map.Entry<String, Long> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Long> result = new LinkedHashMap<String, Long>();
        for (Map.Entry<String, Long> entry : mapList) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
