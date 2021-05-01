package Coding_Test_Kit.T_해시.전화번호목록;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		String[] phone_book = { "119", "97674223", "1195524421" };

		Solution st = new Solution();
		System.out.println(st.solution(phone_book));
	}
}

class Solution {
	public boolean solution(String[] phone_book) {
		
		Arrays.sort(phone_book);
		
		for (int i = 1; i < phone_book.length; i++) {
			if(phone_book[i].indexOf(phone_book[i-1]) == 0) {
				return false;
			}
		}
		
		return true;
	}
}