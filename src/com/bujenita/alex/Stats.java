package com.bujenita.alex;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Stats {
    private final Map<String, Integer> wordCounts;
    private int numberOfWords;

    public Stats() {
        this.wordCounts = new HashMap<>();
        this.numberOfWords = 0;
    }

    public void mapWordToCount(String word) {
        this.numberOfWords++;
        this.wordCounts.merge(word, 1, Integer::sum);
    }

    public void printOccurrences() {
        // TEST
        Map<String, Integer> topTen = this.wordCounts
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(20)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        //
        for (String word: topTen.keySet()) {
            System.out.println("Word " + " | " + word  + " | " + " occurred " + wordCounts.get(word) + " times");
        }
//        for (String word: this.wordCounts.keySet()) {
//            System.out.println("Word " + " | " + word  + " | " + " occurred " + wordCounts.get(word) + " times");
//        }
        System.out.println("Total words: " + this.numberOfWords);
    }
}
