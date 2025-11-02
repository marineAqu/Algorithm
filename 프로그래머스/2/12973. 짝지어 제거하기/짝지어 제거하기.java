import java.util.*;

class Solution {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        char now, before;
        for(int i=0; i<s.length(); i++){
            if(!stack.isEmpty()) {
                now = stack.pop();
                
                if(now == s.charAt(i)) {
                    while(stack.size() >= 2){
                        now = stack.pop();
                        before = stack.pop();
                        
                        if(now != before){
                            stack.add(before);
                            stack.add(now);
                            break;
                        }
                    }
                }
                else{
                    stack.add(now);
                    stack.add(s.charAt(i));
                }
            }
            
            else stack.add(s.charAt(i));
        }

        return stack.isEmpty() ? 1 : 0;
    }
}