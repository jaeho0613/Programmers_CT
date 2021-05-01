package Coding_Test_Kit.T_해시.위장;

import java.util.HashMap;
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };

		System.out.println(st.solution(clothes));
	}
}

class Solution {
	public int solution(String[][] clothes) {

		HashMap<String, Integer> hm = new HashMap<String, Integer>();
		int answer = 1;

		for (int i = 0; i < clothes.length; i++) {
			hm.put(clothes[i][1], hm.getOrDefault(clothes[i][1], 1) + 1);
		}

		Iterator<String> keys = hm.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			System.out.println(String.format("Ű : %s, �� : %s", key, hm.get(key)));
		}

		for (int i : hm.values()) {
			answer *= i;
		}

		return answer - 1;
	}
}
