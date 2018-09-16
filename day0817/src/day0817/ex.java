package day0817;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex {
    public static int D[];
    
    public static void main(String args[]) throws IOException {
        int num = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        D = new int[num+1];
        System.out.print(make(num));
    }

    public static int make(int num){
    	System.out.println("start");
        if(num == 1){
            return 0;
        }
        if(D[num]> 0){
            return D[num];
        }
        
        System.out.println("before "+D[num]);
        D[num] = make(num-1)+1 ;
        System.out.println("after "+D[num]);
        
        if(num%2==0){
            int result = make(num/2)+1;
            if(D[num] > result){
                D[num] = make(num/2)+1;
            }
        }
        if(num%3==0){
            int result = make(num/3)+1;
            if(D[num] > result) {
                D[num] = make(num/3)+1;
            }
        }

        return D[num];
    }


 }