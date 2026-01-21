class Solution {
    //문자열, 시작지점, 남은 갯수
    private int maxIndex(String n, int s, int k){
        int findMaxIndex = s;
        for(int i=s+1; i<n.length() - k; i++){
            if(n.charAt(i) > n.charAt(findMaxIndex)){
                findMaxIndex = i;
            }
        }
        
        return findMaxIndex;
    }
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int findMaxIndex = 0;
        
        for(int i=1; i<=number.length() - k; i++){
            findMaxIndex = maxIndex(number, findMaxIndex, number.length() - k - i);
            sb.append(number.charAt(findMaxIndex));
            findMaxIndex++;
        }
        
        return sb.toString();
    }
}