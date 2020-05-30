package me.vkku.network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class EdgeList {

    public void edgeListRepresentation(ArrayList<String> edges){
        Map<String, List<String>> edgeList = edges
                .stream()
                .map(line -> line.split(","))
                .collect(Collectors.groupingBy(
                        tuple -> tuple[0],
                        Collectors.mapping(
                                tuple -> tuple[1].trim(),
                                Collectors.toList())
                ));

    }

     public static void main(String[] args) throws IOException {
        EdgeList edgeList = new EdgeList();
        edgeList.edgeListRepresentation(new ArrayList<String>(){
            {
                add("A, B");
                add("A, C");
                add("A, E");
                add("B, C");
                add("C, E");
                add("C, D");
                add("D, E");
            }
        });
    }


}
