package nl.bioinf;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyUtilsTest {

    //TODO -- REMOVE START

    @Test
    void findWordWithSubstring_normal() {
        String text = "The quick brown fox ;jumps; over the lazy dog, lying there";
        String substringToFind = "the";
        List<String> wordWithSubstring = MyUtils.findWordWithSubstring(text, substringToFind);
        assertEquals(3, wordWithSubstring.size());
        assertEquals("The", wordWithSubstring.get(0));
    }

    @Test
    void findWordWithSubstring_no_match() {
        String text = "The quick brown fox ;jumps; over the lazy dog, lying there";
        String substringToFind = "Foo";
        List<String> wordWithSubstring = MyUtils.findWordWithSubstring(text, substringToFind);
        assertTrue(wordWithSubstring.isEmpty());
    }

    @Test
    void findWordWithSubstring_empty_text() {
        String text = "";
        String substringToFind = "Foo";
        assertThrows(IllegalArgumentException.class, () -> MyUtils.findWordWithSubstring(text, substringToFind));
    }

    @Test
    void findWordWithSubstring_empty_substring() {
        String text = "The quick brown fox ;jumps; over the lazy dog, lying there";
        String substringToFind = "";
        assertThrows(IllegalArgumentException.class, () -> MyUtils.findWordWithSubstring(text, substringToFind));
    }
    //TODO -- REMOVE END



}