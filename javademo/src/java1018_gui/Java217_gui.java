package java1018_gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Awt는 운영체제에 종속적이라 많이 사용하지 않음 (윈도우 상의 컴포넌트를 가져와서 사용함)
//Swing은 운영체제 독립적임 (자체적인 컴포넌트를 제공함)

//Frame -> Click -> WindowEvent -> WindowListener -> addWindowListener()
//Button -> Click -> ActionEvent -> ActionListener -> addActionListener()
//이 순서대로 흘러가니 이 순서로 정의하면 된다.

//TextField -> enter -> ActionEvent -> ActionListener -> addActionListener()

class TextInput extends Frame implements ActionListener {
	TextField inputTxt; // 한 라인만 입력가능
	Button clickBtn;
	TextArea multiTra; // 여러 라인을 입력가능
	Panel pn;
	
	public TextInput() {
		inputTxt = new TextField(20);
		clickBtn = new Button("input");
		pn = new Panel();
		pn.add(inputTxt);
		pn.add(clickBtn);
		multiTra = new TextArea(10, 10);
		multiTra.setEditable(false); // TextArea 편집 불가능
		
		this.add(BorderLayout.NORTH, pn);
		this.add(BorderLayout.CENTER, multiTra);
		//컴포넌트에 이벤트 리스너 연결
		clickBtn.addActionListener(this); // 자신의 객체를 가르키는 this
		inputTxt.addActionListener(this);
		
		setSize(300, 300);
		setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
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

public class Java217_gui {

	public static void main(String[] args) {
		new TextInput();

	}

}
