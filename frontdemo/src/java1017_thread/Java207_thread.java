package java1017_thread;

class User2 implements Runnable { // (쓰레드를 만드는 또다른 방법인 implement Runnable) 멀티프로그래밍을 구현하는 방법 중 하나인 Runnable 인터페이스 구현
	public User2() {
		
	}

	@Override
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.printf("%s i = %d\n", Thread.currentThread().getName(), i);
		}
	}// end run()
} // end User2

public class Java207_thread {

	public static void main(String[] args) {
		User2 us = new User2();
		Thread th = new Thread(us);
		th.start();
		
		System.out.println("main thread");
		
		/*
		 * Thread에서 명심할 것 -
		 * 독립으로 처리가 되는 것인데 쓰레드 순서를 예상하지 말것.
		 */
		
	}

}
