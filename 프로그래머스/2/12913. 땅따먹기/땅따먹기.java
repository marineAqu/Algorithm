class Solution {
    int solution(int[][] land) {
        int answer = 0;
        int dp[][] = new int[land.length][land[0].length];

        int maxInfo[] = new int[2];
        
        for(int r=0; r<land[0].length; r++){
            dp[0][r] = land[0][r];
        }
        
        for(int i=1; i<land.length; i++){
            if(dp[i-1][0] > dp[i-1][1]) {
                maxInfo[0] = 1;
                maxInfo[1] = 0;
            }
            else{
                maxInfo[0] = 0;
                maxInfo[1] = 1;
            }
            
            for(int r=2; r<land[0].length; r++){
                //가장 큰 값이랑 두번째로 큰 값 찾기
                if(dp[i-1][r] > dp[i-1][maxInfo[0]]){
                    if(dp[i-1][r] > dp[i-1][maxInfo[1]]){
                        maxInfo[0] = maxInfo[1];
                        maxInfo[1] = r;
                    }
                    
                    else maxInfo[0] = r;
                }
            }
            
            for(int r=0; r<land[0].length; r++){
                if(maxInfo[1] == r){
                    dp[i][r] = dp[i-1][maxInfo[0]] + land[i][r];
                }
                else dp[i][r] = dp[i-1][maxInfo[1]] + land[i][r];
            }
        }

        for(int r=0; r<land[0].length; r++){
            answer = Math.max(answer, dp[land.length-1][r]);
        }
        
        /*
        for(int i=0; i<land.length; i++){
            for(int r=0; r<land[0].length; r++){
                System.out.print(dp[i][r]+" ");
            }
            System.out.println();
        }
        */
        
        return answer;
    }
}