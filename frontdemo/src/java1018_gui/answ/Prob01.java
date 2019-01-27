package java1018_gui.answ;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class MenuItem extends JFrame implements ActionListener {
	JComboBox<String> firstCom, secondCom;
	JTextArea ta;
	String[] foodMain = new String[] { "선택하세요", "한식", "중식", "일식" };
	String[][] foodSub = new String[][] { { "선택하세요", "불고기", "비빔밥", "삼계탕" },
			{ "선택하세요", "짬뽕", "짜장", "탕수육" }, { "선택하세요", "돈부리", "우동", "덮밥" } };

	boolean chk = false;

	public MenuItem() {
		firstCom = new JComboBox<String>(foodMain);
		secondCom = new JComboBox<String>();
		secondCom.addItem("선택하세요");

		JPanel jp = new JPanel();
		jp.add(new JLabel("MENU : "));
		jp.add(firstCom);
		jp.add(secondCom);

		ta = new JTextArea(10, 15);

		add(BorderLayout.NORTH, jp);
		add(BorderLayout.CENTER, ta);

		firstCom.addActionListener(this);
		secondCom.addActionListener(this);

		setSize(400, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end MenuItem

	@Override
	public void actionPerformed(ActionEvent e) {
		// ActionEvent가 발생된 객체를 반환한다.
		Object obj = e.getSource();

		if (obj == firstCom) {
			int index = firstCom.getSelectedIndex();
			if (index == 0) {
				
				for (int i = secondCom.getItemCount() - 1; i > 0; i--)
					secondCom.removeItemAt(i);
				
				menuMessage("한식,중식,일식 메뉴를 선택하세요.");

				return;
			}

			secondCom.setModel(new DefaultComboBoxModel<String>(
					foodSub[index - 1]));
			/*
			 * for(int i=secondCom.getItemCount()-1 ;i>=0; i--)
			 * secondCom.removeItemAt(i); for(int
			 * i=0;i<foodSub[index-1].length;i++)
			 * secondCom.addItem(foodSub[index-1][i]);
			 */

		} else if (obj == secondCom) {
			int index = secondCom.getSelectedIndex();
			if (index == 0) {
				menuMessage("음식메뉴를 선택하세요");
				return;
			}
			ta.setText(firstCom.getSelectedItem() + " : "
					+ secondCom.getSelectedItem());
		}
	}

	public void menuMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
}// end class

public class Prob01 {

	public static void main(String[] args) {
		MenuItem mt = new MenuItem();

	}// end main()

}// end class
