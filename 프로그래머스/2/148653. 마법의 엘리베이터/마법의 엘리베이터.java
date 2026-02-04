import java.util.*;

class Solution {
    public int solution(int storey) {
        int answer = 0;
        int flag = 10;
        int n;
        
        while(storey > 0){
            n = storey % flag;
            storey /= flag;
            
            if(n < 5){
                answer += n;
            }
            else if(n > 5){
                answer += 10 - n;
                storey++;
            }
            else{
                if(storey % flag >= 5) {
                    answer += 5;
                    storey++;
                }
                else answer += 5;
            }
            System.out.println(answer);
        }
        //0층에서 10000층에서 20000층 가고 16000층 가서 15600층 가고 15560층 가서 15555층
        //1 + 1+ 4 + 4 + 4 + 5
        
        //-5 해서 40만들고, -4 해야함
        return answer;
    }
}