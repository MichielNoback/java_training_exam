package nl.bioinf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class PositionIntensities {

    private static final char[] nucleotides = {'G', 'A', 'T', 'C'};
    private int scoreG;
    private int scoreA;
    private int scoreT;
    private int scoreC;

    private long position;

    public PositionIntensities(long position, int scoreG, int scoreA, int scoreT, int scoreC) {
        this.position = position;
        this.scoreG = scoreG;
        this.scoreA = scoreA;
        this.scoreT = scoreT;
        this.scoreC = scoreC;
    }

    /**
     * Returns the Basecall of this position.
     * @return
     */
    public Basecall getBasecall() {
        //YOUR CODE
        //throw new UnsupportedOperationException("Not yet implemented");

        //TODO -- REMOVE START
        int total = scoreG + scoreA + scoreT + scoreC;

        List<Basecall> basecalls = new ArrayList<>();
        basecalls.add(new Basecall('G', (double) scoreG / total));
        basecalls.add(new Basecall('A', (double) scoreA / total));
        basecalls.add(new Basecall('T', (double) scoreT / total));
        basecalls.add(new Basecall('C', (double) scoreC / total));
        basecalls.sort((o1, o2) -> Double.compare(o2.getProbability(), o1.getProbability()));
        Basecall best = basecalls.get(0);
        if (best.getProbability() < 0.6) {
            best.setNucleotide('N');
        }
        return best;
        //TODO -- REMOVE END
    }

    public int getScoreG() {
        return scoreG;
    }

    public int getScoreA() {
        return scoreA;
    }

    public int getScoreT() {
        return scoreT;
    }

    public int getScoreC() {
        return scoreC;
    }

    public long getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "PositionIntensities{" +
                "scoreG=" + scoreG +
                ", scoreA=" + scoreA +
                ", scoreT=" + scoreT +
                ", scoreC=" + scoreC +
                ", position=" + position +
                '}';
    }
}
