public abstract class PrintableComparableDNA implements DNA {

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof PrintableComparableDNA))
            return false;
        PrintableComparableDNA dna = (PrintableComparableDNA) obj;
        if (dna.getSize() != getSize())
            return false;
        for (int i = 0; i < getSize(); i++) {
            if (getNucleotide(i) != dna.getNucleotide(i))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 73;
        for (int i = 0; i < getSize(); i++)
            result += result * 31 + getNucleotide(i).hashCode();
        return result;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(getSize());
        for (int i = 0; i < getSize(); i++)
            str.append(getNucleotide(i).toString());
        return str.toString();
    }
}
