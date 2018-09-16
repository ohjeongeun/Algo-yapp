package day0817;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_11726 {
	static int n;
	static int memo[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		memo = new int[n+1];
		
		for(int i=0; i<=n; i++) {
			if(i<=2) {
				memo[i]=i;
			}else {
				memo[i] = memo[i-2]+memo[i-1];
				//n크기가 커지면 출력범위가 넘어버려서 미리 나누기해줌. 출력때 안해주면 상관 없음
				memo[i] %= 10007;
			}
		}
		
		System.out.println(memo[n]);
	}
}
