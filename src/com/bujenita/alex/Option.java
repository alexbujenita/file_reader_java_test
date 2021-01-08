package com.bujenita.alex;

import java.util.ArrayList;
import java.util.Locale;

public class Option {
    private final ArrayList<String> words;

    public Option() {
        this.words = new ArrayList<>();
    }

    public void addWords(String word) {
        this.words.add(word.toLowerCase(Locale.ROOT));
    }

    public boolean hasFilters() {
        return !(this.words.size() == 0);
    }

    public boolean hasWord(String word) {
        return this.words.contains(word);
    }
}
