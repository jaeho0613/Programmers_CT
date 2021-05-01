package Coding_Test_Kit.T_깊이너비.단어변환;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
//		String[] words = { "cog", "log", "lot", "dog", "dot", "hot" };

		System.out.println(st.solution(begin, target, words));
	}
}

class Solution {

	int answer = 0;
	boolean[] isVisited;

	public int solution(String begin, String target, String[] words) {
		answer = 999;
		isVisited = new boolean[words.length];
		List<String> wordList = Arrays.asList(words);

		if (!wordList.contains(target))
			return 0;

		dfs(begin, target, 0, words);

		return answer;
	}

	private void dfs(String begin, String target, int count, String[] words) {
		if (begin.equals(target)) {
			answer = (answer > count) ? count : answer;
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (!isVisited[i] && isConvert(begin, words[i])) {
				isVisited[i] = true;
				dfs(words[i], target, count + 1, words);
				isVisited[i] = false;
			}
		}
	}

	// �ܾ� üũ
	public boolean isConvert(String s1, String s2) {

		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) != s2.charAt(i)) {
				count++;
			}
		}
		return count == 1 ? true : false;
	}
}
