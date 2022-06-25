package D_notepad;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class mainfile implements ActionListener {

	/**
		 * 
		 */
	private static final long serialVersionUID = -3711794108139168714L;
	boolean wordWrapOn;
	protected JFrame frame;
	protected JTextArea t;
	protected JScrollPane s;
	protected JMenuBar m;
	protected JMenu m1, m2, m3, m4;
	protected JMenuItem New, save, open, exit, saveas;

	// menu item for format
	protected JMenuItem iWrap, ifontELEPHANT, iFontCSMS, iFontCooper, iFontsystem, iFontSize8, iFontSize12, iFontSize14,
			iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	protected JMenu menuFOnt, menuFontSize;

	// for color menu
	protected JMenuItem color1, color2, color3;

	// FOR EDIT MENU
	protected JMenuItem undo, redo;
	// classes for the functionality
	functionfile f = new functionfile(this);
	functionformat fmat = new functionformat(this);
	functioncolor fc = new functioncolor(this);
	functionedit fe = new functionedit(this);

	UndoManager um = new UndoManager();

	public static void main(String[] args) {
		new mainfile();
	}

	public mainfile() {

		createframe();
		createtextarea();

		createmenu();
		cretefilemenu();
		createeditmenu();
		createformatmenu();
		createcolormenu();

		fmat.selectedFOnt = "system";
		fmat.createFont(16);
		fmat.wordWrap();
		frame.setVisible(true);

	}

	private void createframe() {
		// TODO Auto-generated method stub

		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("download.jpg")));
		frame.setSize(1200, 1200);
		frame.setLocation(0, 120);
		frame.setFont(new Font("Arial",Font.PLAIN,16));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("D'Notepad");

	}

	private void createtextarea() {
		// TODO Auto-generated method stub
		t = new JTextArea();

		// using anonymous inner class to implement undo-able listener
		t.getDocument().addUndoableEditListener(new UndoableEditListener() {
			public void undoableEditHappened(UndoableEditEvent e) {
				um.addEdit(e.getEdit());
			}
		});

		s = new JScrollPane(t, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		s.setBorder(BorderFactory.createEmptyBorder());
		frame.add(s);
//	frame.add(t);
	}

	private void createmenu() {
		// TODO Auto-generated method stub
		m = new JMenuBar();
		frame.setJMenuBar(m);

		m1 = new JMenu("File");
		m.add(m1);

		m2 = new JMenu("Edit");
		m.add(m2);

		m3 = new JMenu("Format");
		m.add(m3);

		m4 = new JMenu("Color");
		m.add(m4);

	}

	private void cretefilemenu() {
		// TODO Auto-generated method stub
		New = new JMenuItem("New");
		New.addActionListener(this);
		New.setActionCommand("New");
		m1.add(New);

		open = new JMenuItem("Open");
		open.addActionListener(this);
		open.setActionCommand("open");
		m1.add(open);

		save = new JMenuItem("save");
		save.addActionListener(this);
		save.setActionCommand("save");
		m1.add(save);

		saveas = new JMenuItem("saveas");
		saveas.addActionListener(this);
		saveas.setActionCommand("saveas");
		m1.add(saveas);

		exit = new JMenuItem("Exit");
		exit.addActionListener(this);
		exit.setActionCommand("exit");
		m1.add(exit);
	}

	private void createformatmenu() {
		// TODO Auto-generated method stub

		iWrap = new JMenuItem("Word Wrap:off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap:off");
		m3.add(iWrap);

		menuFOnt = new JMenu("Font");
		m3.add(menuFOnt);

		menuFontSize = new JMenu("FOnt-Size");
		m3.add(menuFontSize);

		ifontELEPHANT = new JMenuItem("ELEPHANT");
		ifontELEPHANT.addActionListener(this);
		ifontELEPHANT.setActionCommand("ELEPHANT");
		menuFOnt.add(ifontELEPHANT);

		iFontCSMS = new JMenuItem("TIMES NEW ROMAN");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("TIMES NEW ROMAN");
		menuFOnt.add(iFontCSMS);
		
		
		iFontCooper = new JMenuItem("Cooper");
		iFontCooper.addActionListener(this);
		iFontCooper.setActionCommand("Cooper");
		menuFOnt.add(iFontCooper);
		
		iFontsystem = new JMenuItem("system");
		iFontsystem.addActionListener(this);
		iFontsystem.setActionCommand("system");
		menuFOnt.add(iFontsystem);
		

		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("8");
		menuFontSize.add(iFontSize8);

		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("12");
		menuFontSize.add(iFontSize12);

		iFontSize14 = new JMenuItem("14");
		iFontSize14.addActionListener(this);
		iFontSize14.setActionCommand("14");
		menuFontSize.add(iFontSize14);

		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("16");
		menuFontSize.add(iFontSize16);

		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("20");
		menuFontSize.add(iFontSize20);

		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("24");
		menuFontSize.add(iFontSize24);

		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("28");
		menuFontSize.add(iFontSize28);
	}

	private void createcolormenu() {
		// TODO Auto-generated method stub
		color1 = new JMenuItem("green");
		color1.addActionListener(this);
		color1.setActionCommand("green");
		m4.add(color1);

		color2 = new JMenuItem("Black");
		color2.addActionListener(this);
		color2.setActionCommand("Black");
		m4.add(color2);

		color3 = new JMenuItem("Blue");
		color3.addActionListener(this);
		color3.setActionCommand("Blue");
		m4.add(color3);
	}

	private void createeditmenu() {
		// TODO Auto-generated method stub
		undo = new JMenuItem("undo");
		undo.addActionListener(this);
		undo.setActionCommand("undo");
		m2.add(undo);

		redo = new JMenuItem("redo");
		redo.addActionListener(this);
		redo.setActionCommand("redo");
		m2.add(redo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();

		switch (command) {
		case "New":
			f.newFile();
			break;

		case "open":
			f.open();
			break;

		case "save":
			f.save();
			break;

		case "saveas":
			f.saveas();
			break;

		case "exit":
			f.exit();
			break;

		case "undo":
			fe.undo();
			break;

		case "redo":
			fe.redo();
			break;

		case "Word Wrap:off":
			fmat.wordWrap();
			break;

		case "8":
			fmat.createFont(8);
			break;

		case "12":
			fmat.createFont(12);
			break;

		case "14":
			fmat.createFont(14);
			break;

		case "16":
			fmat.createFont(16);
			break;

		case "20":
			fmat.createFont(20);
			break;

		case "24":
			fmat.createFont(24);
			break;

		case "28":
			fmat.createFont(28);
			break;

		case "ELEPHANT":
			fmat.setfont(command);
			break;

		case "TIMES NEW ROMAN":
			fmat.setfont(command);
			break;
			
		case "Cooper":
			fmat.setfont(command);
			break;
			
		case "system":
			fmat.setfont(command);
			break;

		case "green":
			fc.changecolor(command);
			break;
		case "Black":
			fc.changecolor(command);
			break;
		case "Blue":
			fc.changecolor(command);
			break;

		}
	}

}
