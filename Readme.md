
############################################################
######## THIS IS A TRAINING EXAM FOR THE JAVA COURSE  ######
############################################################


## Test header (tentamen voorblad)

- **Teacher** Michiel Noback (NOMI), to be reached at +31 50 595 4691
- **Scanned by** KEMC
- **Test size** XXXX assignments (with subquestions)
- **Aiding materials** Computer on the BIN network
- **Supplementary materials**  
    - The Java e-book, on your Desktop.  
- **TO BE SUBMITTED  
This project, as `zip` archive. Use this name for the zip:  
 `JavaAssessment<YOURNAME>-<YOURSTUDENTNUMBER>.zip`**

## Instructions
On your Desktop you will find the assessment as a Gradle-managed Java project, as well as the submit script `submit_your_work`.

First start IntelliJ in evaluation mode:

1. Start IntelliJ
2. Choose "Do not import settings"
3. Accept licence (first scroll down)
4. Choose "Don't send statistics"
5. Choose "Skip remaining and set defaults"
6. Check the box "Evaluate for free" and click "Activate"
7. Choose "Open" in "Welcome to IntelliJ" window
8. Navigate to `~/Desktop/JavaAssessment…/` and select the assessment project folder to open it
10. Since this project requires Java >11, it may be necessary to specify the JDK (via File -> Project Structure); it is located at `/usr/local/jdk-11.....`

Next, deal with the assignments.
After finishing, create a zip using terminal command `zip -r <ziparchivename.zip> <folder_to_add/>`. Check the correctness of the zip contentrs and name(see above). Submit it using the provided submit script.
Type `submit_your_work --help` in the terminal to get help on its usage.

The possible number of points to be scored are indicated for all assignments.
Your grade will be calculated as  
`double grade = 1 + (total/maximumPoints * 9);`


**WARNING! This assessment is partially graded automatically.** You need to be extra careful to follow the instructions exactly!
**_Please do not submit code that does not compile because all tests will fail!_**


## The Assignments

Folder `src/main/java` is the base folder for all "production" code. Here you will find Java class files that are referred to from the assignments. JUnit tests should end up in `src/test/java`. 

You may create `main()` methods wherever you think they help you implement functionality. Alternatively, you may create test classes and -methods using JUnit.


### Assignment 1 - Test-Driven Design (20 points)

In class `MyUtils` you will find method `findWordWithSubstring()`.
The method has this signature:

```java
public static List<String> findWordWithSubstring(String text, String substringToFind)
```

The Javadoc of this method defines the features to implement.


#### Assignment 1A (10 points)

Write a test suite covering the `findWordWithSubstring()` method, taking the above features into account.

#### Assignment 1B (10 points)

Implement the method `findWordWithSubstring()` correctly so that all you tests pass (and the features have been implemented).

You can use this pattern to split a text into words: `"[.,!?:; \s]+"`


### The Sequencer case

Switching to a new topic, involving three classes: `Sequencer`, `PositionIntensities` and `Basecall`.  
The `Basecall` class itself is already finished - there is nothing you need to implement there.

DNA sequencers are never really sure about the base call; it is a matter of probabilities.
In file `data/sequencer_data.txt` you will find a hypothetical representation of this type of data.
Here is a small sample of the data file: 

```
POS	G	A	T	C
1	89	11	9	4
2	76	21	10	6
3	17	15	11	95
```

For each position in a DNA sequence (the rows) the signal intensity score for each of the four nucleotides is given 
(the columns). 

You will be working on processing this data into actual basecalls - the nucleotide determination of each
 position. 

#### Assignment 2 (10 points)

Let's start with the actual basecalling. In class `PositionIntensities` you will find method
 `getBasecall()`. It has this signature:

```java
public Basecall getBasecall()
```

It is up to you to implement this method correctly according to the following specifications.
First calculate the probability of each nucleotide using this formula:

$$P_N = \frac{score_N}{score_G + score_A + score_T + score_C}$$

Where $P_N$ is the probability of nucleotide $N$.  

Now, if the Probability of the highest-scoring nucleotide is above or equal to 0.6, you can safely 
call it as that nucleotide. Otherwise, you need to make it an ambiguous Basecall and assign nucleotide 'N', 
with the probability of the highest-scoring nucleotide.  

Return the appropriate `Basecall` instance. 

There is a test method in class `PositionIntensities` that you can use to verify your implementation.

Hint: first create all four Basecall instances, and then find and return the best of these.


#### Assignment 3 (10 points)

Switching to class `Sequencer`.
The controller of this process will be your `main()` method located, in class `Sequencer`.

The first part of `main()` calls `readIntensities()`:

```java
Sequencer sequencer = new Sequencer();
List<PositionIntensities> intensities;
intensities = sequencer.readIntensities("data/sequencer_data.txt");
```

This method is partly implemented, reading the file `data/sequencer_data.txt`. 
Some boilerplate functionality has already been provided:

```java
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
```

Implement the rest of this method. 
You can use `SequencerTest.readIntensities()` to test your implementation.


#### Assignment 4 (6 points)

If you failed to implement `readIntensities()` of the previous assignment, you can switch 
to the hardcoded listing of intensities, just switch to dummy data by (un)commenting in main(), like this:

```java
//intensities = sequencer.readIntensities("data/sequencer_data.txt");
//OR, if you did not succeed with file reading
intensities = fetchBackupData(); //UNCOMMENTED THIS LINE TO BE ABLE TO PROCEED
```

The next line in `main()` is this:

```java
List<Basecall> basecalls = sequencer.executeBasecalls(intensities);
```

**Implement method `executeBasecalls()` in class `Sequencer`**.

You can use `SequencerTest.executeBasecalls()` to test your implementation.


#### Assignment 5 (15 points)

The final part of `main()` revolves around determining the overall quality of the sequencing run.
It is determined by calling `sequencer.determineRunQuality(basecalls)`.

The quality is returned in the form of a `RunQualirty` instance, which is a simple record:

```java
public record RunQuality(double averageProbability, int numberOfAmbiguities) { }
```

**Implement method `determineRunQuality()` in class `Sequencer`**.



<hr />


#### END OF TEST

