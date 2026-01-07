import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int y, x;
    Node(int y, int x){
        this.y = y;
        this.x = x;
    }
}

class Main {
    static int r, c;
    static int map[][];
    static boolean visited[][];
    static int count = 0;
    static int size;
    static int dx[] = {0, 0, -1, 1};
    static int dy[] = {1, -1, 0, 0};
    static Queue<Node> queue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            st = new StringTokenizer(br.readLine());
            for(int k=0; k<c; k++) map[i][k] = Integer.parseInt(st.nextToken());
        }

        while(true){
            init();
            if(queue.size() == 0) break;
            
            count++;
            size = queue.size();

            delete();
        }

        System.out.print(count + "\n" + size);
    }
    
    private static void delete(){
        Node now;
        
        while(!queue.isEmpty()){
            now = queue.poll();
            map[now.y][now.x] = 0;
        }
    }

    private static void init(){
        Node now;

        Queue<Node> q = new LinkedList<>();
        
        q.add(new Node(0, 0));
        visited = new boolean[r][c];
        
        while(!q.isEmpty()){
            now = q.poll();
            
            for(int i=0; i<4; i++){
                if(now.y+dy[i] < 0 || now.y+dy[i] >= r || now.x+dx[i] < 0 || now.x+dx[i] >= c) continue;
                if(visited[now.y+dy[i]][now.x+dx[i]]) continue;

                visited[now.y+dy[i]][now.x+dx[i]] = true;

                if(map[now.y+dy[i]][now.x+dx[i]] == 1) queue.add(new Node(now.y+dy[i], now.x+dx[i]));
                else q.add(new Node(now.y+dy[i], now.x+dx[i]));
            }
        }
    }
}