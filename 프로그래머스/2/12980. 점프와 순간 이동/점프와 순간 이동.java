import java.util.*;

public class Solution {
    //k칸 점프 시 k만큼 건전지 사용
    //현재까지 온 거리x만큼 순간이동 가능
    
    public int solution(int n) {
        if(n == 1) return 1;
        
        if(n%2 == 0) return solution(n/2);
        else return solution(n/2) + 1;
    }
}