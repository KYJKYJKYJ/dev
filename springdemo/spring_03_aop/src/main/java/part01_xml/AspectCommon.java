package part01_xml;

//공통로직만 구현해놓은 클래스 - 공통관점
public class AspectCommon {

	public AspectCommon() {

	}
	
	public void comm1() {
		System.out.println("before");
	}
	
	public void comm2() {
		System.out.println("after");
	}
	
	public void comm3(String name) {
		System.out.println("comm3 : " + name);
	}
	
	public void comm4(Exception ex) {
		if(ex!=null) {
			System.out.println(ex.toString());
		} else {
			System.out.println("wtf");
		}
		
	}
}
