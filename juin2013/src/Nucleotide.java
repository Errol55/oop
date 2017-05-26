public class Nucleotide {

    private static final Nucleotide A = new Nucleotide('A');
    private static final Nucleotide C = new Nucleotide('C');
    private static final Nucleotide T = new Nucleotide('T');
    private static final Nucleotide G = new Nucleotide('G');

    private final Character letter;

    private Nucleotide(Character letter) {
        this.letter = letter;
    }

    @Override
    public int hashCode() {
        return letter.hashCode();
    }

    public static Nucleotide valueOf(Character c) throws InvalidCharacter {
        switch (c) {
            case 'A':
                return A;
            case 'C':
                return C;
            case 'T':
                return T;
            case 'G':
                return G;
        }
        throw new InvalidCharacter(c);
    }

    @Override
    public String toString() {
        return letter.toString();
    }
}
