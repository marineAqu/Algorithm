import java.util.*;

class Node{
    int a, b, c;
    Node(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        PriorityQueue<Node> sortedJob = new PriorityQueue<>((o1, o2) -> {
            if(o1.b != o2.b) return o1.b - o2.b; //요청시간
            else if(o1.a != o2.a) return o1.a - o2.a; //소요시간
            return o1.c - o2.c; //작업 번호가 작은 것
        });
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.a != o2.a) return o1.a - o2.a; //소요시간
            else if(o1.b != o2.b) return o1.b - o2.b; //요청시간
            return o1.c - o2.c; //작업 번호가 작은 것
        });
        
        for(int i=0; i<jobs.length; i++){
            sortedJob.add(new Node(jobs[i][1], jobs[i][0], i));
        }
        
        int nowtime = 0;
        
        Node n;
        while(!queue.isEmpty() || !sortedJob.isEmpty()){
            //작업 큐가 비어있다면 다음 작업이 있는 시간으로 건너뛴다
            if(queue.isEmpty() && !sortedJob.isEmpty()) {
                n = sortedJob.poll();
                if(nowtime < n.b) nowtime = n.b;
                queue.add(n);
            }
            
            //nowtime까지 쌓인 작업들을 모두 작업큐에 담는다
            while(!sortedJob.isEmpty()){
                n = sortedJob.poll();
                
                if(n.b > nowtime){
                    sortedJob.add(n);
                    break;
                }
                
                queue.add(n);
            }
            
            n = queue.poll();
            
            if(n.b > nowtime) nowtime = n.b; //시작
            
            nowtime += n.a; //현 시간을 종료 시간으로 업데이트
            answer += nowtime - n.b;
        }
        
        return answer / jobs.length;
    }
}