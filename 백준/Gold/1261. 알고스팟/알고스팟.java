import java.util.*;
import java.io.*;

class Node{
    int cost, y, x;
    Node(int y, int x, int cost){
        this.cost = cost;
        this.y = y;
        this.x = x;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};

        String[] map = new String[m];
        int distance[][] = new int[m][n];
        
        for(int i=0; i<m; i++){
            map[i] = br.readLine();
            Arrays.fill(distance[i], n*m + 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        queue.add(new Node(0, 0, 0));
        
        Node node;
        //부숴야하는 벽 수
        while(!queue.isEmpty()){
            node = queue.poll();

            if(distance[node.y][node.x] <= node.cost){
                continue;
            }

            distance[node.y][node.x] = node.cost;

            for(int i=0; i<4; i++){
                if(node.y + dy[i] < 0 || node.y + dy[i] >= m
                      || node.x + dx[i] < 0 || node.x + dx[i] >= n) continue;

                if(map[node.y + dy[i]].charAt(node.x + dx[i]) == '1') {
                    if(distance[node.y + dy[i]][node.x + dx[i]] > node.cost + 1){
                        queue.add(new Node(node.y + dy[i], node.x + dx[i], node.cost + 1));
                    }
                }

                else {
                    if(distance[node.y + dy[i]][node.x + dx[i]] > node.cost){
                        queue.add(new Node(node.y + dy[i], node.x + dx[i], node.cost));
                    }
                }
            }
        }
        
        System.out.print(distance[m-1][n-1]);
    }
}