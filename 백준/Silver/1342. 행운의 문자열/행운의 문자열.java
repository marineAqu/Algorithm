import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int answer = 0;
    static String s;
    static int size;
    static int count[] = new int[26];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        size = s.length();

        for(int i=0; i<size; i++) count[s.charAt(i) - 'a']++;
        
        dfs(0, -1);

        System.out.print(answer);
    }

    private static void dfs(int depth, int now){
        if(depth == size) {
            answer++;
            return;
        }
        
        for(int i=0; i<26; i++){
            if(count[i] > 0 && i != now){
                count[i]--;
                dfs(depth+1, i);
                count[i]++;
            }
        }
    }
}