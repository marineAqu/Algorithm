import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //k개를 뽑되 서로 다른 종류가 최소
        
        //정렬 -> 갯수 저장
        
        Arrays.sort(tangerine);
        int size[] = new int[tangerine.length];
        
        int sizeIndex = 0;
        size[0] = 1;
        
        for(int i=1; i<tangerine.length; i++){
            if(tangerine[i] != tangerine[i-1]){
                sizeIndex++;
            }
            
            size[sizeIndex]++;
        }
        
        Arrays.sort(size);
        
        sizeIndex = size.length - 1;
        
        
        while(k > 0){
            answer++;
            
            if(k - size[sizeIndex] > 0){
                k -= size[sizeIndex--];
            }
            
            else{
                break;
            }
        }
        
        return answer;
    }
}