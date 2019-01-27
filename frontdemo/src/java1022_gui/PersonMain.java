package java1022_gui;

// Person Manager

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.*;

public class PersonMain extends JPanel {
	JLabel nameL, sexL, telL, emailL;
	JTextField nameF, tel1F, tel2F, emailF;
	JRadioButton manR, womanR;
	DefaultComboBoxModel<String> telMmodel;
	JComboBox<String> telC;
	JButton registerB, modifyB, deleteB, clearB;
	DefaultTableModel tableModel;
	JTable table;
	JScrollPane scroll;

	// 위치의 배열
	String[] telStr = { "010", "011", "016", "017", "018", "019" };

	// 테이블 헤드
	String[] cols = { "번호", "성명", "성별", "연락처", "이메일" };

	public PersonMain() {

		// JLabel
		nameL = new JLabel("성명");
		sexL = new JLabel("성별");
		telL = new JLabel("연락처");
		emailL = new JLabel("이메일");

		Font font = new Font("sansSerif", 0, 12);

		nameL.setFont(font);
		sexL.setFont(font);
		telL.setFont(font);
		emailL.setFont(font);

		// JTextField(디폴트사이즈)
		nameF = new JTextField(18);
		tel1F = new JTextField(4);
		tel2F = new JTextField(4);
		emailF = new JTextField(20);

		// JRadioButton("이름", true:디폴트); 이들은 그룹으로 묶어야 함.
		manR = new JRadioButton("남", true);
		womanR = new JRadioButton("여", false);
		ButtonGroup group = new ButtonGroup();
		group.add(manR);
		group.add(womanR);

		manR.setFont(font);
		womanR.setFont(font);

		//
		telMmodel = new DefaultComboBoxModel<String>(telStr);
		telC = new JComboBox<String>(telMmodel);
		telC.setPreferredSize(new Dimension(65, 21));

		//
		registerB = new JButton("등록");
		modifyB = new JButton("수정");
		deleteB = new JButton("삭제");
		clearB = new JButton("초기화");
		registerB.setFont(font);
		modifyB.setFont(font);
		deleteB.setFont(font);
		clearB.setFont(font);

		// 테이블
		tableModel = new DefaultTableModel(cols, 50) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		}; // 익명 inner class타입으로 오버라이딩. 셀을 건드리지못하도록
		table = new JTable(tableModel);
		scroll = new JScrollPane(table);
		table.setRowHeight(20); // 라인의 높이
		table.getColumnModel().getColumn(0).setPreferredWidth(10); // 라인의 너비(전체
																	// 250)
		table.getColumnModel().getColumn(1).setPreferredWidth(30);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		table.getTableHeader().setReorderingAllowed(false); // 컬럼이동불가능.
		table.setRowSelectionAllowed(false); //기본 true
	    table.setColumnSelectionAllowed(false); //기본 false

		// 전체적인 배치
		// 1.
		JPanel labelP = new JPanel(new GridLayout(3, 1));
		labelP.add(nameL);
		labelP.add(telL);
		labelP.add(emailL);
		// 2.
		JPanel nameP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nameP.add(nameF);
		// 3.
		JPanel sexP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		sexP.add(manR);
		sexP.add(womanR);
		// 4.
		JPanel sexPanel = new JPanel(new BorderLayout(5, 0));
		sexPanel.add("West", sexL);
		sexPanel.add("Center", sexP);
		// 5.
		JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel1.add(nameP);
		panel1.add(new JLabel("     "));// 사이에약간의공백.
		panel1.add(sexPanel);
		// 6.
		JPanel telP = new JPanel(new FlowLayout(FlowLayout.LEFT));
		telP.add(telC);
		// 7.
		JPanel tel1P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tel1P.add(tel1F);
		// 8.
		JPanel tel2P = new JPanel(new FlowLayout(FlowLayout.LEFT));
		tel2P.add(tel2F);
		// 9. 6,7,8을 하나로
		JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel2.add(telP);
		panel2.add(tel1P);
		panel2.add(new JLabel("-"));
		panel2.add(tel2P);
		// 10.
		JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panel3.add(emailF);
		// 11.person info부분 묶기
		JPanel top = new JPanel(new GridLayout(3, 1));
		top.add(panel1);
		top.add(panel2);
		top.add(panel3);
		//
		JPanel north = new JPanel(new BorderLayout());
		north.setBorder(new TitledBorder("개인정보 입력"));
		north.add("West", labelP);
		north.add("Center", top);
		//
		JPanel buttonP = new JPanel();// 자체가 FlowLayout임.
		buttonP.add(registerB);
		buttonP.add(modifyB);
		buttonP.add(deleteB);
		buttonP.add(clearB);
		//
		JPanel up = new JPanel(new BorderLayout(0, 5));
		up.add("Center", north);
		up.add("South", buttonP);
		//
		JPanel center = new JPanel(new BorderLayout(0, 5));
		center.add("Center", scroll);
		center.add("North", up);
		// 전체적인 여백
		setLayout(new BorderLayout());
		add("Center", center);
		add("East", new JLabel("  "));
		add("West", new JLabel("  "));
		add("South", new JLabel("  "));
		add("North", new JLabel("  "));

	}//end PersonMain()
	
	
}//end class








