package chapter03;

import java.util.Scanner;

public class p101 {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int N = input.nextInt();
		int K = input.nextInt();
		int count = 0;
		
		while(N != 1) {
			count++;
			// 나누어 떨어지면
			if(N % K == 0) {
				N /= K;
			} else {
				N--;
			}
		}
		
		System.out.println(count);
		
	}

}
