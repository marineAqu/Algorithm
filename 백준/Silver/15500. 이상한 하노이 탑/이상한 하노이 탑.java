import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int count = 0;
    
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        
        int arr[] = new int[n];
        int find[] = new int[n+1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            find[arr[i]] = 1;
            st1.push(arr[i]);
        }
        
        for(int i=n; i>0; i--) {
            if(find[i] == 1){
                while(st1.peek() != i){
                    count++;
                    find[st1.peek()] = 2;
                    sb.append("1 2\n");
                    st2.push(st1.pop());
                }
                count++;
                sb.append("1 3\n");
                st1.pop();
            }

            if(find[i] == 2){
                while(st2.peek() != i){
                    count++;
                    find[st2.peek()] = 1;
                    sb.append("2 1\n");
                    st1.push(st2.pop());
                }
                count++;
                sb.append("2 3\n");
                st2.pop();
            }
        }
        
        System.out.println(count);
        System.out.print(sb);
    }

}