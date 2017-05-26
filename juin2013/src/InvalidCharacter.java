public class InvalidCharacter extends Exception {
    public InvalidCharacter(Character c) {
        super("Invalid character: " + c);
    }
}
