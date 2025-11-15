class Solution {
    int[] count;
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        //증설 
        count = new int[players.length];
        
        int calc;
        
        for(int i=0; i<players.length; i++){
            if(count[i] * m < players[i]){
                calc = (players[i] - (count[i] * m)) / m;
                addCount(i, k, calc);
                answer += calc;
            }
        }
        
        return answer;
    }
    
    private void addCount(int s, int k, int p){
        for(int i=s; i<s+k; i++){
            if(i >= count.length) return;
            
            count[i] += p;
        }
    }
}