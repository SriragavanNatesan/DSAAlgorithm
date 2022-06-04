package com.sriragavan.backtracking;

import com.company.Main;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean board[][] = new boolean[n][n];
        System.out.println(queens(board, 0));
    }

    static int queens(boolean[][] board, int row) {
        if (row == board.length) {
            display(board, board.length);
            System.out.println();
            return 1;
        }
        int count =0;
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                count += queens(board, row + 1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //
        for (int i = 0; i < row; i++) {
            if (board[i][col]) {
                return false;
            }
        }

        // left diagonol
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (board[row - i][col - i]) {
                return false;
            }
        }

        //Right Diagonal
        int maxRight = Math.min(row,board.length - col - 1);
        for (int i=1;i<=maxRight;i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

            return true;
    }

    private static void display(boolean[][] board, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j]) {
                    System.out.print("Q ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
