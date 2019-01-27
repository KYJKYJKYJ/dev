package java1018_gui;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/*
 * 컴퓨터와 사용자 인터페이스
 * 1 CUI(Character User Interface) : 문자대화방식 - DOS, Linux
 * 2 GUI(Graphics User Interface) : 그림대화방식-WINDOW
 * 
 * 자바에서 GUI을 구현할 수 있도록 AWT, Swing을 제공한다.
 * 
 * Component(컴포넌트)
 * 1 비주얼 컴포넌트 : 자기 자신위에 다른 컴포넌트 연결할 수 없는 컴포넌트이다.
 * 2 컨테이너 :자기 자신위에 다른 컴포넌트 연결할 수 있는 컴포넌트이다.
 * 3 메뉴 컴포넌트 : 메뉴에 관련된 컴포넌트이다.
 * 
 * Event(이벤트) : 컴포넌트에서 키보드로 입력하고, 클릭하고 하는 행동을
 *      컴포넌트에 사건이 발생된 것인데 이를 이벤트라 한다.
 * 
 * eventListener(이벤트리스너) : 컴포넌트에서 이벤트가 발생되면 이를 
 *    해결해야 하는데 해결할 메소드를 정의해놓은 인터페이스다.
 * 
 * Frame - 컨테이너     			WindowEvent 	WindowListener  	addWindowListener() - 컴포넌트에 이벤트를 연결 시킬 때 사용 (add)
 * Button - 비주얼 컴포넌트   		ActionEvent 	ActionListener  	addActionListener()
 * Checkbox - 비주얼 컴포넌트 	ItemEvent   	ItemListener    	addItemListener()
 * 
 */

class Win extends Frame {
	public Win() {
		//윈도우 창의 크기를 가로 300, 세로 400 픽셀 단위
		setSize(300, 400);
		setVisible(true); // 기본적으로 false가 되어 있어서 화면에 보이지 않는다.
		
		Exit exit = new Exit(); // 객체 생성 1
		this.addWindowListener(exit); // add리스너 호출 2, 객체대입 3   순서를 지키면 된다.
	} // end Win()
	
	class Exit implements WindowListener {

		@Override
		public void windowClosing(WindowEvent e) {
			// 시스템 종료 (닫기버튼 활성화)
			System.exit(0);	
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		
	} // end Exit()
	
} // end Win

public class Java211_gui {

	public static void main(String[] args) {
		Win win = new Win(); // 그냥 new Win(); 으로 사용 가능 (실질적인 접근이 필요치 않기 때문)
		

	}

}
