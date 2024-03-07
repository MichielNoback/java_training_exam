package nl.bioinf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositionIntensitiesTest {

    @Test
    void getBasecall() {
        PositionIntensities ps1 = new PositionIntensities(1, 89, 11, 9, 4);
        Basecall basecall = ps1.getBasecall();
        System.out.println("basecall = " + basecall);
        assertEquals('G', basecall.nucleotide);
        assertEquals((double)89 / (89 + 11 + 9 + 4), basecall.probability);


        PositionIntensities ps2 = new PositionIntensities(2, 17, 15, 10, 95);
        basecall = ps2.getBasecall();
        System.out.println("basecall = " + basecall);
        assertEquals('C', basecall.nucleotide);
        assertEquals((double)95 / (17 + 15 + 10 + 95), basecall.probability);

        PositionIntensities ps3 = new PositionIntensities(2, 17, 15, 10, 25);
        basecall = ps3.getBasecall();
        System.out.println("basecall = " + basecall);
        assertEquals('N', basecall.nucleotide);
        assertEquals((double)25 / (17 + 15 + 10 + 25), basecall.probability);

    }
}