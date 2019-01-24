package java1017_thread.prob;

import java.util.LinkedList;

class VendingMachine {
	LinkedList<String> can = new LinkedList<String>();
	synchronized public String getDrink() {
		try {
			while(can.isEmpty())
				wait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return can.poll().toString();
	}
	
	synchronized public void putDrink(String drink) {
		notify();
		can.offer(drink);
	}
}
