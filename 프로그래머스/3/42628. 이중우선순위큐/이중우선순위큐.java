import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        
        TreeSet<Integer> tree = new TreeSet<>();
        StringTokenizer st;
        
        for(int i=0; i<operations.length; i++) {
            st = new StringTokenizer(operations[i]);
            
            if(st.nextToken().equals("I")){
                tree.add(Integer.parseInt(st.nextToken()));
            }
            
            else if(st.nextToken().equals("1")){
                if(!tree.isEmpty()) tree.pollLast();
            }
            
            else{
                if(!tree.isEmpty()) tree.pollFirst();
            }
        }
        
        if(!tree.isEmpty()) answer[0] = tree.pollLast();
        
        if(!tree.isEmpty()) answer[1] = tree.pollFirst();
        else answer[1] = answer[0];
        
        return answer;
    }
}