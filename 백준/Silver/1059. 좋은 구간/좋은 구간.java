import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[l];
        for(int i=0; i<l; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int n = Integer.parseInt(br.readLine());
        
        int max = arr[l-1] - 1, min = 1;

        if(Arrays.binarySearch(arr, n) >= 0) {
            System.out.print(0);
            System.exit(0);
        }
        
        for(int i=0; i<l; i++){
            if(arr[i] > n && arr[i] <= max) max = arr[i] - 1;
            if(arr[i] < n && arr[i] >= min) min = arr[i] + 1;
        }

        System.out.print((n - min + 1) * (max - n + 1) - 1);
    }
}