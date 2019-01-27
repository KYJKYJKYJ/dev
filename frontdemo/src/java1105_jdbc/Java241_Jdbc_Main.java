package java1105_jdbc;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

class Java241_Jdbc_Main extends JPanel {
	JTextField searchTF;
	JButton searchB;
	JTable table;
	DefaultTableModel tableModel;
	JScrollPane scroll;
	
	public Java241_Jdbc_Main() {
	//테이블 헤드
	String[] cols = { "사원번호", "사원명", "연봉", "입사일" };
	
	tableModel = new DefaultTableModel(cols, 0) {
		public boolean isCellEditable(int row, int col) {
			return false;
		}
	};
	table = new JTable(tableModel);
	scroll = new JScrollPane(table);
	table.getColumnModel().getColumn(0).setPreferredWidth(30);
	table.getColumnModel().getColumn(1).setPreferredWidth(30);
	table.getColumnModel().getColumn(2).setPreferredWidth(30);
	table.getColumnModel().getColumn(3).setPreferredWidth(30);
	
	table.getTableHeader().setReorderingAllowed(false);
	
	searchTF = new JTextField(20);
	searchB = new JButton("검색");
	
	JPanel ButtonTFpanel = new JPanel(new FlowLayout());
	ButtonTFpanel.add(searchTF);
	ButtonTFpanel.add(searchB);
	
	JPanel allPanel = new JPanel(new BorderLayout());
	allPanel.add("North", ButtonTFpanel);
	allPanel.add("Center", scroll);
	
	setLayout(new BorderLayout());
	add("Center", allPanel);
	
	}
}

