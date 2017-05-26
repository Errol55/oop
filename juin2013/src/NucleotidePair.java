public class NucleotidePair {

    private final int count;
    private final Nucleotide nucleotide;

    public NucleotidePair(int count, Nucleotide nucleotide) {
        this.count = count;
        this.nucleotide = nucleotide;
    }

    @Override
    public String toString() {
        String n = nucleotide.toString();
        StringBuilder str = new StringBuilder(count);
        for (int i = 0; i < count; i++)
            str.append(n);
        return str.toString();
    }

    public int getCount() {
        return count;
    }

    public Nucleotide getNucleotide() {
        return nucleotide;
    }
}
