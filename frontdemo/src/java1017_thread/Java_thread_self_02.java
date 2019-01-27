package java1017_thread;

// 1부터 10000까지 1씩 증가를 한다. 이를 3개의 쓰레드로 실행시켜 그 후 num 값을 출력하자

class Increment {
	int num = 0;
	synchronized public void increment() { num++; }
	// 이 부분을 동기화 하지 않을 경우는 1부터 10000까지의 갯수증가를 개별로 하는 꼴 그래서 30000이 아닌 다른 값이 출력된다.
	public int getNum() { return num; }
}

class IncThread implements Runnable {
	Increment inc;
	
	public IncThread(Increment inc) {
		this.inc = inc;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10000; i++) {
			inc.increment();
		}
	}
}

public class Java_thread_self_02 {

	public static void main(String[] args) {
		Increment inc = new Increment();
		IncThread ith1 = new IncThread(inc);
		IncThread ith2 = new IncThread(inc);
		IncThread ith3 = new IncThread(inc);
		
		Thread th1 = new Thread(ith1);
		Thread th2 = new Thread(ith2);
		Thread th3 = new Thread(ith3);
		
		th1.start();		
		th2.start();
		th3.start();
		
		try {
			th1.join();
			th2.join();
			th3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("1부터 10000까지 갯수 증가 : " + inc.getNum());
		
	}

}
