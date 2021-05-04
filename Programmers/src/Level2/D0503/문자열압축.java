package Level2.D0503;

public class 문자열압축 {

	public static void main(String[] args) {
		Solution_01 st = new Solution_01();

		System.out.println(st.solution("aabbaccc"));

	}

}

class Solution_01 {
	public int solution(String s) {
		int min = s.length();
		int length = s.length() / 2;

		for (int i = 1; i <= length; i++) {
//			int compLength = Compression(s, i).length();
//			min = Math.min(min, compLength);
			Compression(s, i);
		}

		return min;
	}

	private String Compression(String s, int i) {
		String result = ""; // 리턴 문자열
		String pattern = s.substring(0,i); // 현재 패턴
		int count = 1;
		
		System.out.println("pattern : " + pattern);

		System.out.println("=================");
		for (int j = i + 1; j < s.length(); j += i) {
			String nowString = s.substring(j,j+i);
			System.out.println("i : " + i + " j :" + j);
			System.out.println("nowString : " + nowString);
			
			
			
		}
		System.out.println("=================");

		return null;
	}

}