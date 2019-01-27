package java1019_gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

class ButtonImg extends JFrame {
	JButton save, open;
	JTextField tf;
	
	public ButtonImg() {
		save = new JButton(new ImageIcon("src\\java1019_gui\\save.gif"));
		open = new JButton(new ImageIcon("src\\java1019_gui\\open.gif"));
		tf = new JTextField(10);
		
		//말풍선
		save.setToolTipText("저장");
		open.setToolTipText("열기");
									  //top, left, bottom, right	
		save.setBorder(new EmptyBorder(0, 10, 0, 10));
		tf.setBorder(new TitledBorder("기타"));
		//Font("글꼴", 스타일( 0 보통, 1 굵게, 2 기울기, 3 굵게+기울기 ), 크기);
		Font font = new Font("고딕체", 2, 20);
		tf.setFont(font);
			
		//RGB
		Color color = new Color(255, 0, 0); //Red, Green, Blue
		tf.setForeground(color);
		tf.setBackground(Color.BLACK);
		
		JPanel pn1 = new JPanel();
		pn1.add(save);
		pn1.add(open);
		
		setLayout(new GridLayout(2, 1));
		add(pn1);
		add(tf);
		
		setSize(400,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	} // end ButtonImg()
} // end ButtonImg

public class Java224_gui {

	public static void main(String[] args) {
		new ButtonImg();

	} // end main()

} // end class
