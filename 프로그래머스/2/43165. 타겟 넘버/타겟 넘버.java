class Solution {
    static int ptarget;
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        ptarget = target;
        
        //+, - 2가지 경우가 있고
        //제일 먼저 올 수 있는 수는 numbers.length 만큼
        //숫자 변경 불가
        
        //+
        answer += dfs(numbers, 1, numbers[0]);
            
        //-
        answer += dfs(numbers, 1, numbers[0] * -1);
        
        
        return answer;
    }
    
    //조합이라 중복이 안된다는 거
    //이미 0, 1 했으면 걔네는 사용할 수 없다
    
    private int dfs(int[] numbers, int depth, int sum){
        int answer = 0;
        
        if (depth == numbers.length) {
            if(sum == ptarget) return 1;
            else return 0;
        }
        
        //+
        answer += dfs(numbers, depth+1, sum + numbers[depth]);
            
        //-
        answer += dfs(numbers, depth+1, sum + (numbers[depth] * -1));
        
        return answer;
    }
}