import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 1;
        
        //시작점 기준 정렬
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);
        //-30,000 ~ 30,000
        
        int now = routes[0][1]; //끝지점
        
        for(int i=1; i<routes.length; i++) {
            if(routes[i][0] <= now) continue;
            
            now = routes[i][1];
            answer++;
        }
        
        return answer;
    }
}