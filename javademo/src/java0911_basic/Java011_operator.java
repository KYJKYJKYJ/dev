package java0911_basic;

public class Java011_operator {

	public static void main(String[] args) {
		//논리연산자 &&(and), ||(or), !(not)
		
		/* and는 둘 다 true 여야 true
		 * or는 하나만 true 여도 true
		 * not은 true, false의 반대
		 */
		
		int x = 3;
		int y = 6;
		int z = 3;
		
		boolean res;
		
		res = x > y && x == z; // f and t => f
		
		System.out.println(res);
	}

}
