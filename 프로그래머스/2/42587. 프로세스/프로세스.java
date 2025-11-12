class Solution {
    public int solution(int[] priorities, int location) {
        int time = 0;
        int nowIndex = 0;
        
        while(true) {
            nowIndex = findMaxRankIndex(priorities, nowIndex);
            
            time++;
            priorities[nowIndex] = 0;
            if(nowIndex == location) break;
        }
        
        return time;
    }
    
    private int findMaxRankIndex(int[] arr, int now){
        int info[] = new int[2];
        
        for(int i=now; i<arr.length; i++){
            if(arr[i] > info[0]){
                info[0] = arr[i];
                info[1] = i;
            }
        }
        for(int i=0; i<now; i++){
            if(arr[i] > info[0]){
                info[0] = arr[i];
                info[1] = i;
            }
        }
        return info[1];
    }
}