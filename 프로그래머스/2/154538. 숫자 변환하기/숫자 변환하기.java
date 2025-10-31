import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        //x에 n을 더하기
        //x에 2 곱하기
        //x에 3 곱하기

        int arr[] = new int[y+1];
        Arrays.fill(arr, 1_000_001);
        arr[x] = 0;
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        
        int now;
        while(!queue.isEmpty()){
            now = queue.poll();
            
            if(now+n <= y && arr[now + n] > arr[now]+1){
                arr[now + n] = arr[now]+1;
                queue.add(now+n);
            }
            
            if(now*2 <= y && arr[now*2] > arr[now]+1){
                arr[now*2] = arr[now]+1;
                queue.add(now*2);
            }
            
            if(now*3 <= y && arr[now*3] > arr[now]+1){
                arr[now*3] = arr[now]+1;
                queue.add(now*3);
            }
        }
        
        if(arr[y] == 1_000_001) return -1;
        return arr[y];
    }
}