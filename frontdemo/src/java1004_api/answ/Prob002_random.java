package java1004_api.answ;

/*
 * [UserPrime 클래스 정의]   
 * 클래스명 : UserUnique
 * + UserUnique()
 * + makeArray() : int[] 
 * + primeNumber(array : int[] ) : void
 * 
 * [문제]
 * 2~20 사이의 난수 10개를 발생시켜 배열에 저장한 후에 리턴하는 
 * makeArray() 메서드와 배열에서 소수를 구하여 출력하는 primeNumber() 메서드를 각각 구현하시오.
 * [출력결과]
<< 발생된 난수 >>
*  15 7  4  4  8  7  2  11  17  5 
<< 소수 숫자 >>
*  7 7 2 11 17 5
*  */

public class Prob002_random {

	public static void main(String[] args) {
		UserPrime uu=new UserPrime();
		int[] data=uu.makeArray();		
		System.out.println("<< 발생된 난수 >>");
		for(int arr : data)
			System.out.printf("%4d",arr);
		System.out.println("\n<< 소수 숫자 >>");
		uu.primeNumber(data);
	}// end main( )

}// end class
