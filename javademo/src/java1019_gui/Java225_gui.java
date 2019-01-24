package java1019_gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Java225_gui {
   
   public static void main(String[] args) {
      new MenuTest();
   }   //end main()

}   //end class

class MenuTest extends JFrame implements ActionListener{
   JMenu file, edit, align, help;
   JMenuItem fnew, open, save;
   JMenuItem copy, paste, cut;
   JMenuItem left, right, center;
   //JToolBar에 연결할 컴포넌트 선언
   JButton fnewBtn, openBtn, saveBtn;
   
   
   public MenuTest() {
      
	   //메뉴바를 생성한다.
      JMenuBar menubar = new JMenuBar();
      file = new JMenu("File");
      edit = new JMenu("Edit");
      align = new JMenu("Align");
      help = new JMenu("Help");
      
      //메뉴바에 메뉴를 연결한다.
      menubar.add(file);
      menubar.add(edit);
      menubar.add(align);
      menubar.add(help);
      
      //프레임에 메뉴바를 연결한다.
      setJMenuBar(menubar);
      
      fnew = new JMenuItem("New");
      open = new JMenuItem("Open");
      save = new JMenuItem("Save");
      
      //서브메뉴 특정문에 언더바를 표시한다.
      fnew.setMnemonic('N');
      open.setMnemonic('O');
      save.setMnemonic('S');
      
      //단축키
      fnew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_DOWN_MASK));
      open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
      save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
      
      //file메뉴에 서브메뉴 연결
      file.add(fnew);
      file.addSeparator();
      file.add(open);
      file.add(save);
      
      //edit메뉴에 사용할 서브메뉴 생성
      copy = new JMenuItem("Copy");
      paste = new JMenuItem("Paste");
      cut = new JMenuItem("Cut");
      
      //edit메뉴에 서브메뉴 연결
      edit.add(copy);
      edit.add(paste);
      edit.add(cut);
      //edit.add(align);
      //edit의 메뉴에 서브메뉴로 align 연결
      
      //align메뉴에 사용할 서브메뉴 생성
      left = new JMenuItem("Left");
      right = new JMenuItem("Right");
      center = new JMenuItem("Center");
      
      //align메뉴에 서브메뉴를 연결한다.
      align.add(left);
      align.add(right);
      align.add(center);
      
      //툴바 생성
      JToolBar toolBar = new JToolBar();
      fnewBtn = new JButton(new ImageIcon("src/java1019_gui/new.gif"));
      openBtn = new JButton(new ImageIcon("src/java1019_gui/open.gif"));
      saveBtn = new JButton(new ImageIcon("src/java1019_gui/save.gif"));
      
      //툴바에 버튼 연결
      toolBar.add(fnewBtn);
      toolBar.add(openBtn);
      toolBar.add(saveBtn);
      
      //프레임에 툴바 연결
      add(BorderLayout.NORTH, toolBar);
      
      
      //버튼과 메뉴에 ActionListener 연결
      fnew.addActionListener(this);
      open.addActionListener(this);
      save.addActionListener(this);
      fnewBtn.addActionListener(this);
      openBtn.addActionListener(this);
      saveBtn.addActionListener(this);
      
      setSize(500, 400);
      setVisible(true);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      
      
   }   //end MenuTest()

   @Override
   public void actionPerformed(ActionEvent e) {
	   Object obj = e.getSource();
	   if(obj == fnew || obj == fnewBtn) {
		   //JOptionPane.showMessageDialog(this, "new"); // 따로 창이 생성되면서 메세지 출력
		   JFrame subWin = new JFrame("새 창");
		   subWin.setSize(300, 200);
		   subWin.setVisible(true);
		   subWin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // 현재 메모리에서 객체를 없앰
		   
	   } else if(obj == open || obj == openBtn) {
		   JFileChooser openFile = new JFileChooser();
		   openFile.showOpenDialog(this); // this는 Frame
	   } else if(obj == save || obj == saveBtn) {
		   JFileChooser saveFile = new JFileChooser();
		   saveFile.showOpenDialog(this); // this는 Frame
	   }
	   
	
   } // end actionPerformed
}   //end MenuTest
