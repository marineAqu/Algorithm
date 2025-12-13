import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String map[];
    static boolean visited[][];
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static int r, c;

    static int sheep, wolf;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int finS = 0;
        int finW = 0;

        map = new String[r];
        visited = new boolean[r][c];
        
        for(int i=0; i<r; i++) map[i] = br.readLine();

        //# 울타리, o 양, v 늑대
        //살아남은 양과 늑대의 수 (양 > 늑대면 늑대 제거)
        for(int i=0; i<r; i++){
            for(int t=0; t<c; t++){
                if(visited[i][t]) continue;
                
                sheep = 0;
                wolf = 0;

                dfs(i, t);

                if(sheep > wolf) finS += sheep;
                else finW += wolf;
            }
        }

        System.out.print(finS + " " + finW);
    }

    private static void dfs(int y, int x){
        visited[y][x] = true;
        if(map[y].charAt(x) == 'v') wolf++;
        if(map[y].charAt(x) == 'o') sheep++;

        for(int i=0; i<4; i++){
            if(y+dy[i] < 0 || y+dy[i] >= r || x+dx[i] < 0 || x+dx[i] >= c) continue;
            if(visited[y+dy[i]][x+dx[i]]) continue;
            if(map[y+dy[i]].charAt(x+dx[i]) == '#') continue;

            dfs(y+dy[i], x+dx[i]);
        }
    }
}