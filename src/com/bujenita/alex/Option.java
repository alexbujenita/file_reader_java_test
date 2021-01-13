package com.bujenita.alex;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Option {
    private final Set<String> words;

    public Option() {
        this.words = new HashSet<>();
    }

    public void addWord(String word) {
        this.words.add(word.toLowerCase(Locale.ROOT));
    }

    public boolean hasFilters() {
        return !(this.words.size() == 0);
    }

    public boolean hasWord(String word) {
        return this.words.contains(word);
    }
}
