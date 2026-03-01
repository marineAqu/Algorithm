class Solution {
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        int visited[][][] = new int[m][n][2];
        visited[0][1][0] = 1;
        visited[1][0][1] = 1;
        //오른쪽으로 가거나 아래로 가는 것만 가능. 내 지점에선 왼쪽과 오른쪽을 더하면 됨
        
        if(m == 0 && n == 0) return 1;
        
        for(int q=0; q<m; q++){
            for(int p=0; p<n; p++){
                if(cityMap[q][p] == 1){
                    continue;
                }
                
                else{
                    if(q == 0 && p == 0) continue;
                    
                    if(q != 0) {
                        if(cityMap[q-1][p] == 2) {
                            visited[q][p][1] += visited[q-1][p][1];
                            visited[q][p][1] %= MOD;
                        }
                        else {
                            visited[q][p][1] += visited[q-1][p][0];
                            visited[q][p][1] %= MOD;
                            
                            visited[q][p][1] += visited[q-1][p][1];
                            visited[q][p][1] %= MOD;
                        }
                    }
                    
                    if(p != 0) {
                        if(cityMap[q][p-1] == 2) {
                            visited[q][p][0] += visited[q][p-1][0];
                            visited[q][p][0] %= MOD;
                        }
                        else {
                            visited[q][p][0] += visited[q][p-1][0];
                            visited[q][p][0] %= MOD;
                            
                            visited[q][p][0] += visited[q][p-1][1];
                            visited[q][p][0] %= MOD;
                        }
                    }
                }
            }
        }
        
        /*for(int q=0; q<m; q++){
            for(int p=0; p<n; p++){
                System.out.print(visited[q][p][0] + "*" + visited[q][p][1] +" ");
            }
            System.out.println();
        }*/
        
        return (visited[m-1][n-1][0] + visited[m-1][n-1][1]) % MOD;
    }
}