import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static LinkedList<Integer> adj[];
    static boolean visited[];
    static int countEdge = 0;
    static int countNode = 0;

    private static void dfs(int i, int bef){
        if(visited[i]) return;

        visited[i] = true;

        countNode++;
        
        for(int n : adj[i]){
            if(n != bef) countEdge++;
            if(!visited[n]) dfs(n, i);
        }
    }

    //간선의 수가 노드-1, 두 정점에 대해 경로가 유일 = 사이클 없음
    //간선의 수가 노드 -1 이면서 사이클일 수는 없다

    public static void main(String[] args) throws IOException {
        int n, m, a, b;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int tc = 1;
        adj = new LinkedList[n+1];
        visited = new boolean[n+1];
        int count = 0;

        for(int i=0; i<n+1; i++){
            adj[i] = new LinkedList<>();
        }
        
        while(n != 0 || m != 0){
            count = 0;

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine());

                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());

                adj[a].add(b);
                adj[b].add(a);
            }

            for(int i=1; i<n+1; i++){
                countNode = 0;
                countEdge = 0;
                
                if(!visited[i]) {
                    dfs(i, -1);
                    if(countEdge + 1 == countNode) count++;
                }
            }

            if(count == 0) System.out.println("Case " + tc + ": " + "No trees.");
            else if(count == 1) System.out.println("Case " + tc + ": " + "There is one tree.");
            else System.out.println("Case " + tc + ": " + "A forest of " + count + " trees.");
            
            //다음 TC
            tc++;
            st = new StringTokenizer(br.readLine());
        
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            adj = new LinkedList[n+1];
            visited = new boolean[n+1];

            for(int i=0; i<n+1; i++){
                adj[i] = new LinkedList<>();
            }
        }
    }
}