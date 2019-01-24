package java1017_thread.prob;

class EnglishLowerThread extends Thread {
	private String[] elstr;
	public EnglishLowerThread() { }
	public EnglishLowerThread(String[] elstr) {
		this.elstr = elstr;
	}
	
	@Override
	synchronized public void run() {
		for(String el : elstr) {
			System.out.print(el + " ");
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
