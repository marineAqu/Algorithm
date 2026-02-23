class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        
        int bef = stations[0];
        if((bef - w - 1) > 0){
            answer = (bef - w - 1) / (w*2 + 1);
            if((bef - w - 1) % (w*2 + 1) != 0) answer++;
        }
        
        int calc = 0;
        
        for(int i=1; i<stations.length; i++){
            calc = stations[i] - w - bef - w - 1;
            bef = stations[i];
            
            if(calc <= 0) continue;
            
            answer += calc / (w*2 + 1);
            if(calc % (w*2 + 1) != 0) answer++;
        }
        
        calc = n - w - bef;
        
        if(calc > 0) {
            answer += calc / (w*2 + 1);
            if(calc % (w*2 + 1) != 0) answer++;
        }
        
        return answer;
    }
}

//10 / 5 2인데