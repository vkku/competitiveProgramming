package me.vkku.string;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class TopK_Leet_692_5ms {

        Instant start = Instant.now();
        public List<String> topKFrequent(String[] words, int k) {
            // hashmap to store <word, occcurence>. Heap to sort. Sort k times -> k * log(n). Note: for the last one, look for its kids and compare alphabetically.
            Map<String, Integer> frequency = new HashMap();
            int length = words.length;
            List<String> output = new ArrayList();

            for(int i = 0; i < length; i ++) {
                if(frequency.containsKey(words[i])) {
                    frequency.put(words[i], frequency.get(words[i]) + 1);
                }
                else {
                    frequency.put(words[i], 1);
                }
            }
            PriorityQueue<Map.Entry<String, Integer>> order = new PriorityQueue(length, new Comparator<Map.Entry<String,Integer>>() {
                @Override
                public int compare(Map.Entry<String,Integer> t1, Map.Entry<String,Integer> t2) {
                    if(t1.getValue() > t2.getValue()) {
                        return -1;
                    }
                    else if(t1.getValue() == t2.getValue()) {
                        return (t1.getKey().compareTo(t2.getKey()) < 0)?-1:1;
                    }
                    else {
                        return 1;
                    }
                }
                @Override
                public boolean equals (Object obj) {
                    return true;
                }
            });
            //order.addAll(frequency);
            for(Map.Entry<String,Integer> entry:frequency.entrySet()) {
                order.add(entry);
            }
            for(int i = 0; i < k; i ++) {
                output.add(order.poll().getKey());
            }
            return output;

        }

    @Test
    public void testTopKFrequent(){
        TopK_Leet_692_5ms topK_leet_692 = new TopK_Leet_692_5ms();
        String[] wordArr = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        topK_leet_692.topKFrequent(wordArr,  4);
        Instant finish = Instant.now();
        System.out.println("Duration : " + Duration.between(start, finish).toMillis());
    }

}
