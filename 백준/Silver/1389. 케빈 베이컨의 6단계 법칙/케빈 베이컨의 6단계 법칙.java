import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int a, b;

        int adj[][] = new int[n+1][n+1];
        for(int i=1; i<n+1; i++) {
            for(int r=1; r<n+1; r++){
                adj[i][r] = 50000;
            }
        }
        
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            adj[a][b] = 1;
            adj[b][a] = 1;
        }
        
        for(int i=1; i<n+1; i++) {
            for(int r=1; r<n+1; r++){
                for(int k=1; k<n+1; k++){
                    adj[r][k] = Math.min(adj[r][k], adj[r][i] + adj[i][k]);
                }
            }
        }

        int answer = 0;
        int minVal = 5000000;
        int sum = 0;
        for(int i=1; i<n+1; i++) {
            sum = 0;
            for(int r=1; r<n+1; r++){
                sum += adj[i][r];
            }

            if(sum < minVal) {
                answer = i;
                minVal = sum;
            }
        }

        System.out.print(answer);
    }
}