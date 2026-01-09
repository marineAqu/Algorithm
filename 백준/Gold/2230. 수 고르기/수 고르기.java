import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long arr[] = new long[n];

        for(int i=0; i<n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        
        int s = 0;
        int e = 1;

        long answer = arr[n-1] - arr[0];
        while(s <= e && e < n){
            if(arr[e] - arr[s] >= m) {
                answer = Math.min(arr[e] - arr[s], answer);
                s++;
            }
            else {
                e++;
            }
        }

        System.out.print(answer);
    }
}