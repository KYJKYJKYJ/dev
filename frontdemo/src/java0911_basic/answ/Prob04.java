package java0911_basic.answ;
/*
1  사과를 담는데 필요한 바구니의 수를 구하는 코드이다. 
2  만일 사과의 수가 123개이고 하나의 바구니에는 10개의 사과를 담을 수 있다면,
   13개의 바구니가 필요하다
3  [실행결과]
    필요한 바구니의 수 : 13
 */
public class Prob04 {

	public static void main(String[] args) {
		//여기에 작성하시오.
		int numOfApple=123; //총 사과수
		int sizeOfBucket=10; //하나의 바구니에 담을수 있는 사과수
		int numOfBucket=numOfApple%sizeOfBucket==0 ? 
				    	numOfApple/sizeOfBucket :
				    	numOfApple/sizeOfBucket+1;
		
		System.out.println("필요한 바구니의 수 : "+numOfBucket);

	}//end main()

}//end class
