import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];
        
        for(int i=1; i<n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = Math.max(dp[i], arr[i]);
        }

        for(int i=1; i<n+1; i++){
            //자신만 조합
            for(int r=2; r*i<n+1; r++){
                dp[i*r] = Math.max(dp[i*r], dp[i] * r);
            }
            for(int r=1; r<i; r++){
                dp[i] = Math.max(dp[i], dp[i-r] + dp[r]);
            }
        }
        
        System.out.print(dp[n]);
    }
}