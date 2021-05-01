package Level1;

public class 신규아이디추천 {

	public static void main(String[] args) {
		Solution_01 st = new Solution_01();
//		String new_id1 = "...!@BaT#*..y.abcdefghijklm";
//		String new_id1 = "z-+.^.";
		String new_id1 = "=.=";
//		String new_id1 = "123_.def";
//		String new_id1 = "abcdefghijklmn.p";
//		String new_id1 = "b=.=.=.=.=.=.=.=.=.=.=.=.=.=.=.x";
//		String new_id1 = "-_.~!@#$%^&*()=+[{]}:?,<>/._-";
//		String new_id1 = "!";
		System.out.println(st.solution(new_id1));
	}
}

class Solution_01 {

	private static String id = "";

	public String solution(String new_id) {

		id = new_id;

		ch01();
		System.out.println("1�ܰ� : " + id);

		ch02();
		System.out.println("2�ܰ� : " + id);

		ch03();
		System.out.println("3�ܰ� : " + id);

		ch04();
		System.out.println("4�ܰ� : " + id);

		ch05(new_id);
		System.out.println("5�ܰ� : " + id);

		ch06();
		System.out.println("6�ܰ� : " + id);

		ch07();
		System.out.println("7�ܰ� : " + id);

		return id;
	}

	// �빮�� ��ȯ
	private void ch01() {
		id = id.toLowerCase();
	}

	// Ư�� ���� ����
	// -_.~!@#$%^&*()=+[{]}:?,<>/
	private void ch02() {
		id = id.replace("~", "");
		id = id.replace("!", "");
		id = id.replace("@", "");
		id = id.replace("#", "");
		id = id.replace("$", "");
		id = id.replace("%", "");
		id = id.replace("^", "");
		id = id.replace("&", "");
		id = id.replace("*", "");
		id = id.replace("(", "");
		id = id.replace(")", "");
		id = id.replace("=", "");
		id = id.replace("+", "");
		id = id.replace("[", "");
		id = id.replace("{", "");
		id = id.replace("]", "");
		id = id.replace("}", "");
		id = id.replace(":", "");
		id = id.replace("?", "");
		id = id.replace(",", "");
		id = id.replace("<", "");
		id = id.replace(">", "");
		id = id.replace("/", "");
	}

	// ��ħǥ ���� ġȯ
	private void ch03() {
		while (id.contains("..")) {
			id = id.replace("..", ".");
		}
	}

	// ó��, �� �κп� .�ϰ�� ����
	private void ch04() {
		if (id.startsWith(".")) {
			id = id.substring(1, id.length());
		}

		if (id.endsWith(".")) {
			id = id.substring(0, id.length() - 1);
		}
	}

	// �� ���ڿ� üũ
	private void ch05(String new_id) {
		if (id.isEmpty()) {
			id += "a";
		}
	}

	// 16��, ��. Ȯ��
	private void ch06() {
		if (id.length() >= 16) {
			id = id.substring(0, 15);

			if (id.endsWith(".")) {
				id = id.substring(0, id.length() - 1);
			}
		}
	}

	// ���� 2�� ����
	private void ch07() {
		String endCh = String.valueOf(id.charAt(id.length() - 1));
		while (id.length() < 3) {
			id += endCh;
		}
	}
}
