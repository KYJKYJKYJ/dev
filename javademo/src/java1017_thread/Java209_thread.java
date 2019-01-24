package java1017_thread;

class PriorityTest extends Thread {
	@Override
	public void run() {
		for(int i = 0; i <= 5; i++) {
			System.out.printf("%s priority = %d i = %d\n", getName(), getPriority(), i);
		}
	} // end run()
} // end class

public class Java209_thread {

	public static void main(String[] args) {
		PriorityTest t1 = new PriorityTest();
		t1.setName("user"); // 쓰레드 이름을 지정함
		t1.start();
		
		PriorityTest t2 = new PriorityTest();
		t2.setPriority(Thread.MAX_PRIORITY); // 우선순위를 부여한다.
		/*
		 * 쓰레드의 우선순위는 1~10 까지 지정할 수 있음. // 클수록 실행시간이 늘어난다
		 * 기본값은 5
		 */
		t2.start();
		
		PriorityTest t3 = new PriorityTest();
		t3.setPriority(8);
		t3.start();
	} // end main()

} // end class
