import java.util.*;
import java.io.*;

class Main {
    private static int findMaxIndex(int arr[], int i){
        int m = i;
        for(int r=i+1; r<arr.length; r++){
            if(arr[m] < arr[r]) m = r;
        }

        return m;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int n;
        int arr[];
        StringTokenizer st;
        long answer = 0;
            
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            answer = 0;

            for(int r=0; r<n; r++) {
                arr[r] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            
            for (int r = n - 1; r >= 0; r--) {
                if (arr[r] > max) {
                    max = arr[r];
                } else {
                    answer += max - arr[r];
                }
            }

            System.out.println(answer);
        }
    }
}