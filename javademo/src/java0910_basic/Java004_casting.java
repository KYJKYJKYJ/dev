package java0910_basic;

public class Java004_casting {
	public static void main(String[] args) {
		int num = 3;
		double data = 4.5;
		
		int jumsu = num;
		
		long ko = (long)4; // 묵시적 형변환 : 작은 데이터 타입을 큰 데이터 타입으로 변환할 때
		System.out.println(ko);
		
		int jumsu2 = (int)data; // 명시적 형변환 : 큰 데이터 타입을 작은 데이터 타입으로 변환할 때
		System.out.println(jumsu2);
		
		byte small = (byte)130; 
		// 자료형마다 정해진 크기가 있으므로 (값의 범위가 정해져 있으므로)형변환을 시켜줄 때 주의해야함
		// 오버플로우, 언더플로우 발생
		System.out.println(small);
		
		char alpa='a'; // 작은 따옴표로 묶어서 한글자씩
		System.out.println(alpa);
		
		alpa = 97; // 97은 유니코드 값 a
		// 유니코드 : 다국어 언어를 표현하기 위해 만들어진 코드 (컴퓨터는 문자를 저장하지 못하므로 코드 값으로 변환해서 저장함)
		System.out.println(alpa);
		
		byte adata = 3;
		short sdata = 4;
		long ndata = 5l;
		float fdata = 4.3f;
		boolean bdata = true;
		
		/*
			1. 변수의 데이터 타입과 값의 데이터 타입이 일치해야함
			2. 변수와 값의 데이터 타입이 일치가 안될 때는 형변환
			3. int 타입의 값을 byte, short에 대입할 때는 형변환이 필요치 않음
		*/
	}
}
