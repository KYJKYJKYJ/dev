package java1004_api;

/*
 * 1. 기본자료형을 클래스로 정의해 놓은 것을  Wrapper라 한다
 *   char	-> Character
 *   byte	-> Byte
 *   short	-> Short
 *   int	-> Integer
 *   long 	-> Long
 *   float 	-> Float
 *   double	-> Double
 *   boolean -> Boolean
 *
 * 2. 메모리에 저장된 값을 다른 자료형으로 변환해주는 메소드를 제공하기 위해서
 *   Wrapper클래스를 제공한다.
 * 
 * 3. auto boxing과 auto unboxing은 jdk5.0에서 추가된 기능이다.
 *   auto boxing => 스택 -> 힙영역에 복사
 *   auto unboxing => 힙 -> 스택영역에 복사    
 */
 

public class Java142_Wrapper {

	public static void main(String[] args) {
		String data = "1234";
		
		//String -> Integer
		Integer it = new Integer(data);
		
		//Integer -> int
		int num = it.intValue();
		System.out.println(num);

		//Integer -> double
		double num2 = it.doubleValue();
		System.out.println(num2);
		
		//Integer -> long
		long nn = it.longValue();
		System.out.println("nn = " + nn);
		
		//String -> Float
		Float ft = new Float(data);
		System.out.println("ft = " + ft);
		
		//Float -> int
		int num1 = ft.intValue();
		System.out.println("num1 = " + num1);
		
		//Float -> double
		double da = ft.doubleValue();
		System.out.println("da = " + da);
		
		int x = 10; //stack
		//Integer ig = new Integer(x); //heap 영역으로 복사
		Integer ig = x; // 위와 동일 (auto-boxing)
		System.out.println("ig = " + ig);
		
		//int y = ig.intValue();
		int y = ig;
		System.out.println("y = " + y);
		
		double z = ig; //auto-unboxing (heap -> stack)
		System.out.println("z = " + z);
		
		//나중에 DB로 넘어가면 데이터가 넘어가는 과정은 전부다 String이므로.. 여기서 변환하는거.. 익히기..
	}

}
