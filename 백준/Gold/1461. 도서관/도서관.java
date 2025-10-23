import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean flag = false;
        
        LinkedList<Integer> plusNum = new LinkedList<>();
        LinkedList<Integer> minusNum = new LinkedList<>();
        int now = 0, max = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<n; i++){
            now = Integer.parseInt(st.nextToken());
            if(now > 0) plusNum.add(now);
            else minusNum.add(now);

            if(Math.abs(now) > Math.abs(max)) max = now;
        }

        Collections.sort(plusNum, Collections.reverseOrder()); // 100, 1..
        Collections.sort(minusNum); //-110 -1 ..
        
        //큰 숫자가 있는 쪽은
        //절댓값 큰쪽부터 계산:
        // 처음만 편도로 계산
        
        //계산
        while(!plusNum.isEmpty()){
            for(int i=0; i<m; i++){
                if(i == 0) now = plusNum.poll();
                else plusNum.poll();
                if(plusNum.isEmpty()) break;
            }

            if(!flag && max > 0){
                answer += now;
                flag = true;
                continue;
            }
            
            answer += now * 2;
        }

        while(!minusNum.isEmpty()){
            for(int i=0; i<m; i++){
                if(i == 0) now = minusNum.poll();
                else minusNum.poll();
                if(minusNum.isEmpty()) break;
            }

            if(!flag && max < 0){
                answer += Math.abs(now);
                flag = true;
                continue;
            }
            
            answer += now * -2;
        }
        
        System.out.print(answer);
    }
}