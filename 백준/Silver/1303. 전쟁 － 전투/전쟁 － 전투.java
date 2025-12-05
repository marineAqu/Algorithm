import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {-1, 1, 0, 0};
    static String map[];
    static boolean visited[][];
    static int w = 0;
    static int b = 0;
    static int n, m;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[m][n];
        map = new String[m];
        for(int i=0; i<m; i++) map[i] = br.readLine();

        for(int i=0; i<m; i++){
            for(int r=0; r<n; r++){
                if(!visited[i][r]){
                    if(map[i].charAt(r) == 'W') w += Math.pow(dfs(i, r, 'W'), 2);
                    else b += Math.pow(dfs(i, r, 'B'), 2);
                }
            }
        }

        System.out.print(w+" "+b);
    }

    private static int dfs(int y, int x, char c){
        int sum = 1;

        visited[y][x] = true;
        
        for(int i=0; i<4; i++){
            if(dx[i]+x < 0 || dy[i]+y < 0 || dx[i]+x >= n || dy[i]+y >= m) continue;
            if(visited[dy[i]+y][dx[i]+x]) continue;

            if(c == map[dy[i]+y].charAt(dx[i]+x)){
                sum += dfs(dy[i]+y, dx[i]+x, c);
            }
        }

        return sum;
    }
}