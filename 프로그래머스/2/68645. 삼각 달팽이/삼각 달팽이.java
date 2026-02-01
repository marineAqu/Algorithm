class Solution {
    public int[] solution(int n) {
        if(n == 1) return new int[] {1};
        
        int[][] arr = new int[n][n];
        
        arr[0][0] = 1;

        dfs(n, arr, 0, 0, 0);
        
        int answer[] = new int[size(n)];
        int index=0;
        
        for(int i=0; i<n; i++){
            for(int r=0; r<=i; r++){
                answer[index++] = arr[i][r];
            }
        }
        
        return answer;
    }
    
    private void dfs(int n, int arr[][], int dirc, int x, int y){ //0 하강, 1 오른쪽, 2위
        int nowNum = arr[y][x] + 1;
        
        if(dirc == 0) y++;
        if(dirc == 1) x++;
        if(dirc == 2) {
            y--;
            x--;
        }
        
        if(arr[y][x] != 0) return;
        
        while(true) {
            if(arr[y][x] != 0) break;
            if(dirc == 1 && y < x) break;
            
            arr[y][x] = nowNum++;
                
            if(dirc == 0) {
                if(arr.length <= y+1 || arr[y+1][x] != 0) break;
                y++;
            }
            else if(dirc == 1) {
                if(y < x+1 || arr[y][x+1] != 0) break;
                x++;
            }
            else if(dirc == 2) {
                if(y-1 < 0 || x-1 < 0 || arr[y-1][x-1] != 0) break;
                y--;
                x--;
            }
        }
        
        dfs(n, arr, (dirc + 1) % 3, x, y);
    }
    
    private int size(int n){
        if(n == 1) return 1;
        return size(n-1) + n;
    }
}