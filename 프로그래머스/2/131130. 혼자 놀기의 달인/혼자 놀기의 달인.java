class Solution {
    int boss[];
    boolean visited[];
    
    private int find(int i){
        if(boss[i] == i) return i;
        if(visited[i]) return boss[i];
        visited[i] = true;
        return boss[i] = find(boss[i]);
    }
    
    private int dfs(int n){
        int sum = 0;
        int target = boss[n];
        
        for(int i=1; i<boss.length; i++){
            if(boss[i] == target) {
                sum++;
                boss[i] = 0;
            }
        }
        
        return sum;
    }
    
    public int solution(int[] cards) {
        boss = new int[cards.length + 1];
        visited = new boolean[cards.length + 1];
        
        for(int i=0; i<cards.length; i++) boss[i+1] = cards[i];
        
        for(int i=1; i<cards.length + 1; i++) {
            find(i);
        }
        
        for(int i=1; i<cards.length + 1; i++) {
            System.out.print(boss[i]+", ");
        }
        
        int max1 = 0;
        int max2 = 0;
        int now;
        
        for(int i=1; i<cards.length + 1; i++) {
            if(boss[i] == 0) continue;
            
            now = dfs(i);
            
            if(max1 < now){
                max2 = max1;
                max1 = now;
            }
            
            else if(max2 < now){
                max2 = now;
            }
        }
        
        return max1 * max2;
    }
}