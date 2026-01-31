import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        //토핑의 개수가 공평해야 한다. 공평하게 자를 수 있는 방법의 수
        
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        int count1[] = new int[10_001];
        int count2[] = new int[10_001];
        
        set1.add(topping[0]);
        count1[topping[0]]++;
        
        for(int i=1; i<topping.length; i++){
            set2.add(topping[i]);
            count2[topping[i]]++;
        }
        
        if(set1.size() == set2.size()) answer++;
        
        for(int i=1; i<topping.length-1; i++){               
            count1[topping[i]]++;
            if(count1[topping[i]] == 1) set1.add(topping[i]);
            count2[topping[i]]--;
            if(count2[topping[i]] == 0) set2.remove(topping[i]);
            
            //결산
            if(set1.size() == set2.size()) answer++;
        }
        
        return answer;
    }
}