import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static HashMap<Long, Long> map = new HashMap<>();
    static int p, q;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        long n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        if(n == 0L){
            System.out.print(1);
            System.exit(0);
        }
        
        map.put(0L, 1L);
        
        if(p > q){
            System.out.print(dfs(n/p) + dfs(n/q));
        }
        else System.out.print(dfs(n/q) + dfs(n/p));
    }

    private static long dfs(Long i){
        if(map.containsKey(i)) return map.get(i);
        else{
            map.put(i, dfs(i/p) + dfs(i/q));
            return dfs(i/p) + dfs(i/q);
        }
    }
}