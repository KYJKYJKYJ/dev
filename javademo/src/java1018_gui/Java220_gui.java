package java1018_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

class EventTest extends JFrame implements ItemListener, ActionListener{
	JRadioButton topBtn, midBtn, botBtn;
	JTextArea ta;

	public EventTest() {
		topBtn = new JRadioButton("상", true);
		midBtn = new JRadioButton("중");
		botBtn = new JRadioButton("하");
		ta = new JTextArea(10, 10);

		// 라디오버튼을 그룹으로 묶어준다.
		ButtonGroup bg = new ButtonGroup();
		bg.add(topBtn);
		bg.add(midBtn);
		bg.add(botBtn);
		
		JPanel p1 = new JPanel();
		p1.add(topBtn);
		p1.add(midBtn);
		p1.add(botBtn);
		
		add(BorderLayout.NORTH, p1);
		add(BorderLayout.CENTER,ta);		
	    
		/*topBtn.addItemListener(this);
		midBtn.addItemListener(this);
		botBtn.addItemListener(this);*/

		topBtn.addActionListener(this);
		midBtn.addActionListener(this);
		botBtn.addActionListener(this);	
				
		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end EventTest( )


	@Override
	public void itemStateChanged(ItemEvent e) {	//원래 하나하나 관리하던걸 묶어서 한번에
		Object obj=e.getSource();
		if(obj==topBtn)
		ta.append(topBtn.getText());
		if(obj==midBtn)
		ta.append(midBtn.getText());
		if(obj==botBtn)
		ta.append(botBtn.getText());
	}//end itemStateChanged( )



	@Override
	public void actionPerformed(ActionEvent e) {
		ta.setText("");
		Object obj=e.getSource();
		if(obj==topBtn)
		ta.append(topBtn.getText());
		if(obj==midBtn)
		ta.append(midBtn.getText());
		if(obj==botBtn)
		ta.append(botBtn.getText());
		
	}
}// end EventTest

public class Java220_gui {

	public static void main(String[] args) {
     new EventTest();
	}// end main( )

}// end class
