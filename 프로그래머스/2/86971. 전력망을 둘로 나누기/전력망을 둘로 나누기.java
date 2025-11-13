import java.util.*;

class Solution {
    LinkedList<Integer> adj[];
    boolean visited[];
    
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        visited = new boolean[n+1];
        adj = new LinkedList[n+1];
        for(int i=0; i<n+1; i++) adj[i] = new LinkedList<>();
        
        for(int i=0; i<n-1; i++){
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        //calc
        int now;
        for(int i=0; i<n-1; i++){
            Arrays.fill(visited, false);
            
            adj[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            adj[wires[i][1]].remove(Integer.valueOf(wires[i][0]));
            
            now = dfs(wires[i][0]);
            answer = Math.min(Math.abs(now - (n - now)), answer);
            
            adj[wires[i][0]].add(wires[i][1]);
            adj[wires[i][1]].add(wires[i][0]);
        }
        
        return answer;
    }
    
    private int dfs(int now){
        int sum = 1;
        visited[now] = true;
        
        for(int n : adj[now]){
            if(!visited[n]) sum += dfs(n);
        }
        
        return sum;
    }
}