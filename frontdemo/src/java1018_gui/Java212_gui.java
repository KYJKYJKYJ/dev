package java1018_gui;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Win2 extends Frame {
	public Win2() {
		setSize(300, 400);
		setVisible(true); // 기본적으로 false가 되어 있어서 화면에 보이지 않는다.
		
		/*Exit exit = new Exit();
		this.addWindowListener(exit);*/
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	} // end Win2()
	
	class Exit extends WindowAdapter { // 윈도우 리스너를 상속받아 구현해 놓은 클래스 WindowAdapter // 리스너들을 상속받아 구현한 클래스를 Adapter라고 한다.
		@Override
		public void windowClosing(WindowEvent e) {
			System.exit(0);
		}
	}
} // end Win2 

public class Java212_gui {

	public static void main(String[] args) {
		Win2 win2 = new Win2(); // 객체 생성을 안하면 출력이 안되니 주의..
	}

}
