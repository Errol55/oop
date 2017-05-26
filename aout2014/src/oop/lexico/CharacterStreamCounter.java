package oop.lexico;


public abstract class CharacterStreamCounter implements Counter {

    private boolean middleOfToken = false;
    private int count = 0;

    abstract protected boolean isValidFirst(char c);
    abstract protected boolean isValidLast(char c);

    @Override
    public void putChar(char ch) {
        if(!middleOfToken && isValidFirst(ch))
            middleOfToken = true;
        if(middleOfToken && isValidLast(ch)) {
            middleOfToken = false;
            count++;
        }
    }

    @Override
    public int getCounterValue() {
        return count;
    }
}
