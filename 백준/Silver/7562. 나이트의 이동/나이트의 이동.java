import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int y, x, c;
    Node(int y, int x, int c){
        this.y = y;
        this.x = x;
        this.c = c;
    }
}

class Main {
    static int l;
    static boolean visited[][];
    static int togo[] = new int[2];
    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = {1, -1, 2, -2, 2, -2, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] now = new int[2];

        for(int i=0; i<t; i++){
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            
            st = new StringTokenizer(br.readLine());
            now[0] = Integer.parseInt(st.nextToken());
            now[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            togo[0] = Integer.parseInt(st.nextToken());
            togo[1] = Integer.parseInt(st.nextToken());

            bfs(now[0], now[1]);
        }
    }

    private static void bfs(int y, int x){
        Queue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.c - o2.c);
        queue.add(new Node(y, x, 0));

        Node now;
        while(!queue.isEmpty()){
            now = queue.poll();

            if(togo[0] == now.y && togo[1] == now.x) {
                System.out.println(now.c);
                return;
            }
            
            for(int i=0; i<8; i++){
                if(now.y+dy[i] >= l || now.y+dy[i] < 0 || now.x+dx[i] >= l || now.x+dx[i] < 0) continue;
                if(visited[now.y+dy[i]][now.x+dx[i]]) continue;

                visited[now.y+dy[i]][now.x+dx[i]] = true;
                queue.add(new Node(now.y+dy[i], now.x+dx[i], now.c + 1));
            }
        }
    }
}