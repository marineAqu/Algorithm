import java.util.*;

class Node{
    int i;
    String uid;
    Node(int i, String uid){
        this.i = i;
        this.uid = uid;
    }
}

class Solution {
    public String[] solution(String[] record) {
        StringTokenizer st;
        Map<String, String> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        String[] s = new String[2];
        s[0] = "님이 들어왔습니다.";
        s[1] = "님이 나갔습니다.";
        
        String uid;
        for(int i=0; i<record.length; i++){
            st = new StringTokenizer(record[i]);
            
            if(st.nextToken().charAt(0) == 'E'){
                uid = st.nextToken();
                queue.add(new Node(0, uid));
                map.put(uid, st.nextToken());
            }
            else if(record[i].charAt(0) == 'L'){
                queue.add(new Node(1, st.nextToken()));
            }
            else{
                map.put(st.nextToken(), st.nextToken());
            }
        }
        
        String[] answer = new String[queue.size()];
        
        Node n;
        for(int i=0; i<answer.length; i++){
            n = queue.poll();
            if(n.i == 0) answer[i] = map.get(n.uid) + s[0];
            else answer[i] = map.get(n.uid) + s[1];
        }
        
        return answer;
    }
}