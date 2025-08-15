import java.util.*;

class Solution{
    public int solution(int []A, int []B){
        int answer = 0;

        // 곱한 값을 누적해서 더하기
        // A의 가장 큰 수라면 B의 가장 작은 수랑 곱해야한다
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for(int i=0; i<A.length; i++){
            answer += A[i] * B[B.length - i - 1];
        }

        return answer;
    }
}