class Solution {
    public int solution(String word) {
        int answer = 0;
        int dp[] = new int[5];
        
        dp[0] = 625 + 5*5*5 + 5*5 + 5 + 1;
        dp[1] = 125 + 5*5 + 5 + 1;
        dp[2] = 25 + 5 + 1;
        dp[3] = 5 + 1;
        dp[4] = 1;
        
        for(int i=0; i<word.length(); i++){
            //지난 만큼 가산
            if(word.charAt(i) == 'E'){
                answer += dp[i];
            }
            else if(word.charAt(i) == 'I'){
                answer += dp[i] * 2;
            }
            else if(word.charAt(i) == 'O'){
                answer += dp[i] * 3;
            }
            else if(word.charAt(i) == 'U'){
                answer += dp[i] * 4;
            }
            
            answer++;
        }
        
        return answer;
    }
}