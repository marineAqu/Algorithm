import java.util.*;
import java.lang.*;
import java.io.*;

class Point{
    int y, x, dirc;
    Point(int y, int x, int dirc){
        this.x = x;
        this.y = y;
        this.dirc = dirc;
    }
}

class Main {
    static int n, m;
    static int answer = 0;
    static int map[][];
    static Point p;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        
        st = new StringTokenizer(br.readLine());
        p = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        
        //input
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<m; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            //현재 칸이 아직 청소되지 않은 경우
            if(map[p.y][p.x] == 0) {
                answer++;
                map[p.y][p.x] = -1;
            }

            //주변 4칸 중 빈칸이 없는 경우
            if(!checkAround()){
                if(isBackWall()) break;
                else continue;
            }

            //주변 4칸 중 빈칸이 있는 경우 
            else{
                if(p.dirc == 0) p.dirc = 3;
                else p.dirc--;

                //바라보는 방향이 빈 칸이면 전진
                isFrontCanClean();
            }
        }

        System.out.print(answer);
    }

    private static boolean checkAround(){
        for(int i=0; i<4; i++){
            if(p.x + dx[i] < 0 || p.y + dy[i] < 0
                  || p.x + dx[i] >= m || p.y + dy[i] >= n) continue;
            if(map[p.y + dy[i]][p.x + dx[i]] == 0) return true;
        }

        return false;
    }

    private static boolean isFrontCanClean(){
        //0이 북에서부터 시계방향
        if(p.dirc == 0){
            if(p.y-1 >= 0 && map[p.y-1][p.x] == 0) {
                answer++;
                map[p.y-1][p.x] = -1;
                p.y--;
                return true;
            }
        }

        else if(p.dirc == 1){
            if(p.x+1 < m && map[p.y][p.x+1] == 0) {
                answer++;
                map[p.y][p.x+1] = -1;
                p.x++;
                return true;
            }
        }

        else if(p.dirc == 2){
            if(p.y+1 < n && map[p.y+1][p.x] == 0) {
                answer++;
                map[p.y+1][p.x] = -1;
                p.y++;
                return true;
            }
        }

        else if(p.dirc == 3){
            if(p.x-1 >= 0 && map[p.y][p.x-1] == 0) {
                answer++;
                map[p.y][p.x-1] = -1;
                p.x--;
                return true;
            }
        }

        return false;
    }

    private static boolean isBackWall(){
        //0이 북에서부터 시계방향
        if(p.dirc == 0){
            if(p.y+1 >= n || map[p.y+1][p.x] == 1) return true;
            else {
                p.y += 1;
                return false;
            }
        }

        if(p.dirc == 1){
            if(p.x-1 < 0 || map[p.y][p.x-1] == 1) return true;
            else {
                p.x -= 1;
                return false;
            }
        }

        if(p.dirc == 2){
            if(p.y-1 < 0 || map[p.y-1][p.x] == 1) return true;
            else {
                p.y -= 1;
                return false;
            }
        }

        if(p.dirc == 3){
            if(p.x+1 >= m || map[p.y][p.x+1] == 1) return true;
            else {
                p.x += 1;
                return false;
            }
        }

        return false;
    }
}