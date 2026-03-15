import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int a;

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            a = Integer.parseInt(st.nextToken());
            if(set.contains(a)) continue;

            set.add(a);
            list.add(a);
        }

        Collections.sort(list);

        while(!list.isEmpty()){
            System.out.print(list.poll()+" ");
        }   
    }
}