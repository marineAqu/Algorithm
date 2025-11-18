import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static long findMaxPow(int p, int n){
        long now = 1;
        
        while(now*p <= n){
            now *= p;
            now %= 987654321;
        }
        
        return now % 987654321;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long result = 1;
        
        boolean arr[] = new boolean[n+1];

        for(int i=2; i<n+1; i++){
            if(arr[i]) continue;

            for(int r=2; r*i < n+1; r++){
                arr[i*r] = true;
            }
        }

        for(int i=2; i<n+1; i++){
            if(!arr[i]) {
                result *= findMaxPow(i, n);
                result %= 987654321;
            }
        }

        System.out.print(result);
    }
}