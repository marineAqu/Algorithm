import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int map[][];
    static int answer[] = new int[3];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int r=0; r<n; r++){
                map[i][r] = Integer.parseInt(st.nextToken());
            }
        }

        calc(0, 0, n);
        
        System.out.print(answer[0] + "\n" + answer[1] + "\n" + answer[2]);
    }

    private static void calc(int x, int y, int s){
        //검사
        if(isAllSame(x, y, s)){
            //모두 같을 경우
            answer[map[x][y] + 1]++;
        }
        else{
            //그렇지 않을 경우 -> 또 잘라야 한다

            for(int i=0; i<s; i += s/3){
                for(int r=0; r<s; r += s/3){
                    calc(x + i, y + r, s/3);
                }
            }
        }
    }

    private static boolean isAllSame(int x, int y, int s){
        int flag = map[x][y];
        
        for(int i=x; i<x+s; i++){
            for(int r=y; r<y+s; r++){
                if(flag != map[i][r]) return false;
            }
        }

        return true;
    }
}