package dsa.pattern.backtracking;

import java.util.*;

public class RemoveInvalidParentheses {

    public static void main(String[] args) {
        System.out.println(new RemoveInvalidParentheses().solve("))())()))(()(("));
    }
    Set<String> set = new HashSet<>();
    Map<String, Integer> map = new HashMap<>();
    public ArrayList<String> solve(String s) {

        solve(s, getMinInvalid(s));
        return new ArrayList<>(set);
    }

    public void solve(String s, int minInvalid) {

        if(map.containsKey(s)){
            return;
        }else{
            map.put(s, map.getOrDefault(s, -1) + 1);
        }
        if(minInvalid < 0)
            return;

        if(minInvalid == 0){
            if(getMinInvalid(s) == 0)
                set.add(s);
            return;
        }

        for(int i=0;i<s.length();i++){
            String left = s.substring(0, i);
            String right = s.substring(i+1);
            solve(left + right, minInvalid -1);
        }
    }

    public int getMinInvalid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(')
                stack.push('(');
            else if(s.charAt(i) == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                }else{
                    stack.push(')');
                }
            }
        }
        return stack.size();
    }
}
