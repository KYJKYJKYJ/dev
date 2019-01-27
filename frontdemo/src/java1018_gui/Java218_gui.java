package java1018_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class TextInput2 extends JFrame implements ActionListener {
	JTextField inputTxt; // 한 라인만 입력가능
	JButton clickBtn;
	JTextArea multiTra; // 여러 라인을 입력가능
	JPanel pn;
	
	public TextInput2() {
		inputTxt = new JTextField(20);
		clickBtn = new JButton("input");
		pn = new JPanel();
		pn.add(inputTxt);
		pn.add(clickBtn);
		multiTra = new JTextArea(10, 10);
		multiTra.setEditable(false); // TextArea 편집 불가능
		
		this.add(BorderLayout.NORTH, pn);
		this.add(BorderLayout.CENTER, multiTra);
		//컴포넌트에 이벤트 리스너 연결
		clickBtn.addActionListener(this); // 자신의 객체를 가르키는 this
		inputTxt.addActionListener(this);
		
		setSize(500, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // System.exit(0) 과 같은 역할을함 (스윙에서) // 시스템 종료		
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // 아무 이벤트 발생 안함
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // 화면에서 숨김
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // JFrame 자원을 메모리에서 파괴(제거)함  // 시스템 종료와 의미가 다름 !
	}

	@Override
	public void actionPerformed(ActionEvent arg0) { // 내부에서 처리가 됨
		String line = inputTxt.getText();
		//TextArea에 TextField에 입력된 문자열을 추가한다.
		multiTra.append(line + "\r\n");
		//TextField를 초기화한다.
		inputTxt.setText(""); // 줄 반환해주고 빈칸으로 다시 세팅
		//TextField로 포커스를 이동함
		inputTxt.requestFocus(); // 입력한 후에도 포커싱유지
	}
}

public class Java218_gui {
	public static void main(String[] args) {
		new TextInput2();
	}	
}
