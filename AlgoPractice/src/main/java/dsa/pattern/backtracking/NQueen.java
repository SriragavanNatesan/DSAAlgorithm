package dsa.pattern.backtracking;

import java.util.*;

public class NQueen {

    private Set<Integer> colSet = new HashSet<>();
    private Set<Integer> diag1 = new HashSet<>();
    private Set<Integer> diag2 = new HashSet<>();

    public static void main(String[] args) {
        new NQueen().solveNQueens(4);
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), 0, n);
        return result;
    }

    private void dfs(List<List<String>> res, List<Integer> list, int row, int n) {
        if (row == n) {
            System.out.println(list);
            for(int x :list){
                char[] charArray = new char[n];
                Arrays.fill(charArray, '.');
                charArray[x] = 'Q';
                String rowString = new String(charArray);
                System.out.println(rowString);
            }
            System.out.println();
            return;
        }
        for (int col = 0; col < n; col++) {
            if(colSet.contains(col) || diag1.contains(row + col) || diag2.contains(row - col) ) continue;
            list.add(col);
            colSet.add(col);
            diag1.add(row + col);
            diag2.add(row - col);
            dfs(res, list, row + 1, n);
            list.remove(list.size() -1);
            colSet.remove(col);
            diag1.remove(row + col);
            diag2.remove(row - col);
        }
    }
}
