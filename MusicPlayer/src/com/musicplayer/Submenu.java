package com.musicplayer;


	import java.awt.event.KeyEvent;

	import javax.swing.ButtonGroup;
	import javax.swing.Icon;
	import javax.swing.ImageIcon;
	import javax.swing.JFrame;
	import javax.swing.JMenu;
	import javax.swing.JMenuBar;
	import javax.swing.JMenuItem;
	import javax.swing.JRadioButtonMenuItem;

	public class Submenu  {

	  public static void main(final String args[]) {
	    JFrame frame = new JFrame("MenuSample Example");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JMenuBar menuBar = new JMenuBar();

	    // File Menu, F - Mnemonic
	    JMenu fileMenu = new JMenu("File");
	    fileMenu.setMnemonic(KeyEvent.VK_F);
	    menuBar.add(fileMenu);

	    // File->New, N - Mnemonic
	    JMenuItem newMenuItem = new JMenuItem("New", KeyEvent.VK_N);
	    fileMenu.add(newMenuItem);

	    // Edit->Options Submenu, O - Mnemonic, at.gif - Icon Image File
	    JMenu findOptionsMenu = new JMenu("Options");
	    Icon atIcon = new ImageIcon("at.gif");
	    findOptionsMenu.setIcon(atIcon);
	    findOptionsMenu.setMnemonic(KeyEvent.VK_O);
	    fileMenu.add(findOptionsMenu);

	    // ButtonGroup for radio buttons
	    ButtonGroup directionGroup = new ButtonGroup();

	    // Edit->Options->Forward, F - Mnemonic, in group
	    JRadioButtonMenuItem forwardMenuItem = new JRadioButtonMenuItem("Forward", true);
	    forwardMenuItem.setMnemonic(KeyEvent.VK_F);
	    findOptionsMenu.add(forwardMenuItem);
	    directionGroup.add(forwardMenuItem);

	    // Edit->Options->Backward, B - Mnemonic, in group
	    JRadioButtonMenuItem backwardMenuItem = new JRadioButtonMenuItem("Backward");
	    backwardMenuItem.setMnemonic(KeyEvent.VK_B);
	    findOptionsMenu.add(backwardMenuItem);
	    directionGroup.add(backwardMenuItem);
	    
	    
	    frame.setJMenuBar(menuBar);
	    frame.setSize(350, 250);
	    frame.setVisible(true);
	  }
	
}
