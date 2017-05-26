public class FullDNA extends PrintableComparableDNA {

    private Nucleotide[] sequence;

    public FullDNA(String sequence) throws InvalidCharacter {
        this.sequence = new Nucleotide[sequence.length()];
        for (int i = 0; i < sequence.length(); i++) {
            this.sequence[i] = Nucleotide.valueOf(sequence.charAt(i));
        }
    }

    @Override
    public Object getNucleotide(int i) {
        return sequence[i];
    }

    @Override
    public int getSize() {
        return sequence.length;
    }
}
