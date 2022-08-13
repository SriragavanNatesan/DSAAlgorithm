package dsa.pattern.backtracking;


import java.util.*;

public class NumberofSquarefulArrays {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(List.of(16777, 1179, 265, 135, 90, 135, 34 ));
        System.out.println(new NumberofSquarefulArrays().solve(list));
    }

    int count = 0;
    public int solve(ArrayList<Integer> A) {
        if (A.size() == 0) {
            return 0;
        }
        Collections.sort(A);
        int[] temp = new int[A.size()];
        for(int i=0;i<A.size();i++)
            temp[i] = A.get(i);
        boolean used[] = new boolean[A.size()];
        backTracking2(temp, used, new ArrayList<>());
        System.out.println("---------------------------");
        Arrays.fill(used, false);
        backTracking(A, new ArrayList<>(), used);
        return count;
    }

    private void backTracking(ArrayList<Integer> A, ArrayList<Integer> list,boolean used[]) {
        if(list.size() == A.size()){
            count++;
            System.out.println(list);
            return;
        }
        for(int i=0;i<A.size();i++){
            if(used[i] || (i - 1 >= 0 && A.get(i) == A.get(i-1) && !used[i-1])) continue;
            if(list.size() == 0 || isSqrt(list.get(list.size() - 1) + A.get(i)) ){
                used[i] = true;
                list.add(A.get(i));
                backTracking(A, list, used);
                used[i] = false;
                list.remove(list.size()-1);
            }
        }
    }


    private void backTracking2(int[] A, boolean[] used, List<Integer> list) {
        if (list.size() == A.length) {
            count ++;
            System.out.println(list);
            return;
        }
        for (int i = 0; i < A.length; i ++) {
            if (used[i] || (i - 1 >= 0 && A[i] == A[i - 1] && !used[i - 1])) continue;
            if (list.size() == 0 || isSqrt(list.get(list.size() - 1) + A[i])) {
                list.add(A[i]);
                used[i] = true;
                backTracking2(A, used, list);
                list.remove(list.size() - 1);
                used[i] = false;
            }
        }
    }
    private boolean isSqrt(int num) {
        double r = Math.sqrt(num);
        return ((r - Math.floor(r)) == 0);
    }
}
