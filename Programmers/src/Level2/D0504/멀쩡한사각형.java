package Level2.D0504;

import java.math.BigInteger;

public class 멀쩡한사각형 {

	public static void main(String[] args) {
		Solution_03 st = new Solution_03();
		
		System.out.println(st.solution(5, 6));

	}

}

class Solution_03 {
    public long solution(int w, int h) {
    	int gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).intValue();
        return ((long) w * (long) h) - ((((long) w / gcd) + ((long) h / gcd) - 1) * gcd);
    }
}
