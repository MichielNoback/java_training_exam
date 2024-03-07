package nl.bioinf;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyUtils {

    /**
     * Finds and returns all words with the given substring. Does so case-insensitive.
     * If no match is found, an empty list is returned.
     * If the substring is empty, an IllegalArgumentException is thrown.
     * If the text is empty, an IllegalArgumentException is thrown.
     *
     * @param text
     * @param substringToFind
     * @return word
     * @throws IllegalArgumentException when no match found
     */
    public static List<String> findWordWithSubstring(String text, String substringToFind) {
        //YOUR CODE
        //throw new UnsupportedOperationException("Not yet implemented");

        //TODO -- REMOVE START
        if(text == null || text.isEmpty() || substringToFind == null || substringToFind.isEmpty()) {
            throw new IllegalArgumentException("Text or substring cannot be empty");
        }
        substringToFind = substringToFind.toUpperCase();
        List<String> results = new ArrayList<>();
        String[] result = text.split("[.,!?:; \s]+");
        for (String s : result) {
            if (s.toUpperCase().contains(substringToFind)) {
                results.add(s);
            }
        }
        return results;
        //TODO -- REMOVE END

    }
}
