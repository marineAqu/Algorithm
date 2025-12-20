import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        //면이 3면이니까 

        //1 = 1
        //2 = 1
        //3 = 1
        //4 = 2
        //5 = 2
        //6 = 3
        //7 = 4
        //8 = 5
        //9 = 7
        //10 = 9

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[101];
        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;

        for(int i=4; i<101; i++){
            arr[i] = arr[i-2] + arr[i-3];
        }

        for(int i=0; i<n; i++){
            System.out.println(arr[Integer.parseInt(br.readLine())]);
        }
    }
}