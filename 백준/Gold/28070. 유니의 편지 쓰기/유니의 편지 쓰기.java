import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int s, e;

    Node(int s, int e){
        this.s = s;
        this.e = e;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.e == o2.e) return o1.s - o2.s;
            return o1.e - o2.e;
        });
        int info[][] = new int[n][2];

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            info[i][0] = Integer.parseInt(st.nextToken().replace("-", ""));
            info[i][1] = Integer.parseInt(st.nextToken().replace("-", ""));
        }

        Arrays.sort(info, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        queue.add(new Node(info[0][0], info[0][1]));
        Node node;
        int size = 1;
        int answer = info[0][0];
        
        for(int i=1; i<n; i++){
            node = queue.poll();

            if(node.e < info[i][0]){
                queue.add(new Node(info[i][0], info[i][1]));
            }

            else{
                queue.add(node);
                queue.add(new Node(info[i][0], info[i][1]));
            }

            if(queue.size() > size){
                size = queue.size();
                answer = info[i][0];
            }
        }

        StringBuffer s = new StringBuffer(Integer.toString(answer)).insert(4, "-");
        System.out.print(s);
    }
}