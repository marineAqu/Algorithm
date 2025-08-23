import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Integer> stack = new Stack<>();
        int now;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') now = 0;
            else now = 1;
            
            if(now == 0 || stack.isEmpty()){
                stack.add(now);
                continue;
            }
            
            //now == 1 && stack != empty 인 경우
            if(stack.peek() == 0) stack.pop();
            else return false;
        }

        if(stack.isEmpty()) return true;
        else return false;
    }
}