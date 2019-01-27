package java1105_jdbc;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java1102_jdbc.EmpDAO;
import java1102_jdbc.EmpDTO;

public class Java241_Jdbc extends JFrame implements ActionListener {
	Java241_Jdbc_Main main;
	
	public Java241_Jdbc() {
		main = new Java241_Jdbc_Main();
		
		add(BorderLayout.CENTER, main);
		
		this.setSize(500, 500);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		main.searchB.addActionListener(this);
		main.searchTF.addActionListener(this); // 엔터키 기능하도록 설정
	}
	
	public static void main(String[] args) {
		new Java241_Jdbc();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String word = main.searchTF.getText().trim();
		main.tableModel.setRowCount(0); // 매번 테이블 행을 0으로 맞춰서 초기화
		
		EmpDAO dao = EmpDAO.getInstance();
		List<EmpDTO> aList = dao.searchMethod(word);
		
		if(aList.size() == 0) { // 리스트의 사이즈가 0이면 데이터가 없는 것
			JOptionPane.showMessageDialog(this, "검색데이터가 없습니다.");
			return;
		} // 데이터가 없을 경우 메세지 출력
		
		for (EmpDTO dto : aList) {
			   Object[] line = new Object[4]; // 각각의 데이터 타입이 다르므로 Object로 설정
		         line[0] = dto.getEmployee_id();
		         line[1] = dto.getFirst_name();
		         line[2] = dto.getSalary();
		         line[3] = dto.getHire_date();
		         main.tableModel.addRow(line); // 테이블에 행 추가 **

		}
		
		main.searchTF.setText(""); // 텍스트 필드 초기화
	}
}
