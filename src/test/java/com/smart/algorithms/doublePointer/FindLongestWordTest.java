package com.smart.algorithms.doublePointer;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FindLongestWordTest {

    @Test
    void findLongestWord() {
        String longestWord = FindLongestWord.findLongestWord("abpcplea", new ArrayList<String>() {{
            add("a");
            add("b");
            add("c");
        }});
        assertEquals("a", longestWord);

        String longestWord2 = FindLongestWord.findLongestWord("abpcplea", new ArrayList<String>() {{
            add("ale");
            add("apple");
            add("monkey");
            add("plea");
        }});
        assertEquals("apple", longestWord2);
    }
}