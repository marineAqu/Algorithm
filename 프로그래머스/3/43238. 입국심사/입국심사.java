import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long start = 1;
        long end = (long)n * times[times.length - 1];
        
        long mid, count;
        while(start <= end) {
            mid = (start + end) / 2;
            count = passCount(mid, times);
            
            if(count >= n) end = mid - 1;
            else start = mid + 1;
        }
        
        return start;
    }
    
    private long passCount(long mid, int[] times) {
        long sum = 0;
        for(int i=0; i<times.length; i++) {
            sum += (mid / times[i]);
        }
        return sum;
    }
}