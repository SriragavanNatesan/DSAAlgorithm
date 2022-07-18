package com;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 4);
        map.put("c", 3);

//        #Approach 1
        for(String key: map.keySet()){
            System.out.println("Key = " + key + " : Value = " +map.get(key));
        }
//        Apprach 2

        System.out.println("==============");
        for (Map.Entry<String, Integer> entry:map.entrySet()){
            System.out.println("Key = " + entry.getKey() + " : Value = " + entry.getValue());
        }
        //

        System.out.println("=====Sort by value=========");
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, (a, b) -> a.getValue() - b.getValue());
        for(Map.Entry<String, Integer> entry :entryList){
            System.out.println("Key = " + entry.getKey() + " : Value = " + entry.getValue());
        }
    }
}
