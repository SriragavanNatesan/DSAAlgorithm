package dsa.pattern.backtracking;

import java.util.ArrayList;

public class GenerateallParentheses {
    public static void main(String[] args) {
        System.out.println(new GenerateallParentheses().generateParenthesis(2));
    }


    ArrayList <String> respList = new ArrayList<>();

    public ArrayList<String> generateParenthesis(int A){
        int open =0, close=0;
        generate(A, "", open,close);
        return respList;
    }

    public void generate(int A, String s, int open, int close){

        // happy case where s = 2* A means contains equal number of brackets
        if (s.length()== 2*A){
            respList.add(s);
            return;
        }

        // Conditions to continue
        // open count is less than A - we can keep on adding open brackets
        if (open < A) generate(A, s+"(", open+1, close);
        // close count is less than open  - we can keep on adding close brackets
        if (close < open) generate(A, s+")", open, close+1);

    }
}
