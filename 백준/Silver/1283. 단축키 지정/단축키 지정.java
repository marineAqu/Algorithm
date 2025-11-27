import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        boolean isCheck[] = new boolean[26];
        String str;
        int size = 0;

        int flag = -1;
        for(int i=0; i<n; i++){
            str = br.readLine();
            flag = -1;

            //첫글자 검사
            if(!isCheck[Character.toUpperCase(str.charAt(0)) - 'A']){
                isCheck[Character.toUpperCase(str.charAt(0)) - 'A'] = true;
                flag = 0;
            }
            
            //한 글자씩 검사하되 단어의 첫글자는 높은 우선순위
            else{
                for(int r=1; r<str.length(); r++){
                    if(str.charAt(r) == ' ') continue;
                    
                    if(!isCheck[Character.toUpperCase(str.charAt(r)) - 'A']){
                        if(flag == -1) flag = r;
        
                        if(str.charAt(r-1) == ' '){
                            flag = r;
                            break; //첫글자라면 즉시 종료
                        }
                    }
                }
            }

            if(flag == -1) sb.append(str).append("\n");
            else {
                isCheck[Character.toUpperCase(str.charAt(flag)) - 'A'] = true;
                sb.append(str);
                sb.insert(size + flag, '[');
                sb.insert(size + flag + 2, ']');
                sb.append("\n");
            }

            size = sb.length();
        }

        System.out.print(sb.toString());
    }
}