package dsa.pattern.binarysearch;

import java.util.Map;

public class PaintersPartitionProblem {

    public int paint(int painters, int timeUnit, int[] board) {
        int mod = 10000003;
        long max = 0;
        long totalSum = 0;
        for(int height:board){
            max = Math.max(max, height);
            totalSum+= height;
        }

        long start  = max ;
        long end = totalSum ;
        long result = 0;
        while (start <= end){
            long mid = start + (end - start) / 2;
            if(isPossible(painters, board, mid)){
                result = mid;
                end = mid  - 1;
            }else{
                start = mid + 1;
            }
        }
            return  (int)((result * timeUnit) % mod);
    }

    private boolean isPossible(int painters, int[] board, long mid) {
        long sum = 0;
        long count= 0;
        for(int x:board){
            sum+= x;
            if(sum > mid){
                count++;
                sum = x;
            }
        }
        if(sum != 0){
            count++;
        }
        return count <= painters;
    }


    public static void main(String[] args) {
        int painters = 2;
        int timeUnit = 5;
        int[] board = {1, 10};

        System.out.println(new PaintersPartitionProblem().paint(painters, timeUnit, board));
    }
}
