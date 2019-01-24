package java1017_thread;

/*
 * 쓰레드 생명주기 (Life Cycle)
 * start() - 실행 준비 상태 (Runnable) - run() - Terminated - 대기상태 (Wating, Not Runnable)
 */

class LifeCycle extends Thread {
	public LifeCycle() {
		
	}
	
	@Override
	public void run() {
		System.out.println(getState());
		for(int i = 0; i <= 5; i++) {
			System.out.printf("%s i = %d\n", getName(), i);
			try {
				Thread.sleep(1000); // 1초  //Wating(Not Runnable) - 일시정지 상태
				//throws가 안뜨는 이유 : 오버라이딩 해야되는데 throws하면 오버라이딩이 아닌 새로운 메소드 선언이 되버림..
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}// end run()
} // end LifeCycle

public class Java208_thread {

	public static void main(String[] args) {
		LifeCycle cc = new LifeCycle();
		System.out.println(cc.getState());
		cc.start();
		
		try {
			//지정된 시간 동안 쓰레드가 실행되도록 한다
			//지정된 시간이 지나거나 종료가 되면 join()을 호출한 쓰레드로 다시 돌아와 실행을 계속 수행함
			cc.join(); // 수행 중인 쓰레드가 끝날 때 까지 join을 호출한 쓰레드 실행을 막음
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(cc.getState());
		System.out.println("main end");
	} // end main()

} // end class
