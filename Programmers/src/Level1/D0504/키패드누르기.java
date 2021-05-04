package Level1.D0504;

public class 키패드누르기 {

	public static void main(String[] args) {
		Solution_01 st = new Solution_01();

		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		System.out.println(st.solution(numbers, hand));
	}

}

class Solution_01 {
	public String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();
		int l_position = 10; // *
		int r_position = 12; // #

		for (int number : numbers) {
			// 왼쪽 손 번호들
			if (number == 1 || number == 4 || number == 7) {
				answer.append("L");
				l_position = number;
			}
			// 오른쪽 손 번호들
			else if (number == 3 || number == 6 || number == 9) {
				answer.append("R");
				r_position = number;
			}
			// 중간 번호들
			else {
				// 좌표 거리 구하기
				int l_length = getLength(l_position, number);
				int r_length = getLength(r_position, number);

				// 오른쪽이 가까우면
				if (l_length > r_length) {
					answer.append("R");
					r_position = number;
				}
				// 왼쪽이 가까우면
				else if (l_length < r_length) {
					answer.append("L");
					l_position = number;
				}
				// 거리가 같으면
				else {
					if (hand.equals("right")) {
						answer.append("R");
						r_position = number;
					} else {
						answer.append("L");
						l_position = number;
					}
				}

			}
		}

		return answer.toString();
	}

	public int getLength(int position, int number) {

		// 특수문자는 나오지 않으므로 0일 경우 11로 변경
		position = (position == 0) ? 11 : position;
		number = (number == 0) ? 11 : number;

		int x = (position - 1) / 3;
		int y = (position - 1) % 3;

		int centerX = number / 3;
		int centerY = 1;

		return Math.abs(x - centerX) + Math.abs(y - centerY);
	}
}
