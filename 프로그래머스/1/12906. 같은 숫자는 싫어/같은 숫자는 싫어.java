import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        int bef = arr[0];
        int count = arr.length;
        
        for(int i=1; i<arr.length; i++){
            if(arr[i] == bef){
                arr[i] = -1;
                count--;
            }
            else{
                bef = arr[i];
            }
        }
        
        int[] answer = new int[count];
        
        count = 0;
        
        for(int i=0; i<arr.length; i++) {
            if(arr[i] == -1) continue;
            else answer[count++] = arr[i];
        }

        return answer;
    }
}