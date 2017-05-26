package oop.lexico;


public class StringAnalyzer {

    private final String string;
    private final WordCounter wordCounter = new WordCounter();
    private final SentenceCounter sentenceCounter = new SentenceCounter();

    public StringAnalyzer(String string) {
        this.string = string;
        analyze();
    }

    private void analyze() {
        for (int i = 0; i < string.length(); i++) {
            wordCounter.putChar(string.charAt(i));
            sentenceCounter.putChar(string.charAt(i));
        }
    }

    public int numberOfSentences() {
        return sentenceCounter.getCounterValue();
    }

    public int numberOfWords() {
        return wordCounter.getCounterValue();
    }


}
