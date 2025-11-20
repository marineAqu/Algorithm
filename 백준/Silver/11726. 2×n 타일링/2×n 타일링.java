import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long arr[] = new long[n+1];

        arr[1] = 1;
        if(n > 1) arr[2] = 2;
        if(n > 2) arr[3] = 3;

        for(int i=4; i<n+1; i++){
            arr[i] = arr[i-1] + arr[i-2];
            arr[i] %= 10007;
        }

        System.out.print(arr[n]);
    }
}