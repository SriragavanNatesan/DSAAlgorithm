package dsa.pattern.backtracking;

import java.util.*;

/**
 * Problem Description
 * Given a array of integers A of size N and an integer B.
 *
 * Return number of non-empty subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Problem Constraints
 * 1 <= N <= 20
 *
 * 1 <= A[i] <= 1000
 *
 * 1 <= B <= N
 *
 *
 *
 * Input Format
 * The first argument given is the integer array A.
 *
 * The second argument given is the integer B.
 *
 *
 *
 * Output Format
 * Return number of subsequences of A of size B having sum <= 1000.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *     A = [1, 2, 8]
 *     B = 2
 * Input 2:
 *
 *     A = [5, 17, 1000, 11]
 *     B = 4
 *
 *
 * Example Output
 * Output 1:
 *
 * 3
 * Output 2:
 *
 * 0
 *
 *
 * Example Explanation
 * Explanation 1:
 *
 *  {1, 2}, {1, 8}, {2, 8}
 * Explanation 1:
 *
 *  No valid subsequence
 */
public class SIXLETS {

    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(1, 2, 3,4,5,6));
        int b = 3;
        List<List<Integer>> result = new ArrayList<>();
        int n = 3;
        generate(new ArrayList<>(), 0, result, n);
        System.out.println(result);
        System.out.println(result.size());
    }



    public int solve(ArrayList<Integer> A, int B) {
        return solve(A, B, 0, 0, 0);
    }

    public static int solve(ArrayList<Integer> A, int B, int index, int sum, int count){
        if(sum > 1000) return 0;
        if(count == B) return 1;
        if(index == A.size()) return 0;
        return solve(A, B, index + 1, sum + A.get(index), count + 1) + solve(A, B, index + 1, sum, count);

    }


    public static void solve(ArrayList<Integer> A, int B, int index, List<Integer> tmpList){
        if(tmpList.size() == B) result.add(new ArrayList<>(tmpList));
        if(tmpList.size()  > B) return;

        tmpList.add(0);
        solve(A, B, index + 1,  tmpList);
        tmpList.remove(tmpList.size() -1);

        tmpList.add(1);
        solve(A, B, index + 1, tmpList) ;
        tmpList.remove(tmpList.size() -1);
    }

    public static void generate(List<Integer> tmpList, int index, List<List<Integer>> result, int n){
        if(index == n){
            result.add(new ArrayList<>(tmpList));
            return;
        }
        tmpList.add(0);
        generate(tmpList, index + 1, result, n);
        tmpList.remove(tmpList.size() -1);

        tmpList.add(1);
        generate(tmpList, index + 1, result, n);
        tmpList.remove(tmpList.size() -1);
    }

}
