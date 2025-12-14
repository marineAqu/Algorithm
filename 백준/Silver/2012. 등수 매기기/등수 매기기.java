import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n+1];
        for(int i=1; i<=n; i++) arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        //불만도 최소로

        long result = 0;
        for(int i=1; i<=n; i++){
            result += Math.abs(arr[i] - i);
        }

        System.out.print(result);
    }
}