package com.businessanalytics.analysis.decomposers;

import com.businessanalytics.analysis.decomposers.beans.WordSentenceDecomposerResult;
import com.businessanalytics.utils.StringUtil;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Component
public class WordSentenceDecomposer {
    public WordSentenceDecomposerResult decompose(String content) {
        WordSentenceDecomposerResult result = new WordSentenceDecomposerResult();
        String[] strings = content.split("\\.");
        strings = StringUtil.removeEmptyStrings(strings);

        result.setSentences(Arrays.asList(strings));

        String dataWord = content.replaceAll("\\.", " ");
        strings = dataWord.split(" ");
        strings = StringUtil.removeEmptyStrings(strings);
        result.setWords(Arrays.asList(strings));

        result.setWordOccurrences(computeWordOccurrences(strings));
        return result;
    }

    private Map<String, Long> computeWordOccurrences(String[] strings) {
        Map<String, Long> map;
        List<String> list = Arrays.asList(strings);
        map = list.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
        List<Map.Entry<String, Long>> mapList =
                new LinkedList<>(map.entrySet());
        mapList.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));
        Map<String, Long> result = new LinkedHashMap<>();
        for (Map.Entry<String, Long> entry : mapList) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
