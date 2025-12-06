import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int dp[] = new int[n];
        int maxNum;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        //가장 큰 합을 가진 증가하는 부분 수열의 합

        dp[0] = arr[0];
        maxNum = arr[0];
        
        for(int i=1; i<n; i++){
            for(int r=i-1; r>=0; r--){
                if(arr[r] < arr[i]) dp[i] = Math.max(dp[r], dp[i]);
            }

            dp[i] += arr[i];
        }
        
        int sum = 0;
        for(int i=0; i<n; i++) sum = Math.max(sum, dp[i]);
        System.out.print(sum);
    }
}