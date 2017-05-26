package oop.lexico;


public class SentenceCounter extends CharacterStreamCounter {

    public SentenceCounter() {
        super();
    }

    @Override
    protected boolean isValidFirst(char c) {
        return Character.isUpperCase(c);
    }

    @Override
    protected boolean isValidLast(char c) {
        return c == '.' || c == '!' || c == '?';
    }
}
