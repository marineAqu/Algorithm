class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int now = clacMinFormat(pos);
        int o_s = clacMinFormat(op_start);
        int o_e = clacMinFormat(op_end);
        int len = clacMinFormat(video_len);
        
        for(int i=0; i<commands.length; i++){
            if(o_s <= now && now <= o_e) now = o_e;
            
            
            if(commands[i].equals("next")){
                if(now + 10 <= len) now += 10;
                else now = len;
            }
            else if(commands[i].equals("prev")){
                if(now - 10 >= 0) now -= 10;
                else now = 0;
            }
        }
        
        if(o_s <= now && now <= o_e) now = o_e;
        
        String answer = String.format("%02d", (now / 60)) + ":" + String.format("%02d", (now % 60));
        
        return answer;
    }
    
    private int clacMinFormat(String pos){
        int now = (pos.charAt(0) - '0') * 10 + (pos.charAt(1) - '0');
        now *= 60;
        now += (pos.charAt(3) - '0') * 10 + (pos.charAt(4) - '0');
        
        return now;
    }
}