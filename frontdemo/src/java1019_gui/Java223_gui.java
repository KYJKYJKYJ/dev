package java1019_gui;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

class ResearchTwo extends JFrame implements ActionListener, MouseListener {
	JTextField nameTxt;
	JRadioButton manRad, womanRad;
	JComboBox<String> locBox;
	JButton regBtn, saveBtn, openBtn;
	JTable table;
	// table에서 사용되는 데이터를 관리해주는 객체이다.
	DefaultTableModel model;

	public ResearchTwo() {
		nameTxt = new JTextField(10);

		manRad = new JRadioButton("남", true);
		womanRad = new JRadioButton("여");
		ButtonGroup bg = new ButtonGroup();
		bg.add(manRad);
		bg.add(womanRad);

		String[] city = new String[] { "seoul", "jeju", "pusan", "daejon" };
		locBox = new JComboBox<String>(city);

		regBtn = new JButton("정보등록");
		saveBtn = new JButton("파일저장");
		openBtn = new JButton("파일열기"); // 버튼을 누르면 Action 발생 [리스너 필요]

		JPanel jp1 = new JPanel();
		jp1.add(new JLabel("이름"));
		jp1.add(nameTxt);

		JPanel jp2 = new JPanel();
		jp2.add(new JLabel("성별"));
		jp2.add(manRad);
		jp2.add(womanRad);

		JPanel jp3 = new JPanel();
		jp3.add(new JLabel("지역"));
		jp3.add(locBox);

		JPanel jp4 = new JPanel();
		jp4.add(regBtn);
		jp4.add(saveBtn);
		jp4.add(openBtn);

		JPanel top = new JPanel(new GridLayout(4, 1));
		top.add(jp1);
		top.add(jp2);
		top.add(jp3);
		top.add(jp4);

		// 테이블의 컬럼명을 배열에 저장한다.
		String[] columnNames = { "이름", "성별", "지역" };
		// 테이블의 데이터를 관리해줄 model을 생성한다.
		// 생성자를 호출할때 컬럼명, 행의 갯수를 넘겨준다.
		model = new DefaultTableModel(columnNames, 0);
		table = new JTable(model);
		// 테이블의 사이즈를 고정시킨다.
		table.setAutoResizeMode(0);

		JTableHeader header = table.getTableHeader();
		// 테이블의 컬럼명을 고정시킨다.
		header.setReorderingAllowed(false);

		// 컬럼모델을 리턴한다.
		TableColumnModel columnModel = header.getColumnModel();

		// 컬럼별로 크기를 설정한다.
		columnModel.getColumn(0).setPreferredWidth(100);
		columnModel.getColumn(1).setPreferredWidth(50);
		columnModel.getColumn(2).setPreferredWidth(150);

		// 테이블 행의 높이를 설정한다.
		table.setRowHeight(25);

		// 테이블 편집 불가
		table.setEnabled(false);

		// JFrame의 Layout을 GridLayout 2행 1열로 변경한다.
		setLayout(new GridLayout(2, 1));

		// JFrame에 컴포넌트를 연결한다.
		add(top);
		add(new JScrollPane(table)); // 테이블은 헤더 부분과 바디 부분이 나눠 지는데 이게 없으면 헤더가 안보여서 제목이 안보임

		// 이벤트 리스너 등록
		regBtn.addActionListener(this);
		saveBtn.addActionListener(this);
		openBtn.addActionListener(this);
		regBtn.addMouseListener(this);
		saveBtn.addMouseListener(this);
		openBtn.addMouseListener(this);

		setSize(300, 300);
		setLocation(400, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}// end ResearchTwo()

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource(); // 현재 이벤트가 발생된 컴포넌트 정보 리턴
		if(obj == regBtn) {
			regMethod();
			init();
		} else if(obj == saveBtn) {
			saveMethod();
		} else if(obj == openBtn) {
			openMethod();
		}
		
	} // end actionPerformed()

	private void regMethod() {
		String[] line = new String[3];
		line[0] = nameTxt.getText(); //이름
		line[1] = manRad.isSelected() ? "남" : "여"; // 성별
		line[2] = (String) locBox.getSelectedItem(); // 위치
		model.addRow(line);
	}// end regMethod()
	
	private void openMethod() {
		JFileChooser open = new JFileChooser();
		int chk = open.showOpenDialog(this);
		if(chk == JFileChooser.CANCEL_OPTION)
			return;
		File file = open.getSelectedFile();
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			model.setRowCount(0); // 초기화 작업
			while(sc.hasNextLine()) {
				String[] str = sc.nextLine().split("/");
				model.addRow(str);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}// end openMethod()
	
	private void saveMethod() {
		JFileChooser save = new JFileChooser();
		int chk = save.showOpenDialog(this);
		if(chk == JFileChooser.CANCEL_OPTION)
			return;
		File file = save.getSelectedFile();
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
			for(int i = 0; i < table.getRowCount(); i++) {
				String name = (String) table.getValueAt(i, 0);
				String gen = (String) table.getValueAt(i, 1);
				String loc = (String) table.getValueAt(i, 2); // model.getValueAt 도 가능하다
				fw.write(name + "/" + gen + "/" + loc + "\r\n");
			}
			fw.flush();
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}// end saveMethod()
	
	private void init() {
		nameTxt.setText("");
		manRad.setSelected(true);
		locBox.setSelectedIndex(0);
		nameTxt.requestFocus();
	}// end init()

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == regBtn)
			regBtn.setText("REGISTER");
		else if(obj == saveBtn)
			saveBtn.setText("SAVE");
		else if(obj == openBtn)
			openBtn.setText("OPEN");
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj == regBtn)
			regBtn.setText("정보등록");
		else if(obj == saveBtn)
			saveBtn.setText("파일저장");
		else if(obj == openBtn)
			openBtn.setText("파일열기");
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}// end ResearchTwo

public class Java223_gui {

	public static void main(String[] args) {
		new ResearchTwo();
	}// end main()
}// end class
