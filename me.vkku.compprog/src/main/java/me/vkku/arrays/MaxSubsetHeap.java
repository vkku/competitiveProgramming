package me.vkku.arrays;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
        PriorityQueue<Map<Integer, Integer>> pQueue = new PriorityQueue<>(Collections.reverseOrder());
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
        AtomicInteger i = new AtomicInteger(0);
        Map<Integer, Integer> indexCounterMap= new TreeMap<>();
        indexCounterList.forEach(indexFrequency -> {
            indexCounterMap.put(i.getAndAdd(1), indexFrequency);
        });

        //pQueue.add(indexCounterMap);

        Map<Integer,Integer> priorityMap =
        indexCounterMap.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                                          Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        List<Integer> maxArrayList = new ArrayList<>();
        for(Integer item : defaultArrayList) {
            maxArrayList.add(item);
        }

        Collections.sort(maxArrayList, Collections.reverseOrder());


        Integer[] subsettedArray = new Integer[defaultArrayList.size()];

        Set<Integer> priorityIndexes = priorityMap.keySet();
        Integer[] priorityIndexArray = priorityIndexes.toArray(new Integer[defaultArray.length()]);
        for(int count = 0 ; count < priorityIndexes.size() ; count++){
            subsettedArray[priorityIndexArray[count]] = maxArrayList.get(count);
        }





            testCases--;
        }
    }
}