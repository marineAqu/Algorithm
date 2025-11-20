import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        
        for(int i=1; i<n+1; i++) arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());

        //arr[a] - arr[b]가 가장 큰 a b를 구해야한다

        int minIndex = 0;
        int answer = -1001;

        for(int i=1; i<n+1; i++){
            answer = Math.max(answer, arr[i] - arr[minIndex]);
            if(arr[minIndex] > arr[i]) minIndex = i;
        }

        System.out.print(answer);
    }
}