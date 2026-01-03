import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String arr[];
    static StringBuilder sb = new StringBuilder();
    static StringBuilder sbForNull = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        arr = new String[n+1];

        arr[1] = "*";
        arr[2] = "* *";
        arr[3] = "*****";
        
        make(n, 3);

        sb.setLength(0);
        for(int i=1; i<=n; i++) {
            sb.append(makeNull(n-i)).append(arr[i]).append(makeNull(n-i)).append("\n");
        }
        System.out.print(sb);
    }

    //0, 1, 2
    //3, 4, 5
    //6, 7, 8, 9, 10, 11
    private static void make(int goal, int now){
        if(goal <= now) return;
        
        for(int i=1; i<=now; i++){
            sb.setLength(0);
            arr[now+i] = sb.append(arr[i]).append(makeNull((now+i) * 2 - 1 - (arr[i].length() * 2))).append(arr[i]).toString();
        }
        
        make(goal, now*2);
    }

    private static String makeNull(int n){
        sbForNull.setLength(0);
        for(int i=0; i<n; i++) sbForNull.append(" ");
        return sbForNull.toString();
    }
}