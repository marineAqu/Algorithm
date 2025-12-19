import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String s = br.readLine();

        int arr[] = new int[26];
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Stack<Double> stack = new Stack<>();
        double temp;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '*'){
                stack.push(stack.pop() * stack.pop());
            }
            else if(s.charAt(i) == '+'){
                stack.push(stack.pop() + stack.pop());
            }
            else if(s.charAt(i) == '-'){
                temp = stack.pop();
                stack.push(stack.pop() - temp);
            }
            else if(s.charAt(i) == '/'){
                temp = stack.pop();
                stack.push(stack.pop() / temp);
            }

            //알파벳
            else {
                stack.push((double) arr[s.charAt(i) - 'A']);
            }
        }

        System.out.print(String.format("%.2f", stack.pop()));
    }
}