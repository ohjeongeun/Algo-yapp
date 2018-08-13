package day0811;

public class Fibo_recur {
    //출력 메인 함수
	public static void main(String[] args) {
		int n = 10; //수열의 길이
		for(int i=1; i<=n; i++) {
			System.out.print(fibo(i)+" ");	
		}
	}
	
    //피보나치 함수
	public static int fibo(int N) {
		if(N<2) {
			return N;
		}
		else {
			return (fibo(N-1) + fibo(N-2));
		}
	}
}