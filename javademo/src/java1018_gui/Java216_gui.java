package java1018_gui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GridLayoutTest extends Frame { // 테이블처럼 행과 열로 나누어 컴포넌트를 배치
	Button northBtn, centerBtn, southBtn, eastBtn, westBtn;
	
	public GridLayoutTest() {
		northBtn = new Button("North");
		centerBtn = new Button("Center");
		southBtn = new Button("South");
		eastBtn = new Button("East");
		westBtn = new Button("West");
		
		this.setLayout(new GridLayout(2, 3)); // 가로 줄 수, 세로 줄 수
		this.add(northBtn);
		this.add(centerBtn);
		this.add(southBtn);
		this.add(eastBtn);
		this.add(westBtn);
		
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	} // end GridLayoutTest()
} // end class

public class Java216_gui {

	public static void main(String[] args) {
		new GridLayoutTest();

	}

}
