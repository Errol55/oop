import java.util.Vector;

public class CompressedDNA extends PrintableComparableDNA {

    private Vector<NucleotidePair> sequence;
    private int length;

    public CompressedDNA(String sequence) throws InvalidCharacter {
        this.length = sequence.length();
        this.sequence = new Vector<>();
        if (length == 0)
            return;
        int count = 1;
        Nucleotide nucleotide = Nucleotide.valueOf(sequence.charAt(0));
        for (int i = 1; i < length + 1; i++) {
            Nucleotide n = (i == length) ? null : Nucleotide.valueOf(sequence.charAt(i));
            if (n == nucleotide)
                count++;
            else {
                this.sequence.add(new NucleotidePair(count, nucleotide));
                count = 1;
                nucleotide = n;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(length);
        for (NucleotidePair pair : sequence)
            stringBuilder.append(pair.toString());
        return stringBuilder.toString();
    }
    

    @Override
    public Object getNucleotide(int i) {
        if (i >= getSize() || i < 0)
            throw new IndexOutOfBoundsException();
        for (int j = 0; j < getSize(); j++) {
            int count = sequence.get(j).getCount();
            if (i < count)
                return sequence.get(j).getNucleotide();
            i -= count;
        }
        throw new AssertionError();
    }

    @Override
    public int getSize() {
        return length;
    }
}
