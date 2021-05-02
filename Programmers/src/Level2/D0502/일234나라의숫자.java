package Level2.D0502;

public class 일234나라의숫자 {

	public static void main(String[] args) {
		Solution_01 st = new Solution_01();
//		Solution_temp st = new Solution_temp();
		System.out.println(st.solution(21));

	}

}

class Solution_01 {
    public String solution(int n) {
        String answer = "";
        String[] temp = {"4","1","2"};
        
        while(n > 0) {
        	int remainder = n % 3;
        	n /= 3;
        	
        	if(remainder == 0) n--;
        	
        	answer = (temp[remainder]) + answer;
        }
        
        
        return answer.toString();
    }
}