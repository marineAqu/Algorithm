class Solution {
    int map[];
    int count = 0;
    
    public int solution(int n) {
        map = new int[n];
        
        queen(n, 0);
        
        return count;
    }
    
    private void queen(int n, int depth){
        if(depth == n) {
            count++;
            return;
        }
        
        boolean flag = true;
        
        for(int i=0; i<n; i++){
            flag = true;
            for(int r=0; r<depth; r++){
                if(map[r] == i || map[r]+(depth - r) == i || map[r]-(depth - r) == i) {
                    flag = false;
                    break;
                }
            }
            
            if(flag){
                map[depth] = i;
                queen(n, depth+1);
            }
        }
    }
}