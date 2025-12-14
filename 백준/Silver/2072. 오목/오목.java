import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int map[][];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int n = Integer.parseInt(br.readLine());

        map = new int[20][20];
        
        int a, b;
        int flag = 1;
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
    
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            map[a][b] = flag;
            if(checkEnd(a, b, flag)) {
                System.out.print(i+1);
                System.exit(0);
            }

            if(flag == 1) flag = 2;
            else flag = 1;
        }

        System.out.print(-1);
    }

    private static boolean checkEnd(int y, int x, int flag){
        int sum = 1;
        
        //가로 일직선
        for(int i=x+1; i<20; i++){
            if(map[y][i] == flag) sum++;
            else break;
        }

        for(int i=x-1; i>=0; i--){
            if(map[y][i] == flag) sum++;
            else break;
        }

        if(sum == 5) return true;
        sum = 1;
        
        //세로 일직선
        for(int i=y+1; i<20; i++){
            if(map[i][x] == flag) sum++;
            else break;
        }

        for(int i=y-1; i>=0; i--){
            if(map[i][x] == flag) sum++;
            else break;
        }

        if(sum == 5) return true;
        sum = 1;
        
        //상승 대각선
        int temp = x;
        for(int i=y+1; i<20; i++){
            if(temp + 1 >= 20) break;
            temp++;
            if(map[i][temp] == flag) sum++;
            else break;
        }

        temp = x;
        for(int i=y-1; i>=0; i--){
            if(temp - 1 < 0) break;
            temp--;
            if(map[i][temp] == flag) sum++;
            else break;
        }

        if(sum == 5) return true;
        sum = 1;
        

        //하강 대각선
        temp = x;
        for(int i=y+1; i<20; i++){
            if(temp - 1 < 0) break;
            temp--;
            if(map[i][temp] == flag) sum++;
            else break;
        }

        temp = x;
        for(int i=y-1; i>=0; i--){
            if(temp + 1 >= 20) break;
            temp++;
            if(map[i][temp] == flag) sum++;
            else break;
        }

        if(sum == 5) return true;

        
        return false;
    }
}