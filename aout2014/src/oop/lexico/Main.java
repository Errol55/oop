package oop.lexico;

public class Main {

    public static void main(String[] args) {

        StringAnalyzer stringAnalyzer = new StringAnalyzer("Programming is awesome ! Isn’t it ?");

        System.out.printf("Sentences: %d\n", stringAnalyzer.numberOfSentences());
        System.out.printf("Words: %d\n", stringAnalyzer.numberOfWords());

    }
}
