package com.bujenita.alex;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Required file name");
        }

        Option option = new Option();


        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                option.addWords(args[i]);
            }
        }

        Stats stats = new Stats(option);
        String fileName = args[0];


        TextFileReader textReader = new TextFileReader(fileName, stats);
        textReader.readTest();

        stats.printOccurrences();
    }
}
