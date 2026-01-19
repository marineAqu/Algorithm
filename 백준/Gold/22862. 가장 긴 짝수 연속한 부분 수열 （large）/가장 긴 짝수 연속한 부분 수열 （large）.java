import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n+1];
        int dp[] = new int[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());
        
        for(int i=1; i<=n; i++) {
            dp[i] = dp[i-1];
            if(arr[i] % 2 == 0) dp[i]++;
        }

        int left = 0;
        int right = 0;
        int answer = 0;

        int oddCount = 0;
        
        while(left <= right){
            oddCount = (right - left) - (dp[right] - dp[left]);

            if(oddCount <= k){
                answer = Math.max(answer, right - left - oddCount);

                if(right < n) right++;
                else break;
            }
                
            else{
                left++;
            }
        }
        
        System.out.print(answer);
    }
}