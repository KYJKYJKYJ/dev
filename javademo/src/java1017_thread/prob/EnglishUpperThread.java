package java1017_thread.prob;

class EnglishUpperThread extends Thread {
	private String[] eustr;
	public EnglishUpperThread() { }
	public EnglishUpperThread(String[] eustr) {
		this.eustr = eustr;	
	}
	
	@Override
	synchronized public void run() {
		for(String eu : eustr) {
			System.out.print(eu + " ");
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
