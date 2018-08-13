package day0811;

import java.util.Scanner;

public class BOJ_2579_2 {
    static int[] list;
    static int[][] result;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        list = new int[n+1];
        result = new int[n+1][2];
        for (int i = 1; i <= n; i++) {
            list[i] = sc.nextInt();
 
        }
        result[1][0] = result[1][1] = list[1];
        for (int i = 2; i <= n; i++) {
            result[i][0] = result[i - 1][1] + list[i];
            result[i][1] = Math.max(result[i - 2][0], result[i - 2][1]) + list[i];
            
            //System.out.println(result[i][0]+ " "+ result[i][1]);
        }
 
        System.out.println(Math.max(result[n][0], result[n][1]));
    }


}
