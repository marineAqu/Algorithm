import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
                
        for(int i=0; i<elements.length; i++){
            set.add(elements[i]);
            queue.add(elements[i]);
        }
        
        int temp = 0;
        for(int i=1; i<elements.length; i++){
            for(int r=0; r<elements.length; r++){
                if(r+i >= elements.length) {
                    temp = queue.poll() + elements[(r+i) % elements.length];
                }
                else temp = queue.poll() + elements[r+i];
                
                queue.add(temp);
                set.add(temp);
            }
        }
        
        return set.size();
    }
}