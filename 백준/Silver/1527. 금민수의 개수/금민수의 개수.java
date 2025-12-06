import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int a, b;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        
        count += dfs(4);
        count += dfs(7);

        System.out.print(count);
    }

    private static int dfs(long n){
        int sum = 1;
        
        if(n > b) return 0;
        if(n < a) sum = 0;

        sum += dfs(n*10 + 7);
        sum += dfs(n*10 + 4);

        return sum;
    }
}