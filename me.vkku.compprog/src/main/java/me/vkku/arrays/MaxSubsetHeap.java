package me.vkku.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSubsetHeap {

    public static void main(String[] args){
    //Input Test Cases Count
    Scanner sc = new Scanner(System.in);
    Integer testCases = Integer.parseInt(sc.nextLine().trim());

        while(testCases > 0){

        //Input Arr Length and SubArr length
        String arrLenSubArr = sc.nextLine().trim();

        List<Integer> arrLenSubArrList = Arrays.stream(arrLenSubArr.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        //Input Array
        String defaultArray = sc.nextLine().trim();
        List<Integer> defaultArrayList = Arrays.stream(defaultArray.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<List<Integer>> subsetList = new ArrayList<>();
        //max-heap
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
        int[] indexCounter;
        indexCounter = new int[defaultArrayList.size()];

        //Input SubSets
        for(int i = 0 ; i < arrLenSubArrList.get(1) ; i++){
            String subsetIndex = sc.nextLine();
            subsetList.add(Arrays.stream(subsetIndex.split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }

        subsetList.forEach(subsetListItem -> {
            for(int i = subsetListItem.get(0) - 1 ; i <= subsetListItem.get(1) - 1 ; i++){
                indexCounter[i]++;
            }
        });

        List<Integer> indexCounterList = Arrays.stream(indexCounter).boxed().collect(Collectors.toList());

        //Populate max-heap
        indexCounterList.forEach(indexFrequency -> {
            pQueue.add(indexFrequency);
        });

        List<Integer> maxArrayList = new ArrayList<>();
        for(Integer item : defaultArrayList) {
            maxArrayList.add(item);
        }

        Collections.sort(maxArrayList, Collections.reverseOrder());


        Integer[] subsettedArray = new Integer[defaultArrayList.size()];
        /*
        for(int i = 0 ; i < defaultArrayList.size() - 1 ; i++){
            subsettedArray[i] = maxArrayList.get(i);
        }*/


         int index = 0;
         while(!pQueue.isEmpty()){
             if(subsettedArray[pQueue.peek()] == null){
                 subsettedArray[pQueue.poll()] = maxArrayList.get(index++);
             }

         }




            testCases--;
        }
    }
}