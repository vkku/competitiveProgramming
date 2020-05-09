package main.java.arrays;

import org.junit.Test;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FarthestCountTest {

    @Test
    public void testUrlEncoder() throws IOException {
/*
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT

        //Scanner
        Scanner s = new Scanner(System.in);
        String name2 = s.nextLine();                 // Reading input from STDIN
        System.out.println("Hi, " + name + ".");    // Writing output to STDOUT


        // Write your code here
        Map<Integer, Integer> mapA = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mapB = new HashMap<Integer, Integer>();
        mapA.put(1, 1);
        mapB.put(1, 2);
        Map<Integer, Map<Integer, Integer>> mapinMap = new HashMap<>();
        Map<Integer, Map<Integer, Integer>> mapinMapB = new HashMap<>();
        mapinMap.put(1, mapA);
        mapinMapB.put(1, mapB);
        HashSet<Map<Integer, Map<Integer, Integer>>> integerSet = new HashSet();
        integerSet.add(mapinMap);
        integerSet.add(mapinMapB);
        System.out.println(integerSet);*/

/*
        //max-heap
        PriorityQueue<Map<Integer, Map<Integer, Integer>>> pQueue = new PriorityQueue<>(Collections.reverseOrder());

        Map<Integer, Integer> intMap = new HashMap<>();
        intMap.put(1, 1);
        intMap.put(2, 2);
        Map<Integer, Integer> intMap2 = new HashMap<>();
        intMap2.put(2, 1);
        intMap2.put(3, 2);
        Map<Integer, Map<Integer, Integer>> relMap = new HashMap<>();
        relMap.put(2, intMap);
        relMap.put(3, intMap2);
        pQueue.add(relMap);
        while (!pQueue.isEmpty()){
            System.out.println(pQueue.poll());
        }*/

        PriorityQueue<Map<Integer, Integer>> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        pQueue.add(new HashMap<Integer, Integer>(){
            {
                put(5, 5);
                put(2, 2);
                put(13, 1);
                put(17, 1);
                put(22, 1);
            }
        });

        while (!pQueue.isEmpty()){
            System.out.println(pQueue.poll());
        }



    }
}

