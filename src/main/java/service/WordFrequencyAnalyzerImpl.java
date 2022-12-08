package service;

import domain.WordFrequency;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    Map<String, Integer> map = new TreeMap<>();

    private void calculateFrequency(String text) {
        map.clear();

        String input = text.toLowerCase();
        String[] array = input.split("\\W+");

        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                map.put(array[i], map.get(array[i]) + 1);
            } else {
                map.put(array[i], 1);
            }
        }
    }

    @Override
    public int calculateHighestFrequency(String text) {
        calculateFrequency(text);

        if (!map.isEmpty()) {
            return (Collections.max(map.values()));
        }
        return 0;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {
        calculateFrequency(text);

        if (!map.isEmpty()) {
            return map.get(word);
        }
        return 0;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {
        calculateFrequency(text);
        List<WordFrequency> lwf = new ArrayList<>();

        if (!map.isEmpty()) {
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                lwf.add(new WordFrequency(entry.getKey(), entry.getValue()));
            }

            Collections.sort(lwf, Collections.reverseOrder());

            for (int i = lwf.size(); i > n; i--) {
                lwf.remove(i - 1);
            }
        }
        return lwf;
    }
}


