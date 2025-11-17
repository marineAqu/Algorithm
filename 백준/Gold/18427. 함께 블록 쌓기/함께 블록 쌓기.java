import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //학생 수
        int m = Integer.parseInt(st.nextToken()); //최대 블록 수
        int h = Integer.parseInt(st.nextToken()); //요구 높이

        LinkedList<Integer> info[] = new LinkedList[n+1];
        int dp[][] = new int[n+1][h+1];
        
        for(int i=1; i<n+1; i++){
            info[i] = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()){
                info[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<h+1; j++){
                for(int now : info[i]){
                    if(j == now) dp[i][j]++;
                    if(j > now) dp[i][j] += dp[i-1][j-now];
                }

                dp[i][j] += dp[i-1][j];
                dp[i][j] %= 10007;
            }
        }

        System.out.print(dp[n][h]);
    }
}