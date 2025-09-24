import java.util.*;

class Solution {
    public int[] solution(int target) {
        int[] answer = new int[2];
        //빨리 0점으로 만들되 가능하면 싱글이나 볼을 많이 얻는걸로
        
        int[][] dp = new int[target+1][2];
        if(target <= 50) dp = new int[51][2];
        
        for(int i=0; i<=target; i++) dp[i][0] = 100001;
            
        for(int i=1; i<=20; i++) {
            dp[i][0] = 1;
            dp[i][1] = 1;
            
            if(i*2 <= target) dp[i*2][0] = 1;
            
            if(i*3 <= target) dp[i*3][0] = 1;
        }
        
        dp[50][0] = 1;
        dp[50][1] = 1;
        
        for(int i=1; i<target; i++) {
            for(int r=1; r<=60; r++) {
                if(i+r > target) continue;
                
                if(dp[i+r][0] > dp[i][0] + dp[r][0]) {
                    dp[i+r][0] = dp[i][0] + dp[r][0];
                    dp[i+r][1] = dp[i][1] + dp[r][1];
                }
                
                if(dp[i+r][0] == dp[i][0] + dp[r][0]) {
                    dp[i+r][1] = Math.max(dp[i+r][1], dp[i][1] + dp[r][1]);
                }
            }
            
            if(i+50 > target) continue;
            
            if(dp[i+50][0] > dp[i][0] + 1) {
                dp[i+50][0] = dp[i][0] + 1;
                dp[i+50][1] = dp[i][1] + 1;
            }
            
            if(dp[i+50][0] == dp[i][0] + 1 && dp[i+50][1] < dp[i][1] + 1) 
                dp[i+50][1] = dp[i][1] + 1;
        }
        
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        
        return answer;
    }
}
