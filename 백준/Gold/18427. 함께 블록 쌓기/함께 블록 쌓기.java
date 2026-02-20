import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int c;

        int info[][] = new int[n][m+2];
        int dp[][] = new int[n][h+1];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            c = 0;
            
            while(st.hasMoreTokens()){
                info[i][c++] = Integer.parseInt(st.nextToken());
            }

            info[i][c+1] = -1;
        }

        for(int q=0; q<m+1; q++){
            if(info[0][q] == -1) break;
            dp[0][info[0][q]]++;
        }
        
        for(int i=1; i<n; i++){
            for(int r=0; r<h+1; r++){
                for(int q=0; q<m+2; q++){
                    if(info[i][q] == -1) break;
                    
                    if(r + info[i][q] < h+1) {
                        dp[i][r + info[i][q]] += dp[i-1][r] % 10_007;
                        dp[i][r + info[i][q]] %= 10_007;
                    }
                }
            }
        }
        
        System.out.println(dp[n-1][h]);
    }
}