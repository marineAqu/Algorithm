class Solution {
    int max = 0;
    int size = 0;
    boolean visited[];
    int[][] info;
    
    public int solution(int k, int[][] dungeons) {
        size = dungeons.length;
        visited = new boolean[size];
        info = dungeons;
        //최소 필요 피로도, 소모 피로도
        //순서도 중요함. 던전의 개수는 최대8개
        dfs(0, 0, k);
        
        return max;
    }
    
    private void dfs(int depth, int count, int stress){
        max = Math.max(max, count);
        
        if(depth == size){
            return;
        }
        
        for(int i=0; i<size; i++){
            if(visited[i] || stress < info[i][0]) continue;
            
            visited[i] = true;
            dfs(depth+1, count+1, stress - info[i][1]);
            visited[i] = false;
        }
    }
}