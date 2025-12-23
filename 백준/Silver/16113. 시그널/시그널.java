import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, map[];
    static String s;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine()) / 5;
        map = new int[5];
        for(int i=0; i<5; i++) map[i] = i * n;
        
        s = br.readLine();

        StringBuilder answer = new StringBuilder();
        int now;
        for(int i=0; i<n; i++){
            now = verify(i);

            if(now == -1){
                continue;
            }
            else if(now == 1) i += 1;
            else i += 2;
            
            answer.append(now);
        }

        System.out.print(answer);
    }
    
    //2는 2번째칸만 공란 --
    //3은 2, 4 공란 --
    //4는 4, 5 공란 
    //5, 9는 4 공란
    //7은 1빼고 전부 공란 --
    private static int verify(int i){
        if(s.charAt(i) == '.'){
            return -1;
        }
        
        if(s.charAt(i+map[1]) == '.'){
            if(s.charAt(i+map[3]) == '.'){
                if(s.charAt(i+map[4]) == '.'){
                    return 7;
                }
                else return 3;
            }
            else return 2;
        }

        else if(s.charAt(i+map[3]) == '.') {
            if(s.charAt(i+map[4]) == '.'){
                return 4;
            }

            if(s.charAt(i+2+map[1]) == '.'){
                return 5;
            }
            
            else return 9;
        }

        else{
            //0, 1, 6, 8 구분
            //두번째라인
            //0은 2,3,4 공란 --
            //1은 전부공란--
            //6은 2, 4공란
            //8은 2, 4 공란 
            if((i+1) % n != 0 && s.charAt(i+1) == '.') return 1;
            if((i+1) % n == 0) return 1;

            else if(s.charAt(i+1+map[2]) == '.'){
                return 0;
            }

            else{
                if(s.charAt(i+2+map[1]) == '.'){
                    return 6;
                }
                else return 8;
            }
        }
    }
}