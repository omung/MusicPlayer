package com.musicplayer;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.iharder.dnd.FileDrop;

import org.cmc.music.common.ID3ReadException;
import org.cmc.music.util.Debug;
import org.farng.mp3.TagException;

public class CreatePlaylist extends JFrame {
	private	JPanel		topPanel;
	private JButton add;
	private JButton cancel;
	JTextField textfield;
public CreatePlaylist(){
	setTitle( "Musicplayer" );
	setSize( 250,200 );
	setBackground( Color.gray );
	// Create a panel to hold all other components
	topPanel = new JPanel();
	
	

		getContentPane().add( topPanel );
		textfield = new JTextField(20);
		add=new JButton("add");
		add.addActionListener(   new ActionListener() {
		     
	    	  public void actionPerformed( ActionEvent e )
	         {
	    		  String text = textfield.getText();
	    		  System.out.println(text);
	    		  Playlist.addplaylist(text);		
	    		  List.refreshplaylist();
	    		  List.refreshlist(text);
	    		  setVisible(false);
	    		  List.refreshjmenu();
	    		  List.acl=0;
	         }});
		cancel=new JButton("cancel");
		cancel.addActionListener(   new ActionListener() {
		     
	    	  public void actionPerformed( ActionEvent e )
	         {
	    		setVisible(false);
	    		List.refreshjmenu();
	    		List.refreshplaylist();
	    		List.tree.invalidate();
	    		List.tree.revalidate();
	    		List.tree.repaint();
	    		  List.acl= 0;
	         }});
		topPanel.add(textfield);
		topPanel.add(add);
		topPanel.add(cancel);
		
		   }
}
