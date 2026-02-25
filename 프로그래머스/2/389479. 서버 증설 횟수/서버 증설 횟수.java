import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int now;
        int size;
        
        //m명 늘어날 때마다 1대 증설. m명 미만이면 괜찮음
        
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        
        for(int i=0; i<players.length; i++){
            //한 시간씩 단축
            
            while(players[i] / m > queue.size() - 1) {
                queue.add(k);
                answer++;
            }
            
            queue.add(0);
            
            
            queue.poll(); //마지막 노드 제거 
            
            while(queue.peek() != 0){
                now = queue.poll();
                if(now == 1) continue;
                queue.add(now - 1);
            }
        }
        
        return answer;
    }
}
