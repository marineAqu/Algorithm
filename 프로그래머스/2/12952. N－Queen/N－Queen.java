class Solution {
    int map[];
    
    public int solution(int n) {
        map = new int[n];
        
        return queen(n, 0);
    }
    
    private int queen(int n, int depth){
        if(depth == n){
            return 1;
        }
        
        int sum = 0;
        boolean flag;
        
        for (int i=0; i<n; i++) {
            flag = false;
            for (int r=0; r<depth; r++) { //1
                if (map[r] == i || i == map[r] + depth - r || i == map[r] - (depth - r)) {
                    flag = true;
                    break;
                }
            }
            
            if(flag) continue;
            
            map[depth] = i;
            sum += queen(n, depth + 1);
        }
        
        return sum;
    }
}