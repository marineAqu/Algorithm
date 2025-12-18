import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        //2-친구의 수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s;
        
        int map[][] = new int[n][n];
        for(int i=0; i<n; i++){
            s = br.readLine();
            for(int r=0; r<n; r++){
                if(s.charAt(r) == 'Y') map[i][r] = 1;
                else map[i][r] = 50;
            }
        }

        for(int i=0; i<n; i++){
            for(int r=0; r<n; r++){
                for(int k=0; k<n; k++){
                    map[r][k] = Math.min(map[r][k], map[k][i] + map[i][r]);
                }
            }
        }

        int answer = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            count = 0;
            for(int k=0; k<n; k++){
                if(i == k) continue;
                if(map[i][k] <= 2) count++;
            }
            answer = Math.max(answer, count);
        }

        System.out.print(answer);
    }
}