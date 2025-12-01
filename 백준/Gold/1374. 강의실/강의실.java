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
        int n = Integer.parseInt(br.readLine()); //강의 수

        int info[][] = new int[n][2];
        
        StringTokenizer st;
        int index;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            index = Integer.parseInt(st.nextToken()) - 1;
            info[index][0] = Integer.parseInt(st.nextToken());
            info[index][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        
        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> {
            if(o1.e == o2.e) return o1.s - o2.s;
            return o1.e - o2.e;
        });
        
        queue.add(new Node(info[0][0], info[0][1]));

        Node node;
        for(int i=1; i<n; i++){
            node = queue.poll();
            
            if(node.e <= info[i][0]) {
                queue.add(new Node(info[i][0], info[i][1]));
            }
            else{
                queue.add(node);
                queue.add(new Node(info[i][0], info[i][1]));
            }
        }

        System.out.print(queue.size());
    }

}
