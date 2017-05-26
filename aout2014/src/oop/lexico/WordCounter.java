package oop.lexico;


public class WordCounter extends CharacterStreamCounter {

    public WordCounter() {
        super();
    }

    @Override
    protected boolean isValidFirst(char c) {
        return Character.isLetter(c);
    }

    @Override
    protected boolean isValidLast(char c) {
        return !Character.isLetter(c);
    }
}
