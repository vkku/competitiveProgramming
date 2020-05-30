package me.vkku.quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Math.abs;

public class FarthestCount {
    public static void farthest(String[] args) throws IOException {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();                // Reading input from STDIN

        //Scanner
        Scanner s = new Scanner(System.in);
        String numbers = s.nextLine();                 // Reading input from STDIN

        String[] numArr = numbers.split(" ");
        List<String> numArrList = new ArrayList<String>(numArr.length);
        for (String am : numArr) {
            numArrList.add(am);
        }
        List<Integer> numIntList = numArrList.stream().map(Integer::parseInt).collect(Collectors.toList());

        Collections.sort(numIntList);

        Integer smallest = abs(numIntList.get(0));
        Integer largest = abs(numIntList.get(numIntList.size() - 1));

        Integer distance = largest - smallest > 0 ? largest : smallest;

        if (distance == smallest) {
            System.out.println("-" + smallest);
        } else {
            System.out.println(largest);
        }

    }


}
