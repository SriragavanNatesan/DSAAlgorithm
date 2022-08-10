package dsa.pattern.backtracking;

public class Recursion {

    public static void main(String[] args) {
        solve(4);
    }

    public static void solve(int n){
        if(n == 0) return;
        System.out.println(n);
        solve(n-1);
    }

    public static void solve2(int n){
        if(n == 0) return;
        solve2(n-1);
        System.out.println(n);
    }
}
