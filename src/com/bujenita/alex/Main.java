package com.bujenita.alex;

import org.jetbrains.annotations.NotNull;

public class Main {

    public static void main(String @NotNull [] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Required file name");
        }
        Stats stats = new Stats();
        String fileName = args[0];
        TextFileReader textReader = new TextFileReader(fileName, stats);
        textReader.readTest();

        stats.printOccurrences();
    }
}
