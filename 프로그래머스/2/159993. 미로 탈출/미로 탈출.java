import java.util.*;

class Node{
    int x, y, c;
    Node(int x, int y, int c){
        this.x = x;
        this.y = y;
        this.c = c;
    }
}

class Solution {
    public int solution(String[] maps) {
        int answer = 0;
        
        int dx[] = {0, 0, 1, -1};
        int dy[] = {1, -1, 0, 0};
        
        int visited[][] = new int[maps.length][maps[0].length()];
        Node lever = new Node(0, 0, 0);
        Node exit = new Node(0, 0, 0);
        Node start = new Node(0, 0, 0);
        for(int i=0; i<maps.length; i++){
            for(int r=0; r<maps[0].length(); r++){
                visited[i][r] = 100001;
                if(maps[i].charAt(r) == 'L') lever = new Node(r, i, 0);
                if(maps[i].charAt(r) == 'E') exit = new Node(r, i, 0);
                if(maps[i].charAt(r) == 'S') start = new Node(r, i, 0);
            }
        }
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(start);
        
        Node n;
        
        //출발점에서 레버로
        while(!queue.isEmpty()){
            n = queue.poll();
            
            if(visited[n.y][n.x] <= n.c) continue;
            visited[n.y][n.x] = n.c;
            
            if(maps[n.y].charAt(n.x) == 'L') continue;
            
            for(int i=0; i<4; i++){
                if(n.y+dy[i] < 0 || n.y+dy[i] >= maps.length || 
                   n.x+dx[i] < 0 || n.x+dx[i] >= maps[0].length() || 
                   maps[n.y+dy[i]].charAt(n.x+dx[i]) == 'X') continue;
                
                if(visited[n.y+dy[i]][n.x+dx[i]] > n.c + 1) 
                    queue.add(new Node(n.x+dx[i], n.y+dy[i], n.c+1));
            }
        }
        
        //레버 도달 불가
        if(visited[lever.y][lever.x] == 100001) return -1;
        else answer = visited[lever.y][lever.x];
        
        //레버에서 출구로
        for(int i=0; i<maps.length; i++){
            for(int r=0; r<maps[0].length(); r++){
                visited[i][r] = 100001;
            }
        }
        
        queue.clear();
        queue.add(lever);
        
        while(!queue.isEmpty()){
            n = queue.poll();
            
            if(visited[n.y][n.x] <= n.c) continue;
            visited[n.y][n.x] = n.c;
            
            if(maps[n.y].charAt(n.x) == 'E') continue;
            
            for(int i=0; i<4; i++){
                if(n.y+dy[i] < 0 || n.y+dy[i] >= maps.length || 
                   n.x+dx[i] < 0 || n.x+dx[i] >= maps[0].length() || 
                   maps[n.y+dy[i]].charAt(n.x+dx[i]) == 'X') continue;
                
                if(visited[n.y+dy[i]][n.x+dx[i]] > n.c + 1) 
                    queue.add(new Node(n.x+dx[i], n.y+dy[i], n.c+1));
            }
        }
        
        if(visited[exit.y][exit.x] == 100001) return -1;
        else answer += visited[exit.y][exit.x];
        
        return answer;
    }
}