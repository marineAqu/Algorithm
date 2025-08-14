import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        
        String now;
        int answer = 0;
        for(int i=0; i<n; i++){
            now = br.readLine();
            if(now.length() % 2 == 1) {
                continue;
            }
            answer += calc(now);
        }

        System.out.print(answer);
    }

    //일단 홀수개이면 무조건 pass (남는 것이 생김)
    //스택 문제인가
    //짝수개면 남는 게 없어야하고, 중간에 하나가 껴 있는 경우면 안됨
    private static int calc(String now){
        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<now.length(); i++){
            if(!stack.empty() && stack.peek() == now.charAt(i) - (int)'A') {
                stack.pop();
                continue;
            }
            stack.add(now.charAt(i) - (int)'A');
        }

        if(stack.empty()) return 1;
        else return 0;
    }
}