package java1012_collection;

import java.util.Vector;

/*
 * 크기 묻는 것들
 * 배열 : length 키워드
 * 문자열 : length() 메소드
 * 컬렉션 : size() 메소드
 */

/*
 * 컬렉션 클래스를 선언하고 생성할 때 제네릭을 선언한다.
 * 제네릭 : 컬렉션 클래스에 저장된 객체를 가져 올 때 다운 캐스팅하는 작업을 생략할 수 있도록 제공하는 기능 (....?)
 * 
 * 
 * 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법 (제네릭 Generic)
 */
public class Java177_vector { // 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법 (제네릭 Generic)

	public static void main(String[] args) {
		Vector<String> v = new Vector<String>();
		v.add(new String("java"));
		v.add(new String("jsp"));
		v.add(new String("spring"));
		
		System.out.println("///일반 반복문///");
		for(int i = 0; i < v.size(); i++) {
			String data = v.get(i); //제네릭을 활용했기 때문에 다운캐스팅 입력 안해줘도 됨
			System.out.println(data);
		}
	
		System.out.println("///개선된 루프///");
		//for(데이터타입 변수 : 배열 or 컬렉션)
		for(String st : v) {
			System.out.println(st);
		}
		
		Vector<Number> v2 = new Vector<Number>();
		//Integer -> Number -> Object : up-casting
		v2.add(new Integer(10));
		
		//Float -> Number -> Object : up-casting
		v2.add(new Float(5.4f));
		
		//Double -> Number -> Object : up-casting
		v2.add(new Double(3.4));
		
		System.out.println();
		for(Number nb : v2) {
			if(nb instanceof Integer) {
				Integer it = (Integer) nb;
				System.out.println(it);
			} else if(nb instanceof Float) {
				Float fl = (Float) nb;
				System.out.println(fl);
			} else if(nb instanceof Double) {
				Double db = (Double) nb;
				System.out.println(db);
			}
		}
	} //end main

} //end class
