import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());

        //g = 현재몸무게^2 - 기억하고 있던 몸무게^2
        // 16    64
        //g+ 1 4 9 16
        long[] arr = new long[50001];

        HashSet<Long> set = new HashSet<>();
        for(int i=1; i<50001; i++){
            arr[i] = (long) Math.pow(i, 2);
            set.add(arr[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=1; i<50001; i++){
            if(set.contains(g + arr[i])) queue.add((int) Math.sqrt(g+arr[i]));
        }

        if(queue.isEmpty()) System.out.print(-1);
        else{
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }
    }
}