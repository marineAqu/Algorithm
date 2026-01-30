import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        boolean flag = true;
        int index = 0;
        
        for(int i=0; i<s.length(); i++){
            
            stack.clear();
            flag = true;
            
            for(int r=0; r<s.length(); r++){
                index = (r+i) % s.length();
                
                if(s.charAt(index) == '('){
                    stack.add(1);
                }
                
                else if(s.charAt(index) == '['){
                    stack.add(2);
                }
                
                else if(s.charAt(index) == '{'){
                    stack.add(3);
                }
                
                else if(stack.isEmpty()){
                    flag = false;
                    break;
                }
                
                else if(s.charAt(index) == ')'){
                    if(stack.peek() != 1) {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
                
                else if(s.charAt(index) == ']'){
                    if(stack.peek() != 2) {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
                
                else if(s.charAt(index) == '}'){
                    if(stack.peek() != 3) {
                        flag = false;
                        break;
                    }
                    else stack.pop();
                }
            }
            
            if(flag && stack.size() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}