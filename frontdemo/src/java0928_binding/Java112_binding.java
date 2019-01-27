package java0928_binding;

public class Java112_binding {

	public static void process(HomeTv tv) {
		tv.turnOn();		
		if(tv instanceof LgTv2) { // 다운캐스팅 해야할때 instanceof 사용함
			LgTv2 lg = (LgTv2) tv;
			lg.call();
		} else if(tv instanceof SamsungTv2) {
			SamsungTv2 ss = (SamsungTv2) tv;
			ss.loc();
		}
	}
	
	//스프링에서는 결합도를 낮추기 위해 DI 사용.. **
	
	public static void main(String[] args) {
		LgTv2 lg = new LgTv2("LG");
		process(lg);
		
		SamsungTv2 ss = new SamsungTv2("SAMSUNG");
		process(ss);
		
		//객체들과 의존관계가 낮아짐

	}

}
