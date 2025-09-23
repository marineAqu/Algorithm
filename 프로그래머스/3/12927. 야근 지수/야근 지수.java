import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        //큰 값을 줄이고 평균값에 가까워지도록 해야한다
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for(int i=0; i<works.length; i++) queue.add(works[i]);
        
        int now;
        while(n > 0 && !queue.isEmpty()){
            n--;
            now = queue.poll();
            if(now - 1 == 0) continue;
            queue.add(now-1);
        }
        
        while(!queue.isEmpty()){
            answer += Math.pow(queue.poll(), 2);
        }
        
        return answer;
    }
}