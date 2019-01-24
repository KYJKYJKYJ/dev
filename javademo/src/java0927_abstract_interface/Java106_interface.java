package java0927_abstract_interface;

import java.io.Serializable;

interface SampleA {
	void prn();
}// end SampleA

interface SampleB extends SampleA, Serializable {// 다중상속,사용
	void call();
}

class Animal {
	void play() {
		System.out.println("animal");
	}
}// end Animal

//extends ~~~~~~~implements~~~~~~~~~~
class Life extends Animal implements SampleA, Serializable {

	@Override
	public void prn() {
		System.out.println("prn");
	}
}//end Life

class Life2 extends Animal implements SampleB{
	@Override
	public void prn() {
		System.out.println("prn");
	}
	
	@Override
	public void call() {
		System.out.println("call");
	}
	
	
}

public class Java106_interface {

	public static void main(String[] args) {
		Life ee=new Life();
		ee.prn();
		ee.play();

	}//end main()

}
