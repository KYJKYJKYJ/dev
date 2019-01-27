package java1018_gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
 * 레이아웃(layout) : 컨테이너에 컴포넌트를 연결할 수 있도록 화면배치를 설계해주는 기능이다.
 * 레이아웃관리자(Layout Manager) : 컨테이너에 컴포넌트를 적절하게 배치할 수 있도록 자동적으로
 *           일을 담당하고 있다.
 * 레이아웃 종류
 * 1 BorderLayout : North, South, East, West, Center 5개의 영역으로 이루어진 레이아웃이다.
 * 2 FlowLayout : 추가되는 컴포넌트에 따라 왼쪽에서 오른쪽으로 연결한다.
 * 3 GridLayout : 테이블처럼 행과 열로 나누어 컴포넌트를 배치한다.
 * 4 GridBagLayout : 컴포넌트의 크기를 다르게 해서 배치할때 사용한다.
 * 5 CardLayout : 여러 화면을 슬라이드처럼 바꿔가며 보여줄 수 있다.
 * 
 * 컨테이너별 기본레이아웃
 * 1 FlowLayout - Panel, Applet
 * 2 BorderLayout - Window, Frame, Dialog
 */

class LayoutTest extends Frame {
	Button northBtn, centerBtn, southBtn, eastBtn, westBtn;
	
	public LayoutTest() {
		northBtn = new Button("North");
		centerBtn = new Button("Center");
		southBtn = new Button("South");
		eastBtn = new Button("East");
		westBtn = new Button("West");
		
		//컨테이너에 컴포넌트 연결 :  add ()
		//컨테이너.add(컴포넌트)
		//this.add("North", northBtn);
		this.add(BorderLayout.NORTH, northBtn); // 위와 동일
		this.add(BorderLayout.CENTER, centerBtn);
		this.add(BorderLayout.SOUTH, southBtn);
		this.add(BorderLayout.EAST, eastBtn);
		this.add(BorderLayout.WEST, westBtn);
		
		setSize(500, 400);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	
} // end LayoutTest

public class Java213_gui {

	public static void main(String[] args) {
		new LayoutTest();

	} // end main()

} // end class
