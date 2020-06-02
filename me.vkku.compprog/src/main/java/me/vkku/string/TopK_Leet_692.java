package me.vkku.string;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/*
    Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
            Output: ["i", "love"]
            Explanation: "i" and "love" are the two most frequent words.
            Note that "i" comes before "love" due to a lower alphabetical order.

    Input
    ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"]
    4
    Output
    ["the","is","sunny","day"]
*/
public class TopK_Leet_692 {

    Instant start = Instant.now();
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> wordFrequency = new TreeMap<>();
        List<String> wordList = Arrays.stream(words).collect(Collectors.toList());
        wordList.forEach(word -> {
            if(wordFrequency.get(word) != null){
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            }
            wordFrequency.computeIfAbsent(word, val -> 1);
        });

        return wordFrequency.entrySet()
                .parallelStream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .limit(k)
                .collect(Collectors.toList());
    }

    @Test
    public void testTopKFrequent(){
        TopK_Leet_692 topK_leet_692 = new TopK_Leet_692();
        String[] wordArr = {"i", "love", "leetcode", "i", "love", "coding"};
        topK_leet_692.topKFrequent(wordArr,  4);
        Instant finish = Instant.now();
        System.out.println("Duration : " + Duration.between(start, finish).toMillis());
    }

    @Test
    public void testTopKFrequenta(){
        String[] wordArr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        Map<String, Integer> wordFrequency = new TreeMap<>();
        List<String> str = Arrays.stream(wordArr).collect(Collectors.toList());
        str.forEach(word -> {
            if(wordFrequency.get(word) != null){
                wordFrequency.put(word, wordFrequency.get(word) + 1);
            }
            wordFrequency.computeIfAbsent(word, val -> new Integer(1));
        });
    }
}