import java.util.*;

class Solution {
    int size;
    Map<String, LinkedList> map = new HashMap<>();
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        size = tickets.length+1;
        answer = new String[size];
        
        //저장
        for(int i=0; i<size-1; i++) {
            //출발점
            if(map.get(tickets[i][0]) != null) {
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
            else{
                map.put(tickets[i][0], new LinkedList<String>());
                map.get(tickets[i][0]).add(tickets[i][1]);
            }
            
            //도착점
            if(map.get(tickets[i][1]) == null) {
                map.put(tickets[i][1], new LinkedList<String>());
            }
        }
        
        //정렬
        map.forEach((k, v)->
            Collections.sort(v)
        );
        
        //알파벳 순서가 앞서는 경로 탐색
        answer[0] = "ICN";
        dfs("ICN", 1);
        
        return answer;
    }
    
    private boolean dfs(String now, int depth) {
        if(depth == size) {
            return true;
        }
        
        String next;
        int s = map.get(now).size();
        int count = 0;
        
        while(s > count){
            count++;
            next = (String) map.get(now).poll();
            
            answer[depth] = next;
            if(dfs(next, depth+1)) return true;
            
            else map.get(now).add(next);
        }
        
        return false;
    }
}