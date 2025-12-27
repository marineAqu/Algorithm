import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int now;
        long answer = 0;
        for(int i=0; i<n; i++) {
            now = Integer.parseInt(br.readLine());
            
            while(!stack.isEmpty()){
                if(stack.peek() <= now) stack.pop();
                else break;
            }

            answer += stack.size();
            stack.push(now);
        }

        System.out.print(answer);
    }
}