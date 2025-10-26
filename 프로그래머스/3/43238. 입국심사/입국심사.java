import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        
        long start = 1;
        long end = (long)n * times[times.length-1];
        
        long mid;
        long result;
        
        while(start <= end){
            mid = (start + end) / 2;
            result = countAnswer(mid, times);
            
            if(result >= n) end = mid - 1;
            else start = mid + 1;
        }
        
        return start;
    }
    
    private long countAnswer(long t, int[] times){
        long sum = 0;
        
        for(int i=0; i<times.length; i++){
            sum += t / times[i];
        }
        
        return sum;
    }
}