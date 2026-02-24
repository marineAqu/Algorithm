import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int arr[][] = new int[n][2];
        int dp[] = new int[n+1]; //자신의 것을 하는 경우, 안하는 경우
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            if(i != 0) dp[i] = Math.max(dp[i], dp[i-1]);
            
            //상담 하는 경우
            if(i + arr[i][0] <= n) {
                dp[i+arr[i][0]] = Math.max(dp[i+arr[i][0]], dp[i] + arr[i][1]);
            }
        }
        
        System.out.print(Math.max(dp[n], dp[n-1]));
    }
}