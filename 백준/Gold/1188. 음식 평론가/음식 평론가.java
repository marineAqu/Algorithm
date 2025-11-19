import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    private static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); //소시지
        int m = Integer.parseInt(st.nextToken()); //평론가

        System.out.print(m - gcd(n, m));
    }
}