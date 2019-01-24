package java1018_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

class MessageTest extends JFrame implements ActionListener {
	JButton btn;
	public MessageTest() {
		btn = new JButton("click");
		this.add(BorderLayout.CENTER, btn);
		
		btn.addActionListener(this);
		
		setSize(300, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				exit();
			}
		});
	}
	
	private void exit() {
		int chk = JOptionPane.showConfirmDialog(this, "정말로 종료하시겠습니까?", "종료", JOptionPane.YES_NO_OPTION);
		if(chk == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	} // end exit()

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "안녕하세요");
		
	}
}

public class Java221_gui {

	public static void main(String[] args) {
		new MessageTest();

	}// end main()

} // end class
