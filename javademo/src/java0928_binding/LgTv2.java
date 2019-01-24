package java0928_binding;

public class LgTv2 extends HomeTv {
	public LgTv2() {
		
	}
	
	public LgTv2(String maker) {
		this.maker = maker;
	}
	
	public void call() {
		System.out.println("lg call");
	}

}
