package day0925;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ_10845 {
	
	static int N;
	static LinkedList<Integer> q;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		q = new LinkedList<>();
		
		String command;
		int in;
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			
			if(command.equals("push")) {
				in = Integer.parseInt(st.nextToken());
				q.add(in);
				
			}else if(command.equals("pop")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else{
					System.out.println(q.removeFirst());
				}
				
			}else if(command.equals("size")) {
				System.out.println(q.size());
				
			}else if(command.equals("empty")) {
				if(q.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				
			}else if(command.equals("front")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekFirst());
				}
				
			}else if(command.equals("back")) {
				if(q.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(q.peekLast());
				}
			}
			
		}
	}
}
