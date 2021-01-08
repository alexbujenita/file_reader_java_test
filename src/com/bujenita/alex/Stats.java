package com.bujenita.alex;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stats {
    private final Map<String, Integer> wordCounts;
    private final Option option;
    private int numberOfWords;

    public Stats(Option option) {
        this.wordCounts = new HashMap<>();
        this.option = option;
        this.numberOfWords = 0;
    }

    public void mapWordToCount(String word) {
        this.numberOfWords++;
        this.wordCounts.merge(word, 1, Integer::sum);
    }

    public void printOccurrences() {
        boolean hasFilters = option.hasFilters();
        // TEST
        Map<String, Integer> topTen = this.wordCounts
                .entrySet()
                .stream()
                .filter(w -> !hasFilters || option.hasWord(w.getKey()))
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(20L)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        //
        for (String word : topTen.keySet()) {
            System.out.println("Word " + " | " + "\u001B[31m" + word + "\u001B[0m" + " | " + " occurred " + wordCounts.get(word) + " times");
        }

        System.out.println("Total words: " + this.numberOfWords);
    }
}
