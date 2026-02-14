import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        int n, m, answer = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        int dp[] = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i=4; i<=40; i++) dp[i] = dp[i-1] + dp[i-2];
        
        int arr[] = new int[m+1];

        for(int i=1; i<=m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            answer *= dp[arr[i] - arr[i-1] - 1];
        }

        answer *= dp[n - arr[m]];
        
        System.out.print(answer);

        
            //3자리 -> 3개의 경우의 수
            //2자리 -> 2개의 경우의 수
            //4자리 -> 5개의 경우의 수

            //1 2 3 4
            //2 1 3 4
            //1 2 4 3
            //2 1 4 3
            //1 3 2 4
            //하나만 바꾸는 수: n개의 경우의 수
            //여러개를 동시에 바꾸는 수: 

            //한칸전에거 + 두 칸 전에거
        //
    }
}