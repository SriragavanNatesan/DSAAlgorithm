package dsa.pattern.backtracking;

import java.util.*;

public class PermutationsII {

    public static void main(String[] args) {
        int nums[] = {1,1,2};
        System.out.println(new PermutationsII().permuteUnique(nums));
    }


    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for(int num:nums){
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        helper(nums, 0, new ArrayList<>(), freqMap, result);
        return result;
    }

    public void helper(int[] nums,int idx, List<Integer> list,Map<Integer, Integer>  freqMap, List<List<Integer>> result){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        for(Map.Entry<Integer, Integer> entry: freqMap.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();

            if(count == 0) continue;

            list.add(element);
            freqMap.put(element, count-1);
            helper(nums, idx + 1, list, freqMap, result);
            list.remove(list.size() -1);
            freqMap.put(element, count);

        }
    }

}
