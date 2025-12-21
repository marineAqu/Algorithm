import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int boss[];
	
	//시간초과: 경로압축을 하지 않음
	//경로압축을 하지 않으면 트리의 높이가 너무 높아져서 연산이 너무 오래 걸린다.
	
	static int findBoss(int a) {
		if(boss[a] == a) return a;
		//else return findBoss(boss[a]);
		else return boss[a] = findBoss(boss[a]);
	}
	
	static void union(int a, int b) {
		boss[findBoss(a)] = findBoss(b);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(st.nextToken()); //0~n까지 (=n+1개)
		int m = Integer.parseInt(st.nextToken()); //연산 수
		
		
		boss = new int[n+1];
		for(int i=0; i<=n; i++) boss[i] = i;
		int cal, a, b;
		
		//연산
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			cal = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			//합집합
			if(cal == 0) union(a, b);
			
			//확인 연산
			else {
				if(findBoss(a) == findBoss(b)) sb.append("YES\n");
				else sb.append("NO\n");
			}
		}
		
		System.out.print(sb);
	}

}
