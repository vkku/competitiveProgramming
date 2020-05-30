package me.vkku.string;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/discuss/interview-question/542597/
public class TopK_Words {

    public void countWords(int k, String[] keywords, String[] review){

        List<String> reviewList = Arrays.asList(review);
        List<String> reviewWords = null;
        reviewList.stream().filter(e -> reviewWords.add(e));
        System.out.println(review);


    }
     public static void main(String[] args) throws IOException {
        TopK_Words top = new TopK_Words();
         String[] keywords = {"anacell", "cetracular", "betacellular"};
         String[] review = { "Anacell provides the best services in the city",
                 "betacellular has awesome services",
                 "Best services provided by anacell, everyone should use anacell",};
         top.countWords(2, keywords, review);
    }

}
