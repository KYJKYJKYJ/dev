package java1018_gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class UserSize extends Frame {
	Button btn;
	public UserSize() {
		btn = new Button("button");
		
		setLayout(null); // Frame 컨테이너의 Layout을 null로 초기화함
		btn.setLocation(50, 50); // setLayout을 사용하지 않고 위치와 크기를 지정
		btn.setSize(200, 150);
		
		//가로위치, 세로위치, 가로크기, 세로크기
		//btn.setBounds(50, 50, 200, 150);
		//한번에 정함
		
		this.add(btn);
		
		setSize(300, 300);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		
	} // end UserSize()
} // end UserSize

public class Java215_gui {

	public static void main(String[] args) {
		new UserSize();

	}// end main()

} // end class
