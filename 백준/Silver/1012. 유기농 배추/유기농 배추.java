import java.util.*;
import java.io.*;

class Main {
    static int m, n;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0 ,0};
    static int map[][];
    static boolean visited[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int k;
        int x, y;
        int count = 0;
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            count = 0;
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            map = new int[m][n];
            visited = new boolean[m][n];
            for(int r=0; r<k; r++){
                st = new StringTokenizer(br.readLine());
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }

            for(int r=0; r<m; r++){
                for(int q=0; q<n; q++){
                    if(map[r][q] == 1 && !visited[r][q]){
                        count++;
                        dfs(q, r);
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void dfs(int x, int y){
        visited[y][x] = true;
        
        for(int i=0; i<4; i++){
            if(x+dx[i] < 0 || y+dy[i] < 0 || x+dx[i] >= n || y+dy[i] >= m || visited[y+dy[i]][x+dx[i]]) continue;
            if(map[y+dy[i]][x+dx[i]] == 1) dfs(x+dx[i], y+dy[i]);
        }
    }
}