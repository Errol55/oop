public class Main {

    public static void main(String[] args) throws InvalidCharacter {
        String dna = "TCGGATCCGATG";

        FullDNA fullDNA = new FullDNA(dna);
        System.out.println("Full: " + fullDNA.toString());

        CompressedDNA compressedDNA = new CompressedDNA(dna);
        System.out.println("Compressed: " + compressedDNA.toString());

        System.out.println(compressedDNA.equals(fullDNA));
        System.out.println(fullDNA.equals(compressedDNA));
    }

}
