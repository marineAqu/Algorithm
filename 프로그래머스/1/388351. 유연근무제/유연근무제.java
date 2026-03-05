class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        boolean flag;
        int sum = 0;
        
        for(int i=0; i<schedules.length; i++){
            sum = (schedules[i] / 100) * 60;
            sum += schedules[i] % 100;
            
            schedules[i] = sum;
        }
        
        for(int i=0; i<timelogs.length; i++){
            for(int r=0; r<timelogs[i].length; r++){
                sum = (timelogs[i][r] / 100) * 60;
                sum += timelogs[i][r] % 100;
            
                timelogs[i][r] = sum;
            }
        }
        
        for(int i=0; i<schedules.length; i++){
            flag = true;
            
            for(int r=0; r<7; r++){
                if((r + startday) % 7 == 6 || (r + startday) % 7 == 0) continue;
                
                if(timelogs[i][r] > schedules[i] + 10){
                    flag = false;
                    break;
                }
            }
            
            if(flag) answer++;
        }
        
        return answer;
    }
}