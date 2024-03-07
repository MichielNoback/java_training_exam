package nl.bioinf;

public class Basecall {
    public static final char AMBIGUITY = 'N';
    protected char nucleotide;
    protected double probability;

    public Basecall(char nucleotide, double probability) {
        this.nucleotide = nucleotide;
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Basecall{" +
                "nucleotide=" + nucleotide +
                ", probability=" + probability +
                '}';
    }

    public char getNucleotide() {
        return nucleotide;
    }

    public double getProbability() {
        return probability;
    }

    public void setNucleotide(char nucleotide) {
        this.nucleotide = nucleotide;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }
}
