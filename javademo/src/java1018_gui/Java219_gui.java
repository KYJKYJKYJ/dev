package java1018_gui;

import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

class MultiData extends JFrame  implements ItemListener {
	JRadioButton topBtn, midBtn, botBtn;
	JCheckBox javaChk, jspChk, springChk;
	JComboBox<String> locBox;
	JTextArea ta;
	//Panel의 경우 묶어주기만 하고 값을 가지는 것이 아니라서 생성자 안에서 생성해서 사용해도 됨
	
	public MultiData() {
		ta = new JTextArea(10, 10);
		
		topBtn = new JRadioButton("상", true); // 기본으로 선택되어져 있는 값
		midBtn = new JRadioButton("중");
		botBtn = new JRadioButton("하");
		//라디오 버튼을 그룹으로 묶어줌
		ButtonGroup bg = new ButtonGroup();
		bg.add(topBtn);
		bg.add(midBtn);
		bg.add(botBtn);
		
		JPanel pn1 = new JPanel();	
		pn1.add(topBtn);
		pn1.add(midBtn);
		pn1.add(botBtn);
		
		javaChk = new JCheckBox("java");
		jspChk = new JCheckBox("jsp");
		springChk = new JCheckBox("spring");
		JPanel pn2 = new JPanel();
		pn2.add(javaChk);
		pn2.add(jspChk);
		pn2.add(springChk);
		
		/*locBox = new JComboBox<String>();
		locBox.addItem("서울");
		locBox.addItem("제주");
		locBox.addItem("대전"); 실제로는 밑의 model에서 관리가 됨*/
		
		DefaultComboBoxModel<String> model =
				new DefaultComboBoxModel<String>();
		model.addElement("서울");
		model.addElement("제주");
		model.addElement("대전");
		locBox = new JComboBox<String>(model);
		
		JPanel pn3 = new JPanel(new GridLayout(3, 1)); // 2칸 나눠진거 1칸은 3칸으로 나눠져있음
		pn3.add(pn1);
		pn3.add(pn2);
		pn3.add(locBox);
		
		setLayout(new GridLayout(2, 1)); // 전체가 2칸으로 나눠짐
		this.add(pn3);
		this.add(ta);	
		
		//이벤트 리스너 연결
		topBtn.addItemListener(this);
		midBtn.addItemListener(this);
		botBtn.addItemListener(this);
		javaChk.addItemListener(this);
		jspChk.addItemListener(this);
		springChk.addItemListener(this);
		locBox.addItemListener(this);
		
		setSize(500, 500);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end MultiData()
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		//ta.setText("");
		//ta.append(((JRadioButton)e.getSource()).getText()); // 선택할 때 해제할 때 두번 write 이벤트 발생
		ta.setText("");
		if(topBtn.isSelected()) { // 라디오버튼은 여러개 선택 못하므로 else if
			ta.append(topBtn.getText());
		} else if(midBtn.isSelected()) {
			ta.append(midBtn.getText());
		} else if(botBtn.isSelected()) {
			ta.append(botBtn.getText());
		}
		ta.append("\r\n");
		
		if(javaChk.isSelected()) { // 체크박스는 여러개 선택되도 되기 때문에 if
			ta.append(javaChk.getText() + "\r\n");
		}
		if(jspChk.isSelected()) {
			ta.append(jspChk.getText() + "\r\n");
		}
		if(springChk.isSelected()) {
			ta.append(springChk.getText() + "\r\n");
		}
		
		// 선택한 항목의 인덱스를 리턴
		int index = locBox.getSelectedIndex();
		// 선택된 항목의 문자열 리턴
		String txt = (String) locBox.getSelectedItem();
		ta.append(index + " : " + txt);
	}
} // end MultiData

public class Java219_gui {

	public static void main(String[] args) {
		new MultiData();

	}

}
