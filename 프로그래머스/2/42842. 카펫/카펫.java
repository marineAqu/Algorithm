class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        //2x + 2y - 4 = brown; 
        //x + y = 2 + (brown / 2);
        //y*x - brown = yellow; 48
        
        int powVal = yellow + brown;
        
        for(int i=3; i<powVal; i++){
            if(powVal % i == 0 && i + (powVal / i) == 2 + (brown / 2)){
                answer[1] = i;
                answer[0] = powVal / i;
                
                break;
            }
        }
        
        return answer;
    }
}