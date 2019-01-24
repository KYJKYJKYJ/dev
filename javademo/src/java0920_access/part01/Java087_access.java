package java0920_access.part01;

/*
 * package 패키지명;          package java.lang;
 * import 패키지명.클래스;      import  java.util.Random; 
 * import 패키지명.인터페이스;
 * 
 * class 클래스{              
 *   멤버변수;
 *   생성자;
 *   메소드;
 * }
 * 
 * package :
 * 1 비슷한 작업을 수행하는 클래스 및 인터페이스를 묶어줄때 사용한다.
 * 2 open API에서 제공하는 클래스 : 클래스 및 인터페이스 중복을 피하기 위해서 사용한다.
 *   domain : www.khmain.or.kr
 *   package :  kr.or.khmain
 *   
 * import : 외부 클래스 및 인터페이스 위치를 JVM에 알려주기 위해서 사용한다.   
 * 
 * 제어자(modifier)
 * 1 클래스, 변수, 메서드의 선언부에 사용되어 부가적인 의미를 부여한다.
 * 2 제어자는 크게 접근제어자와 그 외의 제어자로 구분한다.
 * 3 하나의 대상에 여러 개의 제어자를 조합해서 사용할 수 있으나, 
 *   접근제어자는 단  하나만 사용할 수 있다.
 *   접근제어자-public, protected, default, private
 *   그외제어자-static, final, abstract, synchronized... 
 * 
 * 접근제어자(access modifier)
 *   : 멤버 또는 클래스에 사용되어, 외부로부터의 접근을 제한한다.
 *   
 * 1 private : 같은 클래스에서만 접근이 가능하다.
 * 2 default : 같은 패키지에서만 접근이 가능하다.
 * 3 protected : 같은 패키지내에서, 그리고 다른 패키지의 자손 클래스에서 접근이 가능하다.
 * 4 public : 접근 제한이 없다.  
 *   
 *  접근제어자 사용
 *  class : default, public
 *  variable, method, constructor : private, default, protected, public   
 */

public class Java087_access {
	private int var_private = 1; // private는 선언된 같은 클래스 내에서만 사용가능
	int var_default = 2; // defalut는 같은 패키지 내에서 접근 가능
	protected int var_protected = 1; // protected는 같은 패키지 내, 다른 패키지의 자손 클래스에서만 접근 가능
	public int var_public = 1; // public은 모든 클래스에서 접근 가능
	
	public Java087_access() { }
	
	
}
