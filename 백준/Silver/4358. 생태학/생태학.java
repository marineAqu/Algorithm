import java.util.*;
import java.io.*;

class Node{
    String name;
    int c;

    Node(String name, int c){
        this.name = name;
        this.c = c;
    }
}

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> map = new HashMap<>();

        String s;
        int count = 0;
        while((s = br.readLine()) != null){
            count++;
            
            if(map.containsKey(s)){
                map.put(s, map.get(s)+1);
            }
            else map.put(s, 1);
        }

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.name.compareTo(o2.name));
        map.forEach((k, v) -> {
            queue.add(new Node(k, v));
        });

        Node node;
        while(!queue.isEmpty()){
            node = queue.poll();
            
            System.out.println(node.name + " " + String.format("%.4f", (double)node.c / count * 100));
        }
    }
}