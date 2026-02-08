import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] timeInfo = new int[3];

        Set<String> set = new HashSet<>();
        String line, t, n;
        int now;
        int answer = 0;
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<3; i++) {
            t = st.nextToken();
            now = ((t.charAt(0) - 'A') * 10 + (t.charAt(1) - 'A')) * 60 + 
              (t.charAt(3) - 'A') * 10 + (t.charAt(4) - 'A');
            timeInfo[i] = now;
        }
        
        while((line = br.readLine()) != null){
            st = new StringTokenizer(line);
            t = st.nextToken();
            n = st.nextToken();

            now = ((t.charAt(0) - 'A') * 10 + (t.charAt(1) - 'A')) * 60 + 
              (t.charAt(3) - 'A') * 10 + (t.charAt(4) - 'A');
            
            if(now <= timeInfo[0]) {
                set.add(n);
            }

            else if(now >= timeInfo[1] && now <= timeInfo[2]){
                if(set.contains(n)) {
                    answer++;
                    set.remove(n);
                }
            }
        }
        
        System.out.print(answer);
    }
}