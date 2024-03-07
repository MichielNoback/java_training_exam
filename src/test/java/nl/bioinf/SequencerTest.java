package nl.bioinf;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SequencerTest {

    @Test
    void readIntensities() {
        Sequencer sequencer = new Sequencer();
        String intensitiesFile = "data/sequencer_data.txt";
        List<PositionIntensities> positionIntensities = sequencer.readIntensities(intensitiesFile);
        assertNotNull(positionIntensities);
        assertEquals(30, positionIntensities.size());
        assertEquals(1, positionIntensities.get(0).getPosition());
        assertEquals(89, positionIntensities.get(0).getScoreG());
        assertEquals(21, positionIntensities.get(1).getScoreA());
        //positionIntensities.forEach(System.out::println);
    }

    @Test
    void executeBasecalls() {
        Sequencer sequencer = new Sequencer();
        List<PositionIntensities> intensities;
        intensities = sequencer.fetchBackupData();
        List<Basecall> basecalls = sequencer.executeBasecalls(intensities);

        assertNotNull(basecalls);
        assertEquals(30, basecalls.size());
        assertEquals('G', basecalls.get(0).getNucleotide());
        assertEquals('G', basecalls.get(1).getNucleotide());
        assertEquals('C', basecalls.get(2).getNucleotide());
        assertEquals('N', basecalls.get(3).getNucleotide());
        //basecalls.forEach(System.out::println);
    }


}