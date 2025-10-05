import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 1;
        //끝나는 걸 기준으로 오름차, 같으면 시작한 걸 기준으로
        
        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            else return o1[1] - o2[1];
        });
        
        int timemax = 0;
        int endtime = targets[0][1];
        
        for(int i=1; i<targets.length; i++){
            if(targets[i][0] < endtime) continue;
            else {
                answer++;
                endtime = targets[i][1];
            }
        }
        
        return answer;
    }
}