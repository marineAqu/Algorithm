import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long dp[] = new long[1_000_001];
        final long divisor = 1_000_000_009;
        int n;

        //1, 2, 3의 합으로 나타내기
        //1 = 1
        //2 = 1+1, 2
        //3 = 1+1+1 (4는 여기에 1을 더하기)
            //1+2 (여기에 1을 더하기)
            //2+1 (여기에 1을 더하기)
            //3
        //4 = dp[n-2]에 2를 더한 1개의 경우의 수
            //dp[n-3]에 3을 더한 1개의 경우의 수

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        
        for(int i=4; i<1_000_001; i++){
            for(int r=1; r<4; r++){
                dp[i] += dp[i-r];
                dp[i] %= divisor;
            }
        }
        
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());

            System.out.println(dp[n]);
        }
    }
}