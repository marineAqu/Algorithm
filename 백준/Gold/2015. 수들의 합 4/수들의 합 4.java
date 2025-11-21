import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        
        int now = 0;
        int sum = 0;
        
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(st.nextToken());
            
            sum += now;
            if(sum == k) count++;
            
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }

            if(!map.containsKey(sum)) map.put(sum, 1);
            else map.put(sum, map.get(sum) + 1);
        }
        
        System.out.print(count);
    }
}