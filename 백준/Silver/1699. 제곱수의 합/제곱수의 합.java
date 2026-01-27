import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int sqrt = (int) Math.sqrt(n) + 1;
        int dp[] = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i=1; i<sqrt; i++){
            dp[i*i] = 1;
        }

        for(int i=2; i<n+1; i++){
            for(int r=1; r<i/2 + 1; r++){
                dp[i] = Math.min(dp[i], dp[r] + dp[i-r]);
            }
        }
        
        System.out.print(dp[n]);
    }
}