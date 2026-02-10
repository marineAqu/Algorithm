import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int dp[] = new int[n];

        for(int i=0; i<n; i++){
            for(int r=0; r<i; r++){
                if(arr[r] < arr[i]) dp[i] = Math.max(dp[i], dp[r] + 1);
            }
        }

        int answer = 0;
        for(int i=0; i<n; i++){
            answer = Math.max(answer, dp[i] + 1);
        }
        System.out.print(answer);
    }
}