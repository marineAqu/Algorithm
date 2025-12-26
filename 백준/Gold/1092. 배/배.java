import java.util.*;
import java.io.*;

class Main {
    public static int lowerBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                // arr[mid] >= target인 경우
                right = mid;
            }
        }
    
        return left;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int limit[] = new int[n];
        int count[] = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) limit[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(limit);

        int m = Integer.parseInt(br.readLine());
        int box[] = new int[m];

        int idx;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++) {
            box[i] = Integer.parseInt(st.nextToken());
            idx = lowerBound(limit, box[i]);
            
            if(idx == n) {
                System.out.print(-1);
                System.exit(0);
            }
            else count[idx]++;
        }
        
        //작은 쪽에 count가 오버되면 큰 쪽에서 맡아줄 수 있음

        int rest = 0;
        int avg = m / n;
        
        if(m % n != 0) avg++;
        int answer = avg;
        
        for(int i=n-1; i>=0; i--){
            if(count[i] <= avg){ //여유가 생기는 경우
                rest += avg - count[i];
            }
            else { //담당해야 할 화물이 넘친 경우
                //다른 크레인으로 넘친 화물을 옮길 수 있는 경우
                if(count[i] - avg <= rest) rest -= count[i] - avg;
                //옮겨도 모자란 경우
                else {
                    avg++;
                    rest += n - 1 - i;
                    i++;
                    continue;
                }
            }
        }

        System.out.print(avg);
    }
}