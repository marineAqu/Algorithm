import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int info[][] = new int[n][2];

        StringTokenizer st;

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());

            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(info, (o1, o2) -> o1[0] - o2[0]);

        int answer = 0;
        int nowStart = info[0][0];
        int nowEnd = info[0][1];
        
        for(int i=1; i<n; i++){
            if(info[i][0] <= nowEnd){
                nowEnd = Math.max(nowEnd, info[i][1]);
            }

            else {
                answer += nowEnd - nowStart;
                nowStart = info[i][0];
                nowEnd = info[i][1];
            }
        }

        answer += nowEnd - nowStart;
        System.out.print(answer);
    }
}