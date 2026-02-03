import java.util.*;

class Solution {
    public int[] solution(String msg) {
        LinkedList<Integer> list = new LinkedList<>();
        
        int n = 27;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<26; i++){
            map.put(String.valueOf((char) (i+65)), i+1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(msg.charAt(0));
        
        for(int i=1; i<msg.length(); i++){
            sb.append(msg.charAt(i));
            
            if(map.containsKey(String.valueOf(sb.toString()))) {
                continue;
            }
            
            else {
                map.put(String.valueOf(sb.toString()), n++);
                
                list.add(map.get(sb.deleteCharAt(sb.length()-1).toString()));
                
                sb.setLength(0);
                sb.append(msg.charAt(i));
            }
        }
        
        list.add(map.get(sb.toString()));
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.poll();
        }
        
        return answer;
    }
}