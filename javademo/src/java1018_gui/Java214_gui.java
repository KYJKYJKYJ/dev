package java1018_gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class FlowLayoutTest extends Frame {
	Button oneBtn, twoBtn, threeBtn;
	Panel pn;
	TextArea ta;
	
	public FlowLayoutTest() {
		oneBtn = new Button("one");
		twoBtn = new Button("two");
		threeBtn = new Button("three");
		
		pn = new Panel(); //Panel의 기본 레이아웃은 FlowLayout (add로 컴포넌트 연결시 왼쪽에서 오른쪽으로 add 순서대로 컴포넌트들을 연결함)
		//패널도 컨테이너지만 단독으로 출력이 불가능함. 패널은 컴포넌트들을 그룹으로 묶어주는 역할을 한다. (배열과 비슷한 느낌)
		
		pn.add(oneBtn);
		pn.add(twoBtn);
		pn.add(threeBtn);
		
		ta = new TextArea(10, 20);
		
		this.add(BorderLayout.NORTH, pn);
		this.add(BorderLayout.CENTER, ta);
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
}

public class Java214_gui {
	public static void main(String[] args) {
		new FlowLayoutTest();
	}
}
