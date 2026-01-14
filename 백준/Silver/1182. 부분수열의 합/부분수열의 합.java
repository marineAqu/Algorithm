import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int count, s, n;
    static int arr[];
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        count = 0;
        
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for(int i=1; i<=n; i++) {
            dfs(0, i, 0, -1);
        }
        
        System.out.print(count);
    }

    private static void dfs(int depth, int size, int sum, int bef){
        if(depth == size){
            if(sum == s) {
                count++;
            }
            return;
        }

        for(int i=bef+1; i<n; i++) {
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, size, sum + arr[i], i);
                visited[i] = false;
            }
        }
    }
}