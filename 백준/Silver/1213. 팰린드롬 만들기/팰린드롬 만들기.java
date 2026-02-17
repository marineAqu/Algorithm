import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int cnt[] = new int[26];

        for(int i=0; i<s.length(); i++) cnt[s.charAt(i) - 'A']++;

        //A부터 시작하는 편이 좋다.

        StringBuilder sb = new StringBuilder();

        int index = 0;
        int rest = -1;
        boolean flag = false;
        
        while(index < 26){
            if(cnt[index] > 0){
                if(cnt[index] % 2 == 0){
                    for(int i=0; i<cnt[index] / 2; i++){
                        sb.append((char) (index+'A'));
                    }
                    cnt[index++] = 0;
                }
                else if(rest == -1) {
                    rest = index;

                    for(int i=0; i<cnt[index] / 2; i++){
                        sb.append((char) (index+'A'));
                    }
                    cnt[index++] = 0;
                }
                else {
                    flag = true;
                    break;
                }
            }
            else index++;
        }

        if(flag) System.out.print("I'm Sorry Hansoo");
        else {
            String answer = sb.reverse().toString();
            sb.reverse();
            if(rest != -1) sb.append((char) (rest+'A'));
            System.out.print(sb.append(answer));
        }
    }
}