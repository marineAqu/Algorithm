class Solution {
    public int solution(int n) {
        long dp[] = new long[n+1];
        
        dp[1] = 1;
        if(n >= 2) dp[2] = 2;
        if(n >= 3) dp[3] = 3;
        
        for(int i=4; i<=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_007;
        }
        
        return (int) dp[n];
    }
}