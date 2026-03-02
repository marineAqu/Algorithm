class Solution {
    public long solution(int[] sequence) {
        long answer = -100_001;
        int flag = -1;
        
        long dp[][] = new long[sequence.length+1][2]; // 0은 1부터, 1은 -1부터 시작
        
        for(int i=1; i<sequence.length + 1; i++){
            dp[i][0] = dp[i-1][0] + sequence[i-1] * (flag * -1);
            dp[i][1] = dp[i-1][1] + sequence[i-1] * flag;
            
            flag *= -1;
        }
        
        int info[][] = new int[2][2]; //0은 dp[i][0]의 max/min
        for(int i=0; i<sequence.length+1; i++){
            //제일 큰 값에 제일 작은 값을 빼면 된다.
            if(dp[i][0] > dp[info[0][0]][0]) {
                info[0][0] = i;
            }
            
            if(dp[i][0] < dp[info[0][1]][0]) {
                info[0][1] = i;
            }
            
            if(dp[i][1] > dp[info[1][0]][1]) {
                info[1][0] = i;
            }
            
            if(dp[i][1] < dp[info[1][1]][1]) {
                info[1][1] = i;
            }
        }
        
        answer = Math.max(dp[info[0][0]][0] - dp[info[0][1]][0], 
                          dp[info[1][0]][1] - dp[info[1][1]][1]);
        
        return answer;
    }
}