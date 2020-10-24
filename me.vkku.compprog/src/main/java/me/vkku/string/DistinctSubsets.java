package src.main.java.me.vkku.string;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class DistinctSubsets {

    public static int distinctSubsets(String str) {
        List<String> subStrings = generateSubstrings(str);
        return getDistinctSubsetCount(subStrings);
    }

    private static int getDistinctSubsetCount(List<String> subStrings) {
        int distinctSubsets = 0;
        for (String subString : subStrings) {
            if (!containsDuplicate(subString)) {
                distinctSubsets++;
            }
        }
        return distinctSubsets;
    }

    private static List<String> generateSubstrings(String str) {
        List<String> subStrings = new ArrayList<>();
        for (int i = 0; i < str.length() ; i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                subStrings.add(str.substring(i, j));
            }
        }
        return subStrings;
    }


    public static boolean containsDuplicate(String str) {
        boolean containsDupe = false;
        Set<String> subsetContainingSet = new HashSet<>();
        char[] setCharacters = str.toCharArray();
        for (char setCharacter : setCharacters) {
            if (subsetContainingSet.contains(Character.toString(setCharacter))) {
                containsDupe = true;
            } else {
                subsetContainingSet.add(Character.toString(setCharacter));
            }
        }
        return containsDupe;
    }

    @Test
    public void distinctSetsAreSix(){
        String str = "abc";
        assertEquals(distinctSubsets(str), 6);
    }

    @Test
    public void substringGenerationCheck(){
        assertEquals(generateSubstrings("abc"), Arrays.asList("a", "ab", "abc", "b", "bc", "c"));
    }




















}