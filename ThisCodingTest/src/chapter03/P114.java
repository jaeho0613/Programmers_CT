package chapter03;

import java.util.Scanner;

public class P114 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		String time = "";

		for (int i = 0; i <= num; i++) {
			for (int j = 0; j < 60; j++) {
				for (int k = 0; k < 60; k++) {
					time = "" + i + j + k;
					if (time.contains("3")) {
						System.out.println(i + "시 " + j + "분 " + k + "초");
						count++;
					}
				}
			}
		}

		System.out.println(count);
	}

}
