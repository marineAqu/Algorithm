class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        
        //5개->4개 식이니까
        //n번째 i는 
        
        int dp[][] = triangle;
        
        for(int i=1; i<triangle.length; i++){
            for(int r=0; r<triangle[i].length; r++){
                if(r == 0) dp[i][r] = dp[i-1][0] + triangle[i][r];
                else if(r == triangle[i].length - 1) dp[i][r] = dp[i-1][r-1] + triangle[i][r];
                else dp[i][r] = Math.max(dp[i-1][r], dp[i-1][r-1]) + triangle[i][r];
            }
        }
        
        for(int r=0; r<dp[triangle.length-1].length; r++){
            answer = Math.max(answer, dp[triangle.length-1][r]);
        }
        
        return answer;
    }
}