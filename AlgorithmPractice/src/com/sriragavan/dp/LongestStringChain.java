package com.sriragavan.dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-string-chain/
public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a","b","ba","bca","bda","bdca"};
        System.out.println(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int result = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for(String word:words){
            int max = 0;
            for(int i=0;i<word.length();i++){
                String prev = word.substring(0, i) + word.substring(i+1);
                max = Math.max(max, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, max);
            result = Math.max(result, max);
        }

        return result;
    }

}
