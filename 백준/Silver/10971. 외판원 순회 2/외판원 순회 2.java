import java.util.*;
import java.lang.*;
import java.io.*;

//최대 n = 10, 10!
class Main {
    static int dist[][];
    static int n;
    static boolean visited[];
    static int minVal = Integer.MAX_VALUE;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());

        dist = new int[n][n];
        visited = new boolean[n];
        
        //init: 갈 수 없으면 0
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<n; r++){
                dist[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        //calc
        visited[0] = true;
        dfs(0, 1, 0);

        System.out.print(minVal);
    }

    private static void dfs(int now, int depth, int distance){
        if(depth == n){
            if(dist[now][0] == 0) return;
            minVal = Math.min(minVal, distance + dist[now][0]);
            return;
        }
        
        for(int i=0; i<n; i++){
            if(visited[i] || dist[now][i] == 0) continue;

            visited[i] = true;
            dfs(i, depth+1, distance + dist[now][i]);
            visited[i] = false;
        }
    }
}