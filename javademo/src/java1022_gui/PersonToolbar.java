package java1022_gui;
/*
 * PersonInfo - Toolbar class
 * 새파일, 열기, 저장.
 * 툴바: 이미지들 사용함.
 */
import java.awt.*;
import javax.swing.border.*;
import javax.swing.*;


public class PersonToolbar extends JToolBar{
	JButton newB, openB, saveB, saveasB, helpB;
	JButton copyB, cutB, pasteB;
	JButton leftB, centerB, rightB;
	
	
	public PersonToolbar(){
		String str="src\\java1022_gui\\";
		newB = new JButton(new ImageIcon(str+"images\\new.gif"));
		openB = new JButton(new ImageIcon(str+"images\\open.gif"));
		saveB = new JButton(new ImageIcon(str+"images\\save.gif"));
		saveasB = new JButton(new ImageIcon(str+"images\\saveas.gif"));
		helpB = new JButton(new ImageIcon(str+"images\\help.gif"));
		//팁
		newB.setToolTipText("새파일");
		openB.setToolTipText("열기");
		saveB.setToolTipText("저장");
		saveasB.setToolTipText("다른 이름으로 저장");
		helpB.setToolTipText("도움말");
		//border 세팅(여백)
		newB.setBorder(new EmptyBorder(0,5,0,5));
		openB.setBorder(new EmptyBorder(0,5,0,5));
		saveB.setBorder(new EmptyBorder(0,5,0,5));
		saveasB.setBorder(new EmptyBorder(0,5,0,5));
		helpB.setBorder(new EmptyBorder(0,5,0,5));
		
		this.add(newB);
		this.add(openB);
		this.add(saveB);
		this.add(saveasB);
		this.add(helpB);
		this.addSeparator();
		
		
		//////////////////////////////////////////////////////////////
		copyB = new JButton(new ImageIcon(str+"images/copy.gif"));
		cutB = new JButton(new ImageIcon(str+"images/cut.gif"));
		pasteB = new JButton(new ImageIcon(str+"images/paste.gif"));
		
		//팁
		copyB.setToolTipText("복사");
		cutB.setToolTipText("잘라내기");
		pasteB.setToolTipText("붙여넣기");
		
		//border 세팅(여백)
		copyB.setBorder(new EmptyBorder(0,5,0,5));
		cutB.setBorder(new EmptyBorder(0,5,0,5));
		pasteB.setBorder(new EmptyBorder(0,5,0,5));
		
		
		this.add(copyB);
		this.add(cutB);
		this.add(pasteB);
		this.addSeparator();
		
		/////////////////////////////////////////////////////////////////
		//leftB, centerB, rightB;
		
		leftB = new JButton(new ImageIcon(str+"images/left.gif"));
		centerB = new JButton(new ImageIcon(str+"images/center.gif"));
		rightB = new JButton(new ImageIcon(str+"images/right.gif"));
		
		//팁
		leftB.setToolTipText("왼쪽정렬");
		centerB.setToolTipText("중앙정렬");
		rightB.setToolTipText("오른쪽정렬");
		
		//border 세팅(여백)
		leftB.setBorder(new EmptyBorder(0,5,0,5));
		centerB.setBorder(new EmptyBorder(0,5,0,5));
		rightB.setBorder(new EmptyBorder(0,5,0,5));		
		
		this.add(leftB);		
		this.add(centerB);
		this.add(rightB);		
	}
}
