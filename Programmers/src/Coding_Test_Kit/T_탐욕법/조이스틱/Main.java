package Coding_Test_Kit.T_탐욕법.조이스틱;

public class Main {

	public static void main(String[] args) {
		Solution st = new Solution();
//		String name1 = "JEROEN";
		String name2 = "JAZ";
//		System.out.println(st.solution(name1));
		System.out.println(st.solution(name2));
	}

}

// �ڷ� �ذ� X
class Solution {
	public static int solution(String name) {

		int answer = 0;

		StringBuilder nameBuilder = new StringBuilder(name);// name

		StringBuilder aBuilder = new StringBuilder("");// A���ڿ�

		// A���ڿ� ����
		for (int i = 0, loop = name.length(); i < loop; i++)
			aBuilder.append('A');

		int start = 0;// ���ڿ��� A�� Ž���ϱ� ���� �ε���

		while (true) {

			int left = start;
			int right = start;

			// A�� �ƴ� ������ ��,
			if (nameBuilder.charAt(start) != 'A') {
				System.out.println(getMin(nameBuilder.charAt(start)));
				answer += getMin(nameBuilder.charAt(start));// ��,�Ʒ��� �� ���� �̵��� ã�´�.
				nameBuilder.setCharAt(start, 'A');// name�� ���ڸ� A�� �ٲ��ش�.
			}

			// name�� ��� ���ڰ� A�� �ٲ��� �� �����Ѵ�.
			if (aBuilder.toString().equals(nameBuilder.toString()))
				break;

			// �̵� Ƚ��
			int move = 0;

			while (true) {

				left--;
				right++;
				move++;

				// ������ ������ �Ѿ�� ������ ������ �������
				if (left < 0)
					left = nameBuilder.length() - 1;

				// �������� ������ �Ѿ�� ���� ������ �������
				if (right == nameBuilder.length())
					right = 0;

				// ���� ��Ұ� A�� �ƴ϶��
				if (nameBuilder.charAt(right) != 'A') {

					answer += move;// ��� ���� �̵� Ƚ�� �߰�
					start = right;// ���� Ž�� �ε����� ����
					break;
				}

				// ���� ��Ұ� A�� �ƴ϶��
				if (nameBuilder.charAt(left) != 'A') {

					answer += move;
					start = left;
					break;
				}
			}
		}

		return answer;
	}

	// ��,�Ʒ� �̵� �ּڰ�
	public static int getMin(char ch) {

		return Math.abs(ch - 'A') < Math.abs('Z' - ch) + 1 ? Math.abs(ch - 'A') : Math.abs('Z' - ch) + 1;
	}
}