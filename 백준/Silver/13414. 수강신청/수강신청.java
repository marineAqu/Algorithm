import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        String arr[] = new String[l];

        for(int i=0; i<l; i++){
            arr[i] = br.readLine();
            if(map.containsKey(arr[i])){
                arr[map.get(arr[i])] = null;
                map.put(arr[i], i);
            }
            else map.put(arr[i], i);
        }

        int count = 0;
        for(int i=0; i<l; i++){
            if(arr[i] != null) {
                System.out.println(arr[i]);
                count++;
            }
            if(count == k) break;
        }
    }
}