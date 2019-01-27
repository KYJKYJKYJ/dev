package java1017_thread;

// 1부터 50 까지 나오는 쓰레드, 51 부터 100 까지 나오는 쓰레드를 이용하여 100까지의 합을 구하자.

class Sum {
	int num;
	public Sum() { num = 0; }
	public void addNum(int n) { num += n; }
	public int getNum() { return num; }
}

class AdderThread extends Sum implements Runnable {

	int start, end;
	
	public AdderThread(int s, int e) {
		this.start = s;
		this.end = e;
	}
	
	@Override
	public void run() {
		for(int i = start; i <= end; i++) {
			addNum(i);
		}
	}	
}

public class Java_thread_self_01 {

	public static void main(String[] args) {
		AdderThread adt1 = new AdderThread(1, 50);
		AdderThread adt2 = new AdderThread(51, 100);
		
		Thread th1 = new Thread(adt1);
		Thread th2 = new Thread(adt2);
		
		th1.start(); th2.start();
	
		try {
			th1.join();
			th2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1부터 100까지의 합 : " + (adt1.getNum() + adt2.getNum()));

	}

}
