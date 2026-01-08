import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static char[] arr;
    static boolean visited[] = new boolean[10];
    static int map[];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new char[n];
        map = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++) arr[i] = st.nextToken().charAt(0);

        dfsMax(0);
        for(int i=0; i<=n; i++) System.out.print(map[i]);
        System.out.println();

        visited = new boolean[10];
        
        dfsMin(0);
        for(int i=0; i<=n; i++) System.out.print(map[i]);
    }

    private static boolean check(int depth, int num){
        if(depth == 0) return true;

        if(arr[depth - 1] == '<'){
            if(map[depth-1] < num) return true;
            else return false;
        }

        if(arr[depth - 1] == '>'){
            if(map[depth-1] > num) return true;
            else return false;
        }

        return false;
    }

    private static boolean dfsMax(int depth){
        if(depth == n+1) return true;
        
        for(int i=9; i>=0; i--){
            if(!visited[i] && check(depth, i)){
                map[depth] = i;
                visited[i] = true;
                
                if(dfsMax(depth+1)) return true;
                
                visited[i] = false;
            }
        }

        return false;
    }

    private static boolean dfsMin(int depth){
        if(depth == n+1) return true;
        
        for(int i=0; i<=9; i++){
            if(!visited[i] && check(depth, i)){
                map[depth] = i;
                visited[i] = true;
                
                if(dfsMin(depth+1)) return true;
                
                visited[i] = false;
            }
        }

        return false;
    }
}