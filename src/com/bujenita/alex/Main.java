package com.bujenita.alex;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Required file name");
        }
        String fileName = args[0];
        TextFileReader textReader = new TextFileReader(fileName);
        textReader.readTest();
    }
}
