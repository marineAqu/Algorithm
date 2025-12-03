import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n, i;
        long now = 0;
        StringBuilder sb = new StringBuilder();

        int dp[] = new int[45];
        dp[1] = 1;

        //dp
        for(i=2; i<45; i++) dp[i] = dp[i-1] + dp[i-2];

        //최소 개수의 서로 다른 피보나치 수의 합으로 표현
        for(int r=0; r<t; r++){
            n = Integer.parseInt(br.readLine());
            now = 0;

            for(i=44; i>=1; i--) {
                if(dp[i] <= n){
                    n -= dp[i];
                    sb.insert(0, dp[i]+" ");
                }

                if(n == 0) break;
            }

            System.out.println(sb.toString());
            sb.setLength(0);
        }
    }
}