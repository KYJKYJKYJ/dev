package java1017_thread.prob;

class Consumer extends Thread {
	private VendingMachine vm;

	public Consumer() { }
	public Consumer(VendingMachine vm) {
		this.vm = vm;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + " : " + vm.getDrink() + "꺼내먹음");
		}
	}
}
