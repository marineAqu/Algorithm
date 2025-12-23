import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int i, t;
    Node(int i, int t){
        this.i = i;
        this.t = t; //종료시각
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        
        StringTokenizer st;
        //종료시각 빠른 순 정렬
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.t - o2.t);
        int[] count = new int[n];
        int[] time = new int[n];
        int[] startTime = new int[n];
        
        LinkedList<Integer> list[] = new LinkedList[n];
        for(int i=0; i<n; i++) list[i] = new LinkedList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());

            st.nextToken();
            
            while(st.hasMoreTokens()){
                list[Integer.parseInt(st.nextToken()) - 1].add(i);
                count[i]++;
            }
        }
        
        for(int i=0; i<n; i++) {
            if(count[i] == 0) {
                queue.add(new Node(i, time[i]));
            }
        }
        
        Node now;
        while(!queue.isEmpty()){
            now = queue.poll();

            if(startTime[now.i] == answer) answer += time[now.i];
            else if(startTime[now.i] + time[now.i] > answer) {
                answer += time[now.i] - (answer - startTime[now.i]);
            }

            for(int next : list[now.i]) {
                count[next]--;
                if(count[next] == 0) {
                    queue.add(new Node(next, answer + time[next]));
                    startTime[next] = answer;
                }
            }
        }

        System.out.print(answer);
    }
}