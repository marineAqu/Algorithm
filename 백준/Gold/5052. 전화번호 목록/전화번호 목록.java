import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] map = new String[n];

            for(int r=0; r<n; r++){
                map[r] = br.readLine();
            }

            Arrays.sort(map);

            boolean flag = false;
            
            for(int r=1; r<n; r++){
                if(map[r-1].length() <= map[r].length()){
                    if(map[r].substring(0, map[r-1].length()).equals(map[r-1])){
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                }
            }

            if(!flag) System.out.println("YES");
        }
    }
}