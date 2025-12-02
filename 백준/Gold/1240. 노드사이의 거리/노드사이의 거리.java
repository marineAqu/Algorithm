import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a, b, c;
        int arr[][] = new int[n+1][n+1];

        for(int r=1; r<=n; r++){
            for(int i=1; i<=n; i++){
                arr[r][i] = 100_000_000;
            }
        }
        
        for(int i=0; i<n-1; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            arr[a][b] = Math.min(c, arr[a][b]);
            arr[b][a] = Math.min(c, arr[b][a]);
        }

        for(int r=1; r<=n; r++){
            for(int i=1; i<=n; i++){
                for(int t=1; t<=n; t++){
                    arr[i][t] = Math.min(arr[i][t], arr[i][r] + arr[r][t]);
                }
            }
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            System.out.println(arr[a][b]);
        }
    }
}