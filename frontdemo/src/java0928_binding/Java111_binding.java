package java0928_binding;

public class Java111_binding {

	public static void display(double x, double y) {
		System.out.println(x+y);
	}
	
	public static void processLg(LgTv lg) {
		lg.turnOn();
	}
	
	public static void processSamsung(SamsungTv ss) {
		ss.turnOn();
	}
	
	public static void main(String[] args) {
		display(4.5, 6.3);
		display(10, 20); //묵시적 형변환
		
		LgTv lg = new LgTv("LG");
		processLg(lg); //하나의 객체, 하나의 클래스 끼리만 작동할 때 결합도(객체들의 의존관계)가 높다라고 함
		
		SamsungTv ss = new SamsungTv("SAMSUNG");
		processSamsung(ss); //하나의 객체, 하나의 클래스 끼리만 작동할 때 결합도(객체들의 의존관계)가 높다라고 함
		
		//결합도가 높으면 유지보수가 힘듬, 확장성이 낮음
		//인터페이스를 이용하여 낮출 수 있음.
	}

}
