package dsa.pattern.array;
import java.util.*;

public class LargestNumber {

    public static void main(String[] args) {
        int nums[] =  {3, 30, 34, 5, 9};
        System.out.println(largestNumber(Arrays.asList(0,0,0,0)));
    }

    public static String largestNumber(final List<Integer> nums) {
        String result = "";
        Collections.sort(nums, (a, b) -> (String.valueOf(b) + a).compareTo(String.valueOf(a) + b));
        int count = 0;
        for (int num: nums){
            if(num == 0 )
                count++;
            result += num;
        }
        return (count == nums.size()  ) ? "0" :result;
    }
}
