import java.util.*;

class Solution {
    public long solution(int m, int n, int[][] puddles) {
        int divide = 1_000_000_007;
        
        long dp[][] = new long[n][m];
        
        for(int i=0; i<puddles.length; i++) {
            dp[puddles[i][1]-1][puddles[i][0]-1] = -1;
        }
        
        dp[0][0] = 1;
        
        for(int i=0; i<n-1; i++){
            for(int r=0; r<m-1; r++){
                if(dp[i][r] == -1) continue;
                
                if(dp[i][r+1] != -1) dp[i][r+1] += dp[i][r] % divide;
            
                if(dp[i+1][r] != -1) dp[i+1][r] += dp[i][r] % divide;
            }
            
            if(dp[i][m-1] != -1 && dp[i+1][m-1] != -1) 
                dp[i+1][m-1] += dp[i][m-1] % divide;
        }
        
        for(int r=0; r<m-1; r++){
            if(dp[n-1][r] != -1 && dp[n-1][r+1] != -1) 
                dp[n-1][r+1] += dp[n-1][r] % divide;
        }
        
        return dp[n-1][m-1] % divide;
    }
}