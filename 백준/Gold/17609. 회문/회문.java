import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        String s;
        int answer;
        int returnPoint[] = new int[2];
        int flag;
        
        for(int i=0; i<tc; i++){
            s = br.readLine();
            answer = 0;
            flag = 0;

            int l = 0, r = s.length() - 1;
            returnPoint[0] = 0;
            returnPoint[1] = 0;
            
            while(l < r){
                if(s.charAt(l) == s.charAt(r)){
                    r--;
                    l++;
                    continue;
                }
                else if(answer == 0 || (l == returnPoint[0] && r == returnPoint[1])){ //회귀한 경우 허용
                    answer = 1;

                    if(s.charAt(l+1) == s.charAt(r) && s.charAt(l) == s.charAt(r-1)) {                        
                        returnPoint[0] = l;
                        returnPoint[1] = r;

                        if(flag == 1){
                            r--;
                        }
                        else l++;
                    }
                    else if(s.charAt(l+1) == s.charAt(r)){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
                else{
                    if(flag == 1 || (returnPoint[0] == 0 && returnPoint[1] == 0)) {
                        answer = 2;
                        break;
                    }

                    //회귀할 수 있는 경우
                    else{
                        flag = 1;
                        l = returnPoint[0];
                        r = returnPoint[1];
                    }
                }
            }

            System.out.println(answer);
        }
    }
}