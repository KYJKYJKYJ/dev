package java1017_thread.prob;

class KoreanThread extends Thread {
	private String[] kstr;
	public KoreanThread() { }
	public KoreanThread(String[] kstr) {
		this.kstr = kstr;
	}
	
	@Override
	synchronized public void run() {
		for(String kr : kstr) {
			System.out.print(kr + " ");
			try {
				sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println();
	}
}