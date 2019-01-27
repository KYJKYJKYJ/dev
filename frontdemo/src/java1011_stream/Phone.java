package java1011_stream;

import java.io.Serializable;

/*
 * 직렬화
 * 1. 객체를 연속적인 데이터로 변환하는 것
 * 2. 객체의 멤버변수들의 값을 일렬로 나열하는 것
 * 3. 객체를 저장하기 위해서는 객체를 직렬화 해야함
 * 4. 객체를 저장한다는 것은 객체의 멤버변수의 값을 저장한다는 것
 * 5. 객체를 직렬화 하여 입출력하는 스트림
 * ObjectInputStream, ObjectOutputStream
 */

public class Phone implements Serializable {
	String name;
	transient int price; //직렬화에서 멤버변수를 제외 할때 사용하는 transient 
	
	public Phone(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String toString() {
		return name + " " + price;
 	}
}


