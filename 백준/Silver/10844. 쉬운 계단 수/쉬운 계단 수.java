import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int restVal = 1_000_000_000;

        int n = Integer.parseInt(br.readLine());

        //1자리 -> 9개 1 2 3 4 5 6 7 8 9
        //2자리 -> 17개 (9+8)
        //10 12 / 21 23/ 32 34 / .../87 89/ 98 16+1 = 17
        //3자리 -> 

        //9만 아니면 위아래가 다 있음
        //0으로 끝나면

        long arr[][] = new long[n+1][10];
        for(int i=1; i<10; i++) arr[1][i] = 1;
        
        for(int i=2; i<n+1; i++) {
            arr[i][0] = arr[i-1][1] % restVal;
            arr[i][9] = arr[i-1][8] % restVal;
            
            for(int r=1; r<9; r++){
                arr[i][r] = (arr[i-1][r-1] % restVal) + (arr[i-1][r+1] % restVal);
                arr[i][r] %= restVal;
            }
        }

        long answer = 0;
        for(int i=0; i<10; i++) answer = arr[n][i] + answer % restVal;
        
        System.out.print(answer % restVal);
    }
}