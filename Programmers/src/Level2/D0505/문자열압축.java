package Level2.D0505;

public class 문자열압축 {

	public static void main(String[] args) {
		Solution_03 st = new Solution_03();
		String s = "aabbaccc";
		System.out.println(st.solution(s));

	}

}

class Solution_03 {
	public int solution(String s) {
		int answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			System.out.println("i : " + i);
		
			int pos = 0;
			int len = s.length();

			for (; pos + i <= s.length();) {
				String unit = s.substring(pos, pos + i);
				pos += i;

				int cnt = 0;
				for (; pos + i <= s.length();) {
					System.out.println("pos : " + pos);
					if (unit.equals(s.substring(pos, pos + i))) {
						++cnt;
						pos += i;
					} else {
						break;
					}
				}
				
				if(cnt > 0) {
					len -= i * cnt;
					
					if(cnt < 9) len += 1;
					else if (cnt < 99) len += 2;
					else if (cnt < 999) len += 3;
					else len += 4;
				}
			}
			
			answer = Math.min(answer, len);
		}

		return answer;
	}
}