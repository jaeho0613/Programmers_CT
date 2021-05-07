package chapter03;

import java.util.Scanner;

public class p110 {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		int N = Integer.parseInt(sn.nextLine());
		String[] arr = sn.nextLine().split(" ");

		int x = 1;
		int y = 1;

		for (String st : arr) {

			switch (st) {
			case "R":
				if (y + 1 <= N) {
					y++;
				}
				break;
			case "L":
				if (y - 1 >= 1) {
					y--;
				}
				break;
			case "D":
				if (x + 1 <= N) {
					x++;
				}
				break;
			case "U":
				if (x - 1 >= 1) {
					x--;
				}
				break;
			}
			System.out.println("x : " + x + " y : " + y);
		}
	}
}
