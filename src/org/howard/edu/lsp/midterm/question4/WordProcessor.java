package org.howard.edu.lsp.midterm.question4;

import java.util.ArrayList;
import java.util.List;

/**
 * The WordProcessor class processes a sentence and finds all longest words.
 */
public class WordProcessor {
    private String sentence; // Stores the sentence to be processed

    /**
     * Constructor to initialize the sentence.
     * @param sentence The sentence to be processed.
     */
    public WordProcessor(String sentence) {
        this.sentence = sentence;
    }

    /**
     * This method finds all the longest words in the sentence.
     * @return List of words that have the maximum length in the sentence.
     */
    public List<String> findLongestWords() {
        List<String> longestWords = new ArrayList<>();
        if (sentence == null || sentence.trim().isEmpty()) {
            return longestWords; // Return empty list if no words exist
        }

        String[] words = sentence.trim().split("\\s+"); // Split by spaces (handling multiple spaces)
        int maxLength = 0;

        for (String word : words) {
            if (word.length() > maxLength) {
                maxLength = word.length();
                longestWords.clear(); // New longest word found, clear the old list
                longestWords.add(word);
            } else if (word.length() == maxLength) {
                longestWords.add(word); // Add word if it has the same max length
            }
        }
        return longestWords;
    }
}
