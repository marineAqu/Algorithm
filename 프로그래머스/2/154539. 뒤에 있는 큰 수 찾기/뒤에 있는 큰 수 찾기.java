import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        int now;
        Arrays.fill(answer, -1);
        
        Stack<Integer> stack = new Stack<>();
        stack.add(numbers[numbers.length-1]);
        
        for(int i=numbers.length-2; i>=0; i--){
            while(!stack.isEmpty()){
                now = stack.pop();
                
                if(now <= numbers[i]) continue;
                
                else {
                    answer[i] = now;
                    stack.add(now);
                    break;
                }
            }
            
            stack.add(numbers[i]);
        }
        
        return answer;
    }
}