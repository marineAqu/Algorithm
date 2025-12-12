import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;

class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        BigInteger count = new BigInteger("1");
        BigInteger m = new BigInteger("2");
        BigInteger a = new BigInteger("1");
        
        for(int i=2; i<=n; i++){
            count = count.multiply(m).add(a);
        }
        System.out.println(count);
        
        if(n > 20) System.exit(0);

        move(n, 1, 3, 2);

        System.out.print(sb.toString());
    }

    private static void move(int i, int s, int e, int c){
        if(i == 1) {
            System.out.println(s + " " + e);
            return;
        }
        
        move(i-1, s, c, e);
            
        System.out.println(s + " " + e);

        move(i-1, c, e, s);
    }
}