import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m;
    static int arr[];
    static boolean visited[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        
        arr = new int[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        dfs(0, -1, "");
    }

    private static void dfs(int depth, int bef, String s){
        if(depth == m) {
            System.out.println(s);
            return;
        }
        
        for(int i=bef+1; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth+1, i, s+arr[i]+" ");
                visited[i] = false;
            }
        }
    }
}