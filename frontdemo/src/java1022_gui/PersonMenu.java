package java1022_gui;

/*
PersonInfo에추가될.
파일 | 편집 | 보기
-----
새파일
열기
저장
------닫기
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PersonMenu extends JMenuBar{
	JMenu file, edit, view;
	
	JMenuItem fnew,fopen,fsave,fexit;
	JMenuItem fcopy,fcut,fpaste;
	JMenuItem vleft, vcenter,vright;
	
	public PersonMenu(){
		file= new JMenu("파일");
		edit= new JMenu("편집");
		view= new JMenu("보기");
		
		//swing에서는 한글폰트설정해야함.
		//.setFont(new Font("sansSerif",0,12));
				
		
		file.setFont(new Font("sansSerif",0,12));
		edit.setFont(new Font("sansSerif",0,12));
		view.setFont(new Font("sansSerif",0,12));
		
		//파일
		fnew = new JMenuItem("새파일");
		fopen = new JMenuItem("열기");
		fsave =new JMenuItem("저장");
		fexit = new JMenuItem("닫기");
		
		fnew.setFont(new Font("sansSerif",0,12));
		fnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,ActionEvent.ALT_MASK));//단축키
		fopen.setFont(new Font("sansSerif",0,12));
		fopen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,ActionEvent.CTRL_MASK));//단축키
		fsave.setFont(new Font("sansSerif",0,12));
		fsave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,ActionEvent.CTRL_MASK));//단축키
		fexit.setFont(new Font("sansSerif",0,12));		
		fexit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,ActionEvent.ALT_MASK));
				
		file.add(fnew);
		file.add(fopen);
		file.add(fsave);
		file.addSeparator();
		file.add(fexit);
		
		//편집		
		fcopy = new JMenuItem("복사");
		fcut = new JMenuItem("잘라내기");
		fpaste =new JMenuItem("붙여넣기");
				
		fcopy.setFont(new Font("sansSerif",0,12));
		fcut.setFont(new Font("sansSerif",0,12));
		fpaste.setFont(new Font("sansSerif",0,12));
				
		edit.add(fcopy);
		edit.add(fcut);
		edit.add(fpaste);		
		
		
		//보기		
		vleft = new JMenuItem("왼쪽정렬");
		vcenter = new JMenuItem("중앙정렬");
		vright =new JMenuItem("오른쪽정렬");
		
		vleft.setFont(new Font("sansSerif",0,12));
		vcenter.setFont(new Font("sansSerif",0,12));
		vright.setFont(new Font("sansSerif",0,12));
		
		view.add(vleft);
		view.add(vcenter);
		view.add(vright);		
		
		
		/////////////////////////////////////////////////////////////////////		
		//현재 class에 MenuBar에 추가함.
		add(file);
		add(edit);
		add(view);
		
	}	
	
}
