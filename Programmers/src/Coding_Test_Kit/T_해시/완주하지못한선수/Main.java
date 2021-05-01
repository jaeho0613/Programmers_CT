package Coding_Test_Kit.T_해시.완주하지못한선수;

import java.util.Arrays;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		String[] participant = { "leo", "kiki", "eden" };
		String[] completion = { "eden", "kiki" };

		System.out.println(st.solution(participant, completion));
	}
}

// �������� ���� ���� - �� Ǯ��
class Solution {
	public String solution(String[] participant, String[] completion) {

		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);

		int i = 0;

		while (i < completion.length) {
//			System.out.println(completion[i]);
//			System.out.println(participant[i]);
			if (!completion[i].equals(participant[i])) {
				answer = participant[i];
				break;
			} else {
				i++;
			}
		}

		if (answer.equals("")) {
			answer = participant[participant.length - 1];
		}

		return answer;
	}
}

// �������� ���� ���� - �ٸ���� Ǯ��
class Solution2 {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant) {
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		}

		for (String player : completion) {
			hm.put(player, hm.get(player) - 1);
		}

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;
	}
}
