package nl.bioinf;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Sequencer {

    public static void main(String[] args) {
        Sequencer sequencer = new Sequencer();
        List<PositionIntensities> intensities;
        intensities = sequencer.readIntensities("data/sequencer_data.txt");
        //OR, if you did not succeed with file reading
        //intensities = fetchBackupData();

        List<Basecall> basecalls = sequencer.executeBasecalls(intensities);
        RunQuality runQuality = sequencer.determineRunQuality(basecalls);
        System.out.println(runQuality);
        printSequence(basecalls);
    }

    public List<PositionIntensities> readIntensities(String intensitiesFile) {
        Path path = Paths.get(intensitiesFile);

        try(BufferedReader reader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
            String currentLine = null;
            while((currentLine = reader.readLine()) != null) {
                //System.out.println(currentLine);
                //PROCEED FROM HERE

            }
        }catch(IOException ex){
            ex.printStackTrace();
        }

        return null;
    }

    /**
     * executes Basecalling on all Positions
     * @param intensities
     * @return
     */
    public List<Basecall> executeBasecalls(List<PositionIntensities> intensities) {
        //YOUR CODE
        throw new UnsupportedOperationException("Not yet implemented");

    }


    public RunQuality determineRunQuality(List<Basecall> basecalls) {
        //YOUR CODE
        throw new UnsupportedOperationException("Not yet implemented");

    }

    /**
     * prints the qenerated sequence
     * @param basecalls
     */
    private static void printSequence(List<Basecall> basecalls) {
        basecalls.forEach(bc -> System.out.print(bc.nucleotide));
    }



    /**
     * !! DO NOT EDIT THIS METHOD IT MAY CORRUPT YOUR TEST !!
     * utility method for when you fail to load the data from file
     * @return backup data
     */
    public static List<PositionIntensities> fetchBackupData() {
        List<PositionIntensities> intensities = new ArrayList<>();
        PositionIntensities positionIntensities;

        positionIntensities = new PositionIntensities(1, 89, 11, 9, 4);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(2, 76, 21, 10, 6);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(3, 17, 15, 11, 95);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(4, 29, 11, 9, 14);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(5, 16, 21, 81, 11);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(6, 12, 75, 9, 7);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(7, 16, 19, 98, 6);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(8, 77, 81, 10, 12);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(9, 18, 89, 13, 15);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(10, 13, 22, 14, 81);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(11, 19, 21, 10, 85);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(12, 11, 11, 12, 94);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(13, 9, 15, 99, 6);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(14, 79, 28, 80, 23);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(15, 73, 20, 11, 9);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(16, 76, 21, 10, 18);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(17, 16, 16, 100, 6);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(18, 17, 18, 92, 7);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(19, 7, 16, 10, 69);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(20, 79, 19, 11, 2);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(21, 8, 81, 13, 9);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(22, 6, 20, 10, 96);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(23, 76, 20, 10, 6);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(24, 79, 19, 16, 12);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(25, 9, 14, 87, 10);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(26, 8, 15, 86, 14);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(27, 7, 73, 59, 3);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(28, 14, 96, 41, 7);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(29, 19, 18, 20, 78);
        intensities.add(positionIntensities);

        positionIntensities = new PositionIntensities(30, 18, 83, 11, 10);
        intensities.add(positionIntensities);

        return intensities;
    }

}
