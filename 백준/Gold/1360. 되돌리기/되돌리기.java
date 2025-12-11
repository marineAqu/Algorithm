import java.util.*;
import java.lang.*;
import java.io.*;

class Node{
    int time;
    String str;

    Node(int time, String str){
        this.time = time;
        this.str = str;
    }
}

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        String s;
        int back, now;
        String c;
        String find = "";

        Node arr[] = new Node[n+1];
        arr[0] = new Node(0, "");
        
        for(int i=1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            s = st.nextToken();

            if(s.equals("undo")){
                back = Integer.parseInt(st.nextToken());
                now = Integer.parseInt(st.nextToken());

                find = ""; //초기화 (0보다 작은 시간으로 undo)
                for(int r=i-1; r>=0; r--){
                    if(arr[r].time <= now - back - 1){
                        find = arr[r].str;
                        break;
                    }
                }
                arr[i] = new Node(now, find);
            }

            //type
            else{
                c = st.nextToken();
                now = Integer.parseInt(st.nextToken());
                arr[i] = new Node(now, arr[i-1].str + c);
            }
        }

        System.out.print(arr[n].str);
    }
}