class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int sp = 0, ep = 1;
        int sum = 1;
        
        while(sp < ep){
            if(sum == n){
                answer++;
                
                if(sp == ep - 1) break;
                
                sp++;
                sum -= sp;
            }
            
            else if(sum < n){
                ep++;
                sum += ep;
            }
            
            else{
                sp++;
                sum -= sp;
            }
        }
        
        return answer;
    }
}