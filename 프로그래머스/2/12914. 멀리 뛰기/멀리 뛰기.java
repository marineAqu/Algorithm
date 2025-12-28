class Solution {
    public long solution(int n) {
        long answer = 1;
        
        long bef = 1;
        long aft = 2;
        
        if(n == 1) return bef;
        if(n == 2) return aft;
        
        for(int i=3; i<n+1; i++){
            answer = (bef + aft) % 1234567;
            bef = aft;
            aft = answer;
        }
        
        return answer;
    }
}