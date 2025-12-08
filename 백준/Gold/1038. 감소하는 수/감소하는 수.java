import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int map[] = new int[10];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        // 0 1 .. 8 9
        //10
        //20 21
        //30 ... 32
        //90 ... 98
        //210
        //310 320 321
        //410 420 421 430 431 432  
        //3210
        //9876543210
        //자릿수

        if(n == 0) {
            System.out.print(0);
            System.exit(0);
        }

        if(n < 10){
            System.out.print(n);
            System.exit(0);
        }

        map[9] = 9;
        n -= 9;
        
        boolean flag = false;
        while(true){
            if(n == 0) break;
            n--;
            
            flag = false;
            
            for(int i=9; i>0; i--){
                if(map[i-1] > map[i]+1){
                    if(map[i] < 9) map[i]++;
                    else continue;
                    
                    setZero(i);
                    flag = true;
                    break;
                }

                else if(map[i-1] == 0){
                    if(map[i] < 9) {
                        map[i]++;
                        setZero(i);
                    }
                    else {
                        map[i-1] = 9-(i-1);
                        setZero(i-1);
                    }
                    
                    flag = true;
                    break;
                }
            }

            if(!flag){
                if(map[0] == 9) {
                    System.out.print(-1);
                    System.exit(0);    
                }
                else{
                    map[0]++;
                    setZero(0);
                }
            }
        }

        flag = false;
        for(int i=0; i<10; i++) {
            if(!flag && map[i] == 0) continue;
            else flag = true;
            
            System.out.print(map[i]);
        }
    }

    private static void setZero(int depth){
        for(int i=9; i>depth; i--) map[i] = 9-i;
    }
}