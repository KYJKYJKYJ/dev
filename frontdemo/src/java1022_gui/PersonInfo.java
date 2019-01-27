package java1022_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class PersonInfo extends JFrame implements ActionListener, MouseListener {
	PersonMain main;
	PersonMenu menu;
	PersonToolbar toolbar;
	int crow = -1;
	
	public PersonInfo() {
		menu = new PersonMenu();
		main = new PersonMain();
		toolbar = new PersonToolbar();
		
		setJMenuBar(menu);		
		add(BorderLayout.NORTH, toolbar);
		add(BorderLayout.CENTER, main);
		
		this.setSize(520, 550);
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//버튼의 이벤트 리스너 연결
		main.registerB.addActionListener(this);
		main.modifyB.addActionListener(this);
		main.deleteB.addActionListener(this);
		main.clearB.addActionListener(this);
		
		main.registerB.addMouseListener(this);
		main.modifyB.addMouseListener(this);
		main.deleteB.addMouseListener(this);
		main.clearB.addMouseListener(this);
		main.table.addMouseListener(this);
		
	}// end PersonInfo()//////////////////////////

	public static void main(String[] args) {
		new PersonInfo();
	}// end main()////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		//JOptionPane.showMessageDialog(this, e.getActionCommand()); // 등록한 버튼 이름이 뜸
		 Object obj = e.getSource();
		 if(obj == main.registerB) {
			 setRegister();
		 } else if (obj == main.modifyB) {
			 setModify();
		 } else if (obj == main.clearB) {
			 allClear(); // 모든 컴포넌트 초기화
		 } else if (obj == main.deleteB) {
			 setRemove();
		 }
	} // end actionPerformed()

	private void setRegister() {
		if(crow > -1) {
			showMessage("이미 등록된 레코드 입니다.");
			 return;
		}
		
		String name = main.nameF.getText().trim();
		String sex = main.manR.isSelected() ? "남 " : "여";
		String tel1 = main.tel1F.getText().trim();
		String tel2 = main.tel2F.getText().trim();
		String tel3 = (String)main.telC.getSelectedItem();
		String email = main.emailF.getText().trim();
		
		for(int i = 0; i < main.table.getRowCount(); i++) {
			if(main.table.getValueAt(i, 0) == null) {
				main.table.setValueAt(Integer.toString(i+1), i, 0);
				main.table.setValueAt(name, i, 1);
				main.table.setValueAt(sex, i, 2);
				main.table.setValueAt(tel3 + "-" + tel1 + "-" + tel2, i, 3);
				main.table.setValueAt(email, i, 4);
				break;
			}
		}
		setClear();
	
	} // end setRegister()
	
	//입력 데이터 초기화
	private void setClear() {
		main.nameF.setText("");
		main.tel1F.setText("");
		main.tel2F.setText("");
		main.emailF.setText("");
		main.telC.setSelectedIndex(0);
		main.manR.setSelected(true);
		main.nameF.requestFocus();
	} // end setClear()
	
	private void setInputRecord() {
		// 더블클릭한 행의 번호를 가져온다.
		int row = main.table.getSelectedRow();
		
		if (main.table.getValueAt(row, 0) == null) {
			//JOptionPane.showMessageDialog(this, "입력되지 않은 값입니다.");
			showMessage("등록되지 않은 레코드입니다.");
			return;
		} 
		
		crow = row; // 나중에 수정 상태인지 확인하고 접근하기 위해서 사용함
		
		main.nameF.setText(main.table.getValueAt(row, 1).toString());
			
		String gend = main.table.getValueAt(row, 2).toString();
		if(gend.equals("여")) 
			main.womanR.setSelected(true);
		else 
			main.manR.setSelected(true);
		
		String[] tels = main.table.getValueAt(row, 3).toString().split("-");
		main.telC.setSelectedItem(tels[0]);
		main.tel1F.setText(tels[1]);
		main.tel2F.setText(tels[2]);
		
		main.emailF.setText(main.table.getValueAt(row, 4).toString());
	} // end setInputRecord()
	
	private void setModify() {
		//crow로 수정 상태인지 확인
		if(crow < 0) {
			showMessage("수정 상태가 아닙니다.");
			return;
		}
		
		String name = main.nameF.getText().trim();
		String sex = main.manR.isSelected() ? "남 " : "여";
		String tel1 = main.tel1F.getText().trim();
		String tel2 = main.tel2F.getText().trim();
		String tel3 = (String)main.telC.getSelectedItem();
		String email = main.emailF.getText().trim();
		
		main.table.setValueAt(Integer.toString(crow+1), crow, 0);
		main.table.setValueAt(name, crow, 1);
		main.table.setValueAt(sex, crow, 2);
		main.table.setValueAt(tel3 + "-" + tel1 + "-" + tel2, crow, 3);
		main.table.setValueAt(email, crow, 4);
		
		crow = -1;
		setClear();
	} // end setModify()
	
	private void setRemove() {
		int row = main.table.getSelectedRow();
		if(row < 0) {
			showMessage("삭제할 레코드를 선택하세요");
			return;
		}
		
		int chk = JOptionPane.showConfirmDialog(this, "정말로 삭제하시겠습니까?", "삭제", JOptionPane.YES_NO_OPTION);
		
		if(chk == JOptionPane.CANCEL_OPTION) {
			return;
		}
		
		main.tableModel.removeRow(row); // 아예 행을 버림		
		
		if(main.tableModel.getRowCount() < 50)
			main.tableModel.setRowCount(50); // 행을 없애버렸으니 다시 추가
		
		createNumber();
	} // end setRemove()
	
	private void createNumber() {
		for(int i = 0; i < main.table.getRowCount(); i++) {
			/*if(main.table.getValueAt(i, 0) != null) {
				main.table.setValueAt(Integer.toString(i+1), i, 0);
			} else
				return;*/
			
			if(main.table.getValueAt(i, 0) == null) {
				return;
			} 
			main.table.setValueAt(Integer.toString(i + 1), i, 0);
		}
	} // end createNumber()
	
	private void allClear() {
		setClear();
		main.tableModel.setRowCount(0); // 행 전체를 삭제
		main.tableModel.setRowCount(50); // 행 재생성
	} // end allClear()
	
	private void showMessage(String message) {
		JOptionPane.showMessageDialog(this, message);
	} // end showMessage()

	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == main.table && e.getClickCount() == 2) {
			setInputRecord();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == main.registerB)
			main.registerB.setText("REGISTER");
		else if(obj == main.modifyB)
			main.modifyB.setText("MODIFY");
		else if(obj == main.deleteB)
			main.deleteB.setText("DELETE");
		else if(obj == main.clearB)
			main.clearB.setText("CLEAR");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == main.registerB)
			main.registerB.setText("등록");
		else if(obj == main.modifyB)
			main.modifyB.setText("수정");
		else if(obj == main.deleteB)
			main.deleteB.setText("삭제");
		else if(obj == main.clearB)
			main.clearB.setText("초기화");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}// end class
