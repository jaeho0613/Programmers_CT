package 깊이너비;

public class 단어변환 {

	public static void main(String[] args) {
		Solution_03 st = new Solution_03();

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		System.out.println(st.solution(begin, target, words));
	}

}

class Solution_03 {

	int answer = 999;

	public int solution(String begin, String target, String[] words) {
		boolean isContainWord = false;
		for (String word : words) {
			if (target.equals(word)) {
				isContainWord = true;
			}
		}

		if (!isContainWord)
			return 0;

		boolean[] visited = new boolean[words.length];

		dfs(begin, target, words, visited, 0);

		return answer;

	}

	private void dfs(String begin, String target, String[] words, boolean[] visited, int node) {
		if (begin.equals(target)) {
			answer = (answer > node) ? node : answer;
			return;
		}

		for (int j = 0; j < words.length; j++) {
			if (CheckToStringDifference(begin, words[j]) && !visited[j]) {
				visited[j] = true;
				dfs(words[j], target, words, visited, node + 1);
				visited[j] = false;
			}
		}
	}

	/**
	 * 단어 비교 함수
	 * 
	 * @param currentString 현재 단어
	 * @param targetString  비교 될 단어
	 * @return 같은 단어가 2개 이상 존재하면 true 아니면 false
	 */
	private boolean CheckToStringDifference(String currentString, String targetString) {
		int isSameCount = 0;
		char[] currentCharArray = currentString.toCharArray();
		char[] targetCharArray = targetString.toCharArray();

		for (int i = 0; i < targetCharArray.length; i++) {
			if (currentCharArray[i] != targetCharArray[i]) {
				isSameCount++;
			}
		}

		return isSameCount == 1 ? true : false;
	}
}
