import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        //n편 중 h번 이상 인용된 논문이 h개 이상이고 나머지가 h번 이하 인용됐다면 h
        int n = citations.length;
        Arrays.sort(citations);
        
        for(int i=0; i<n; i++){
            if(n-i >= citations[i]) answer = citations[i];
            else {
                for(int r=answer+1; r<citations[i]; r++){
                    if(n-i >= r) answer = Math.max(answer, r);
                    else break;
                }
                break;
            }
        }
        
        return answer;
    }
}