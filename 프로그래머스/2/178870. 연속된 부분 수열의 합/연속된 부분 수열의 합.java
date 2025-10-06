class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length - 1;
        
        int sum[] = new int[sequence.length];
        
        sum[0] = sequence[0];
        for(int i=1; i<sequence.length; i++) sum[i] = sum[i-1] + sequence[i];
        
        int s = 0, e = 0;
        int now = 0;
        
        while(true){
            if(e == sequence.length) break;
            
            if(s == 0) now = sum[e];
            else now = sum[e] - sum[s-1];
            
            if(now < k) e++;
            else if(now > k) s++;
            else {
                if(answer[1] - answer[0] < e - s) {
                    e++;
                    continue;
                }
                else if(answer[1] - answer[0] == e - s && answer[0] < s){
                    e++;
                    continue;
                }
                
                answer[0] = s;
                answer[1] = e;
                
                e++;
            }
        }
        
        return answer;
    }
}