import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int index = 0; //주문 인덱스
        int temp;
        
        for(int i=1; i<=order.length; i++){ //컨테이너벨트
            while(true){
                if(!stack.isEmpty()) {
                    temp = stack.pop();
                    if(temp == order[index]) {
                        answer++;
                        index++;
                    }
                    else {
                        stack.add(temp);
                        break;
                    }
                } 
                else break;
            }
            
            if(order[index] == i) {
                answer++;
                index++;
            }
            
            else stack.add(i);
        }
        
        while(true){
            if(!stack.isEmpty()) {
                temp = stack.pop();
                if(temp == order[index]) {
                    answer++;
                    index++;
                }
                else {
                    stack.add(temp);
                    break;
                }
            } 
            else break;
        }
        
        return answer;
    }
}