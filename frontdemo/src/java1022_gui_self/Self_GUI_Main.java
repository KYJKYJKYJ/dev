/*package java1022_gui_self;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Self_GUI_Main extends JFrame {
	JLabel nameL, sexL, telL, emailL;
	JTextField nameF, weightF, heightF, tel1F, tel2F, emailF;
	JRadioButton manR, womanR, alienR;
	DefaultComboBoxModel<String> telMmodel;
	JComboBox<String> telC;
	JButton registerB, deleteB, modifyB, clearB;
	DefaultTableModel tableModel;
	JTable table;	
	JScrollPane scroll;
	
	String[] telStr = { "010", "011", "016", "017", "018", "019" };
	String[] labelNames = { "이름", "성별", "연락처", "이메일", "키", "몸무게" }; //테이플 헤드
	
	public Self_GUI_Main() {
		nameL = new JLabel("성명");
		sexL = new JLabel("성별");
		telL = new JLabel("연락처");
		emailL = new JLabel("이메일");
		
		nameF = new JTextField(20);
		tel1F = new JTextField(4);
		tel2F = new JTextField(4);
		emailF = new JTextField(20);
		
		manR = new JRadioButton("남", true);
		womanR = new JRadioButton("여", false);
		alienR = new JRadioButton("에일리언", false);
		
		//버튼을 그룹화 해주는 버튼 그룹
		ButtonGroup group = new ButtonGroup();
		group.add(manR);
		group.add(womanR);
		group.add(alienR);
		
		//tableModel은 표를 만들고 추가,수정기능을 도와줌
		tableModel = new DefaultTableModel(labelNames, 50) {
			public boolean isCellEditable(int row, int col) {
				return false; // 셀 수정할 수 없도록 함
			}
		}; // inner class 오버라이딩, 셀을 건드릴 수 없도록
		
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		table.setRowHeight(20); // 라인의 높이
		table.getColumn
		
	}
	
	public static void main(String[] args) {
		new Self_GUI_Main();

	}

}
*/