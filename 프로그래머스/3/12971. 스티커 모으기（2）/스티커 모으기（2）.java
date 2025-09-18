class Solution {
    //하나 뜯으면 그 양쪽은 뜯을 수 없다
    //n은 1이상 100,000이하, 각 칸은 100이하 5,000,000
    
    public int solution(int sticker[]) {
        //길이가 1이거나 2인 경우
        if(sticker.length == 1) return sticker[0];
        if(sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        
        int dp[][] = new int[sticker.length][2]; //0은 x, 1은 o
        
        dp[0][1] = sticker[0];
        
        for(int i=1; i<sticker.length-1; i++){
            //안뗌 -> 전에거 뗐건 안뗐건 상관x
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
                
            //뗌 -> 전에거 안 뗀 경우에만
            dp[i][1] = dp[i-1][0] + sticker[i];
        }
        
        //첫번째 거 안 뗀 경우
        int dp2[][] = new int[sticker.length][2];
        for(int i=1; i<sticker.length; i++){
            //안뗌 -> 전에거 뗐건 안뗐건 상관x
            dp2[i][0] = Math.max(dp2[i-1][0], dp2[i-1][1]);
                
            //뗌 -> 전에거 안 뗀 경우에만
            dp2[i][1] = dp2[i-1][0] + sticker[i];
        }

        return Math.max(
            Math.max(dp2[sticker.length-1][0], dp2[sticker.length-1][1]), 
            Math.max(dp[sticker.length-2][1], dp[sticker.length-2][0]));
    }
}