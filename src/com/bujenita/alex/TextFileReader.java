package com.bujenita.alex;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

public class TextFileReader {

    private final String fileName;
    private final Stats stats;

    public TextFileReader(String fileName, Stats stats) {
        this.fileName = fileName;
        this.stats = stats;
    }

    public void readTest() {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(this.fileName));) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    word = word.replaceAll("[^a-zA-Z]", "").toLowerCase(Locale.ROOT);
                    if(word.isBlank()) continue;
                    this.stats.mapWordToCount(word);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
