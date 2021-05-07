package chapter03;

import java.util.Arrays;

public class p93 {

	public static void main(String[] args) {
		
		int N = 5;
		int M = 8;
		int K = 3;

		int[] arr = { 2, 4, 5, 4, 6 };

		Arrays.sort(arr);

		int a = arr[N - 1]; // 가장 큰 수
		int b = arr[N - 2]; // 두번째 큰 수
		int temp = 0; // 반복 횟수
		int count = 0; // 동일 숫자 더해진 횟수
		int sum = 0;
		
		while(temp < M) {
			temp++;
			
			if(count < 3) {
				count++;
				sum += a;
			} else {
				count = 0;
				sum += b;
			}
		}
		
		System.out.println(sum);
	}
}
