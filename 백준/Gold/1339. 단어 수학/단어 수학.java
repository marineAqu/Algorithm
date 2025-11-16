import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int f;
        int count[] = new int[26];
        String s;
        
        for(int i=0; i<n; i++) {
            s = br.readLine();
            f = 1;
            
            for(int r=s.length()-1; r>=0; r--){
                count[s.charAt(r) - 'A'] += f;
                f *= 10;
            }
        }
        
        Arrays.sort(count);
        f = 9;
        int answer = 0;
        
        for(int i=25; i>15; i--) {
            answer += count[i] * f--;
        }

        System.out.println(answer);
    }
}