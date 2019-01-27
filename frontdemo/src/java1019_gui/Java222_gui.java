package java1019_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Research extends JFrame implements ActionListener {
	JTextField nameTxt;
	JRadioButton manRad, womanRad;
	JComboBox<String> locBox;
	JButton saveBtn, openBtn;
	JTextArea multiLine;
	
	public Research() {
		//컴포넌트 생성
		nameTxt = new JTextField(10);
		
		manRad = new JRadioButton("남",true);
		womanRad = new JRadioButton("여");
		ButtonGroup bg = new ButtonGroup();
		bg.add(manRad); bg.add(womanRad);
		
		String[] city = new String[] { "seoul", "jeju", "pusan", "daejon" };
		locBox = new JComboBox<String>(city);
		
		saveBtn = new JButton("파일 저장");
		openBtn = new JButton("파일 열기");
		
		multiLine = new JTextArea(10, 20);
		
		//디자인
		JPanel pn1 = new JPanel();
		pn1.add(new JLabel("이름"));
		pn1.add(nameTxt);
		
		JPanel pn2 = new JPanel();
		pn2.add(new JLabel("성별"));
		pn2.add(manRad);
		pn2.add(womanRad);
	
		JPanel pn3 = new JPanel();
		pn3.add(new JLabel("지역"));
		pn3.add(locBox);
	
		JPanel pn4 = new JPanel();
		pn4.add(saveBtn);
		pn4.add(openBtn);
		
		JPanel top = new JPanel(new GridLayout(4, 1));
		top.add(pn1);
		top.add(pn2);
		top.add(pn3);
		top.add(pn4);
		
		setLayout(new GridLayout(2, 1));
		this.add(top);
		this.add(multiLine);
		
		setSize(300,300);
		setLocation(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 현재 이벤트가 발생된 컴포넌트 정보를 리턴하여 받아옴		
		if(obj == saveBtn) {
			saveMethod();
			initMethod();
		} else if (obj == openBtn) {
			openMethod();
		}		
	} // end actionPerformed()
	
	private void initMethod() {
		nameTxt.setText("");
		manRad.setSelected(true);
		locBox.setSelectedIndex(0);
		nameTxt.requestFocus();
	}
	
	private void saveMethod() {
		String name = nameTxt.getText();
		String gen = manRad.isSelected() ? "남" : "여";
		String loc = (String) locBox.getSelectedItem();
		
		JFileChooser save = new JFileChooser();
		int chk = save.showOpenDialog(this); // 저장 옵션
		if(chk == JFileChooser.CANCEL_OPTION) // 취소 했을 경우
			return;
		
		File file = save.getSelectedFile();
		FileWriter fw = null;
		try {
			fw = new FileWriter(file, true);
			fw.write(name + "/" + gen + "/" + loc + "\r\n");
			fw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // end saveMethod()
	
	private void openMethod() {
		JFileChooser open = new JFileChooser();
		int chk = open.showOpenDialog(this); // this는 지금 이 프레임을 나타냄 (프레임에서 출력하므로)
		if(chk == JFileChooser.CANCEL_OPTION)
			return;
		File file = open.getSelectedFile();
		Scanner sc = null;
		multiLine.setText("");
		try {
			sc = new Scanner(file);
			while(sc.hasNextLine()) {
				multiLine.append(sc.nextLine() + "\r\n");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	} // end openMethod()
} // end class

public class Java222_gui {

	public static void main(String[] args) {
		new Research();

	}

}
