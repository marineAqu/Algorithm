import java.util.*;

class Solution {
    int[] salePercent;
    
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        
        //서비스 가입자를 최대한 늘리고, 이모티콘 판매액 늘리기
        Arrays.sort(emoticons);
        Arrays.sort(users, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });
        
        //비율을 늘리되 가격은 넘어야 함
        //가격 배열을 저장해두고
        salePercent = new int[emoticons.length];
        for(int i=0; i<emoticons.length; i++) salePercent[i] = 10;
        
        int priceSum = 0;
        int nowsum = 0;
        
        int plusCount = 0, priceCount = 0;
        
        //할인율을 각 이모티콘마다 별도로 설정할 수 있다
        //이모티콘이 총 7개고 4개의 경우가 있으니 2401개의 경우가 있음
        //그러면 각 경우에 대해 100명의 유저의 형태를 계산해야한다
        //할인율
        
        while(true){
            plusCount = 0;
            priceCount = 0;
            
            //각 유저 계산
            for(int r=0; r<users.length; r++){
                nowsum = 0;
                for(int q=0; q<emoticons.length; q++){
                    if(salePercent[q] >= users[r][0])
                        nowsum += (emoticons[q] / 100 * (100 - salePercent[q]));
                }
                
                if(nowsum >= users[r][1]) plusCount++;
                else priceCount += nowsum;
            }
            
            //answer 업데이트
            if(answer[0] < plusCount) {
                answer[0] = plusCount;
                answer[1] = priceCount;
            }
            else if(answer[0] == plusCount && answer[1] < priceCount){
                answer[1] = priceCount;
            }
            
            if(moveSalePercent() == -1) break;
        }
        
        return answer;
    }
    
    private int moveSalePercent(){
        for(int i=salePercent.length-1; i>=0; i--){
            if(salePercent[i] != 40) {
                salePercent[i] += 10;
                break;
            }
            else {
                if(i == 0) return -1;
                salePercent[i] = 10;
            }
        }
        
        return 1;
    }
}