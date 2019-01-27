package java1017_thread.prob;

class Producer extends Thread {	
	private VendingMachine vm;
	
	public Producer() { }
	public Producer(VendingMachine vm) {
		this.vm = vm;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.printf("%s : 음료수 No. %d 자판기에 넣기\n", Thread.currentThread().getName(), i);
			vm.putDrink("음료수 No. " + i);
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
}
