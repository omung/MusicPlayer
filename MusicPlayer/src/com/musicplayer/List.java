package com.musicplayer;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultTreeModel;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.TimerTask;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import net.iharder.dnd.FileDrop;

import org.cmc.music.common.ID3ReadException;
import org.cmc.music.util.Debug;





import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import com.musicplayer.OpenPlaylist.MyTimerActionListener2;


public class List extends JFrame{
static	int omg=0;
	static int acl= 0;
	static int k; 
	static String songtoadd;
	static JProgressBar pbar;
	int o1=1;
	static int seeked=0;
	int o2=1;
	int o3=1;
	static boolean playing=false;
	static Boolean rpttemp=false;
	int o4=1;
	int o5=1;
	static int stopsong=1;
	static int row;
	int col;
	JPanel pbarpanel;
	static Timer timer;
	static Timer timer2;
    static int progressBarVal;
	static float inc=0;
	static float dec;
	static float pval;
	static float omg1=0;
	static float tm=0;
	static Boolean rpt=false;
	static Boolean shfl=false;
	static Menu control;
	MenuItem play1;
	static Menu plrc1;
	MenuItem gotocurr1;
	MenuItem nxt1;
	MenuItem prv1;
	MenuItem incvol1;
	MenuItem decvol1;
	static Boolean seeking=false;
	CheckboxMenuItem shuffle1;
	CheckboxMenuItem repeat1;
	static Boolean stopped=false; 
	static int rep;
	static Boolean cols[]=Jdbc.getColumns();
static ArrayList recent=new ArrayList();
	JSlider slider;
	    JLabel label;
	JPopupMenu popup;
	static JTable table;
	static  DefaultTableModel model;
	 static ListSelectionModel selectionModel;
static String rowdata[][];
	static String actvplaylist="Library";
	 private boolean mouseDragging = false;
	    private int[] dragSourceIndex;
static java.util.List songstoadd=new ArrayList();
	static int j=0;	
	private	JPanel	topPanel;
	public	JPanel	mainPanel;
	  private JPanel      audiocontrols;
	private JPanel btnpanel;
	 public static JTree tree;
	private	JPanel	subPanel_lib;
	private	JPanel	subPanel;
	static	JList	listbox;
	static String node;
	private	JList	listbox2;
	JButton shuffle;
	static float startpos=0;
	static DefaultTreeModel treeModel;
	static JPopupMenu jmenu;
	  JPopupMenu jmenulist;
//	static DefaultMutableTreeNode Playlists;
static String selectednode;
	JMenuItem m1,m2;
	static JMenu jmenulist1;
	JMenu jmenulist2;
	static JPopupMenu jmenulist3;
	static JCheckBoxMenuItem m31;
	static JCheckBoxMenuItem m32;
	static JCheckBoxMenuItem m33;
	static JCheckBoxMenuItem m34;
	static 	JCheckBoxMenuItem m35;
	static JCheckBoxMenuItem m36;
	MenuItem test;
	static JLabel clock1;
	static JLabel clock2;
JPanel panel2;
static int isplaying=0;
static int rowhold=0;








	
	
	
	
	//-----------------------------------------
	
	
	 String title=List.value;

	    int i=0;
	    MenuBar mbar;
	    Menu menu,submenu;

	    JPopupMenu jmenu2;

	    JMenuItem m21;
	    JMenuItem m22,m23,m24,m25,m26;
	    MenuItem menu21,menu22,menu23,menu24,menu25,menu26;
	//------------------------------------------
	
	
	public static File file;
	 JButton delete;
	static Boolean dragged=false;
	static String value;
	 JButton add;
	InputStream inputStream = null;  
	  OutputStream outputStream = null;  
	  static DefaultListModel model2 ;
	  
JFrame frame=new JFrame(); 
	public List()
	{	
	setTitle( "List of all songs" );
	setSize( 1360, 650);
	setBackground( Color.gray );
	  addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
	       Stop.stop();
	       Jdbc.updateColumns();
	       Jdbc.updaterecentlyplayed();
	    	  System.exit(0);
	      }
	    });
	mainPanel=new JPanel();
	mainPanel.setLayout(new BorderLayout());

	topPanel = new JPanel();
	subPanel = new JPanel();
	subPanel_lib = new JPanel();
	mainPanel.add(topPanel,BorderLayout.CENTER);
	topPanel.setLayout( new BorderLayout());
	subPanel_lib.setLayout(new BorderLayout());
	audiocontrols = new JPanel();
	panel2=new JPanel();
	panel2.setBackground(Color.GREEN);
	panel2.setLayout(new BorderLayout());
	audiocontrols.setBackground(Color.BLACK);
	mainPanel.add(panel2,BorderLayout.NORTH);
	panel2.add(audiocontrols,BorderLayout.NORTH);
btnpanel=new JPanel();
btnpanel.setLayout(new GridLayout());
	subPanel.setLayout( new BorderLayout() );
	subPanel_lib.setBackground(Color.BLACK);
	subPanel.setSize(136,650);
	getContentPane().add(mainPanel);
	
	
	 model2 = new DefaultListModel();
	ArrayList list2=Jdbc.jdbc();
	 listbox = new JList(model2);
	 for(int i=0;i<list2.size();i++)
	 {
	 model2.addElement(list2.get(i));
	}
	listbox.revalidate();
	listbox.repaint();
	listbox.setSize(400, 500);

	
	listbox.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	topPanel.add( subPanel,BorderLayout.WEST);
	subPanel.setBackground(Color.black);
	topPanel.add( subPanel_lib,BorderLayout.CENTER);
	pbarpanel=new JPanel();
	pbarpanel.setLayout(new FlowLayout());
	subPanel.setVisible(true);
	     	subPanel_lib.setVisible(true);
	     	//--------------------------
	     	
	     	
	     	
	     	
	     	
	     	
	     	
	     	 JButton play = new JButton("play");
             play.setBounds(20, 50, 20, 25);

               play.addActionListener(
                  new ActionListener() {
                     public void actionPerformed( ActionEvent e )
                     {  
                     	                      Stop.stop();
                     	                      isplaying= 1;
                     	                      row= rowhold;
                        System.out.println("length:"+recent.size());
                    	 System.out.println(recent.size()+"...................."+rpt);                 	
                    	 if(value==null){
                    			value=table.getValueAt(0,0).toString();
                    			System.out.println("]]]]]]]]]]]]]]]]"+value);
                    			 selectionModel.addSelectionInterval(0, 0);
                    	 }                   	
	System.out.println(dec);
                    timer= new Timer(1000, new MyTimerActionListener());
	  System.out.println("int timer");
                    	 Abc a=new Abc();
                         a.play();
                    	 refreshcontrols();
                   doLayout();
                   table.requestFocusInWindow(); 
                     }
                     });
                JButton pause  = new JButton("pause");
                pause.setBounds(100, 50, 80, 25);
                pause.addActionListener(
                          new ActionListener() {
                         
                              public void actionPerformed( ActionEvent e )
                             {
                            
                         
                if(i%2==0){
                    Abc.pause();
                    timer.stop();
                    i++;}
                else{Abc.resume();
                timer.start();
                i++;
                table.requestFocusInWindow(); 
                }  }
                              
                          }
                          
                       );
                JButton stop = new JButton("stop");
                stop.setBounds(180, 50, 80, 25);
                stop.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e ){  
                            rpt=false;
                          rpttemp=true;
                         stopped=true;
                                System.out.println("stop");
                                System.out.println(Play.titleid3);
            Stop.stop();
            table.requestFocusInWindow(); 
                             }
                          }
                       );
                
               
                JButton forward = new JButton("forward");
                forward.setBounds(60, 80, 80, 25);
                forward.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             { if(!rpt){ Stop.stop();
                             stopped=true;
                            System.out.println("stopped"+row);  
if(shfl){    	 
	String sh[][]= null;
if(node!=null){
	 
if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
else{
sh= Playlist.getSongs(actvplaylist);
}	}	
else{
sh= Jdbc.jdbc2(); 
}ArrayList sh2= new ArrayList();
for(int z=0; z<sh.length; z++)
{
sh2.add(sh[z]);
}

row = 0 + (int)(Math.random()*sh.length);
System.out.println("rooooooooowwwwwwww In shuffle"+row);
value=table.getModel().getValueAt(row+1, 0).toString(); 
selectionModel.setSelectionInterval(row+1,row+1);
Stop.stop();
Abc a=new Abc();
a.play();
row=row+1;
table.requestFocusInWindow(); }
else{
//     	       col = table.getSelectedColumn();  
     	      
  //   	       row = table.getSelectedRow();  
     	        System.out.println(model.getRowCount());
     	       if(row+1>=model.getRowCount()){row=-1;
     	       
     	       }
     	      table.getModel().getValueAt(row+1, 0); 
     	   
//     	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                             System.out.println("in forward"+title);
//                                 String s=Fetchpath.nextSong(title);
     	    System.out.println(row);
     	      if(row+1>model.getRowCount()){System.out.println("mnop");}
     	     selectionModel.setSelectionInterval(row+1,row+1);  
     	      List.value= (String) table.getModel().getValueAt(row+1, 0);
     	     title=List.value;
     	  //  col = table.getSelectedColumn();  
   	      
  	      // row = table.getSelectedRow();  
     	      Abc a=new Abc();
                System.out.println(Thread.currentThread().getName());
        a.play();
        row= row+1;
        refreshcontrols();
        table.requestFocusInWindow(); 
}   
                             }
                          }}
                       );
                JButton rewind = new JButton("rewind");
                rewind.setBounds(140, 80, 80, 25);
                rewind.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             { 
                            if(!rpt){	 Stop.stop();
                            stopped=true;
                            	 if(shfl){    	  String sh[][]= null;
                           	  if(node!=null){
                             	 
	 	      if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
	 	      else{
	 	    	 sh= Playlist.getSongs(actvplaylist);
	 	      }	}	
	 	     else{
	 	    	sh= Jdbc.jdbc2(); 
	 	     }ArrayList sh2= new ArrayList();
	 	        	for(int z=0; z<sh.length; z++)
	 	        	{
	 	        	sh2.add(sh[z]);
	 	        	}
	 	        	
	 	        	row = 0 + (int)(Math.random()*sh.length);
	 	        	System.out.println("rooooooooowwwwwwww In shuffle"+row);
	 	        	value=table.getModel().getValueAt(row+1, 0).toString(); 
	 	        	  selectionModel.setSelectionInterval(row+1,row+1);
	 	        	Stop.stop();
	 	        	  Abc a=new Abc();
	 	        	  a.play();
	 	        	  row=row+1;
	 	        	 table.requestFocusInWindow(); }else{
//                           col = table.getSelectedColumn();  
//      	     row = table.getSelectedRow();  
      	        System.out.println(model.getRowCount());
      	       if(row-1<=-1){row=model.getRowCount();}
      	      table.getModel().getValueAt(row-1, 0); 
                            
//                                System.out.println("in forward"+title);
//                                 String s=Fetchpath.prevSong(title);
//                             List.value=s;
                              selectionModel.setSelectionInterval(row-1,row-1);  
        	      List.value= (String) table.getModel().getValueAt(row-1, 0);
        	      title=List.value;
//        	      col = table.getSelectedColumn();  
         	      
  //      	       row = table.getSelectedRow();  
                             Abc a=new Abc();
                            System.out.println(Thread.currentThread().getName());
                    a.play();
                    row= row-1;
                    refreshcontrols();

                    table.requestFocusInWindow(); }
                             }}}
                       );
               
                
                //--------------------------------Drag and drop
            
           

                slider = new JSlider(JSlider.HORIZONTAL, 0, 100,1);

                slider.setMinorTickSpacing(2);
                slider.setMajorTickSpacing(10);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);

               
                slider.setLabelTable(slider.createStandardLabels(10));
slider.setValue(10);
setVolume(10);
	clock1 = new JLabel();
	clock2 = new JLabel();
       	pbarpanel.add(clock1);
     
                audiocontrols.add(slider);
                label = new JLabel("Volume 10");
                audiocontrols.add(label);
                audiocontrols.add(slider);
                
                panel2.add(pbarpanel,BorderLayout.SOUTH);
                
                slider.addChangeListener( new ChangeListener(){
                    public void stateChanged(ChangeEvent event){
                setVolume(slider.getValue());
                table.requestFocusInWindow(); 
                    }});
                
//              slider.addChangeListener( new ChangeListener(){
//             public void stateChanged(ChangeEvent event){
//              label.setText(""+ slider.getValue()+"%");
//              Mixer.Info [] mixers = AudioSystem.getMixerInfo();  
//              for (Mixer.Info mixerInfo : mixers)  
//                {  
//                    System.out.println("mixer name: " + mixerInfo.getName());  
//                    Mixer mixer = AudioSystem.getMixer(mixerInfo);  
//                    Line.Info [] lineInfos = mixer.getSourceLineInfo();  
//                    for (Line.Info lineInfo : lineInfos)  
//                    {  
//                        System.out.println("  Line.Info: " + lineInfo);  
//                        try {  
//                            Line line = mixer.getLine(lineInfo);  
//                            FloatControl volCtrl =   
//                                (FloatControl)line.getControl(FloatControl.Type.MASTER_GAIN);
//                            System.out.println("volCtrl.getValue() =" + volCtrl.getValue());  
//                  
//                        } catch (LineUnavailableException e) {  
//                            e.printStackTrace();  
//                        } catch (IllegalArgumentException iaEx)  
//                        {  
//                            System.out.println("    " + iaEx);  
//                        }  
//             }}}});
              
              slider.setVisible(true);
//               pbar = new JProgressBar();
            pbar=new JProgressBar();
            pbar.setStringPainted(true);
            pbar.addMouseListener(new MouseAdapter() {            
            	
            	public void mouseClicked(MouseEvent e) {
            		Stop.stop();
            	 seeking=true;
            	 System.out.println(".......................................................................rpt");
            	 if(rpt){
            		 rpttemp=true;
            		 rpt=false;
            	 }
            		int v = pbar.getValue();
            	       System.out.println("----"+v);
            	    
            	       //Retrieves the mouse position relative to the component origin.
            	       int mouseX = e.getX();
            	      if(seeked==0){ timer2= new Timer(1000, new MyTimerActionListener());}
            	       //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
            	        progressBarVal = (int)Math.round(((double)mouseX / (double)pbar.getWidth()) * pbar.getMaximum());

            	       pbar.setValue(progressBarVal);
            	     omg1=  progressBarVal;
            	  //   float secs=(progressBarVal*pval)/1000;
            	     inc=progressBarVal;
            	     startpos=progressBarVal;
            	    	
				System.out.println("p destroyed");
            	     dec=Play.time/1000-progressBarVal;
            	     System.out.println("==================================="+omg1);
            	    seeking=true;
            	     Abc a=new Abc();
						a.play();
					
            	}                                     
            });
              pbar.setMinimum(0);
              pbar.setMaximum(1000);
              pbarpanel.add(pbar);
          	pbarpanel.add(clock2);
        
                     
                //----------------------------menubar------------------------
                // Create the menu bar
 mbar=new MenuBar();
                
                // Create the menu
                menu=new Menu("Menu");
                // Create the menu
                jmenu2=new JPopupMenu();
                
               
                
                // Create MenuItems
                m21=new JMenuItem("Add a song");
                m22=new JMenuItem("Delete song");
                m23=new JMenuItem("Play a song not in lib");
                m24=new JMenuItem("Go to library");
                m25=new JMenuItem("exit");
            m26=new JMenuItem("create playlist");
                menu21=new MenuItem("Add a song");
                menu22=new MenuItem("Delete song");
                menu23=new MenuItem("Play a song not in lib");
                menu24=new MenuItem("Go to library");
                menu25=new MenuItem("exit");
            menu26= new MenuItem("create playlist");
                // Attach menu items to menu
               menu.add(menu21);
               menu.add(menu22);
               menu.add(menu23);
               menu.add(menu24);
               menu.add(menu26);
               menu.add(menu25);
               setMenuBar(mbar);
                jmenu2.add(m21);
                jmenu2.add(m22);
               jmenu2.add(m23);
                jmenu2.add(m24);
                jmenu2.add(m26);
                jmenu2.add(m25);
                mbar.add(menu);
                
                menu21.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                try {
                                	Stop.stop();
                                    openFile();
                                    Jdbc.addsong(file,getTagInfo(file.getAbsolutePath()));
                      	          //model.clear();
                                    model.setRowCount(0);
                                    String rowdata[][]=Jdbc.jdbc2();
                    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
                    	     for(int o=0;o<rowdata.length;o++)
                    	     { model.addRow(rowdata[o]);}
                    	        
                    	        
                    	        	
                    	        
                    	        	
//                                        ArrayList a=Jdbc.jdbc();
//                                        for(int i=0;i<a.size();i++){
//                                         model.addElement(a.get(i));}System.out.println("left");
                                         table.revalidate();
                                           table.repaint();
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                } catch (ID3ReadException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	} catch (UnsupportedTagException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} catch (InvalidDataException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
                System.out.println(":p");
                
                            }
                        });
                
                menu22.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                            	 System.out.println(title);
                                Jdbc.deletesong(title);
                System.out.println(":p");
            	//model.clear();
                model.setRowCount(0);
                String rowdata[][]=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
   	     { model.addRow(rowdata[o]);}

	table.revalidate();
	table.repaint();

                
                            }
                        });
                menu23.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {{
                                  Stop.stop();
                                   System.out.println("stopping");
                               
                                try {
                                    openFile();
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                } catch (ID3ReadException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	} String location=    file.getAbsolutePath();
                    String filename=file.getName();
                
                   Abc abc=new Abc(filename,location);
                   abc.playext();
                             }}
                        }); 
                menu24.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e ){
                           Stop.stop();
                 
                            List a  = new List();
                            setVisible(false);
                            a.setVisible( true );
                             }
                          }
                       );
                menu25.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                System.exit(0);
                
                            }
                        });
                
                menu26.addActionListener(
                        new ActionListener() {
                           public void actionPerformed( ActionEvent e )
                           {
                        	   CreatePlaylist cr=new CreatePlaylist();
	 	       cr.setVisible(true);

              
                          }
                      });
                audiocontrols.addMouseListener(new MouseAdapter(){
                      public void mouseReleased(MouseEvent Me){
                      if(Me.isPopupTrigger()){
                     jmenu2.show(Me.getComponent(), Me.getX(), Me.getY());
                      }
                      }
                      });
                m21.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                try {
                                	Stop.stop();
                                    openFile();
                                    Jdbc.addsong(file,getTagInfo(file.getAbsolutePath()));
                                    model.setRowCount(0);
                  	              String rowdata[][]=Jdbc.jdbc2();
                  	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
                  	        for(int o=0;o<rowdata.length;o++)
                  	   	     { model.addRow(rowdata[o]);}
                  	  table.revalidate();
                  	  table.repaint();
                   	listbox.revalidate();
                   	listbox.repaint();

                                   
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                } catch (ID3ReadException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	} catch (Exception e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}
                System.out.println(":p");
                
                            }
                        });
                
                m22.addActionListener(
                        new ActionListener() {
                            public void actionPerformed( ActionEvent e )
                            {System.out.println(title);
                               Jdbc.deletesong(title);
               System.out.println(":p");
               
               model.setRowCount(0);
               String rowdata[][]=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	     
	        for(int o=0;o<rowdata.length;o++)
   	     { model.addRow(rowdata[o]);}

	table.revalidate();
	table.repaint();

               

      
                           }
                       });
                m23.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                            {
        Stop.stop();
                                   System.out.println("stopping");
                               
                                try {
                                    openFile();
                                    String location=    file.getAbsolutePath();
                                    String filename=file.getName();
                                
                                   Abc abc=new Abc(filename,location);
                                   abc.playext();
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                } catch (ID3ReadException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
	}                       
            String location=    file.getAbsolutePath();
                    String filename=file.getName();
                   
                    Thread playExternal= new Thread(new PlayExternal(filename, location));
                    playExternal.start();
                             }}
                        ); 
                m24.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                             
                            List a  = new List();
                            setVisible(false);
                            a.setVisible( true );
                             }
                          }
                       );
                m25.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                System.exit(0);
                
                            }
                        });
                m26.addActionListener(
                        new ActionListener() {
                           public void actionPerformed( ActionEvent e )
                           { 
                        	   CreatePlaylist cr=new CreatePlaylist();
	 	       cr.setVisible(true);
              
                          }
                      });
            //----------------------------------------------------  
                m31=new JCheckBoxMenuItem("Artist");
                m32=new JCheckBoxMenuItem("Album");
                m33=new JCheckBoxMenuItem("Year");
                m34=new JCheckBoxMenuItem("Genre");
                m35=new JCheckBoxMenuItem("Comment");
                m36=new JCheckBoxMenuItem("Comment2");
               if(cols[0]){
                m31.setSelected(true);}
               if(cols[1]){
                   m32.setSelected(true);}
               if(cols[2]){
                   m33.setSelected(true);}
               if(cols[3]){
                   m34.setSelected(true);}
               if(cols[4]){
                   m35.setSelected(true);}
               jmenulist3=new JPopupMenu();;
               jmenulist3.add(m31);
               jmenulist3.add(m32);
               jmenulist3.add(m33);
               jmenulist3.add(m34);
               jmenulist3.add(m35);
         
             
               
                m31.addActionListener( new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             { System.out.println("list :(");
                            	 if(cols[0]){
                            	 System.out.println("list :(");
                            	 cols[0]=false;
                            	 TableColumn column = table.getColumnModel().getColumn(1);
                                 column.setMinWidth(0);
                                 column.setMaxWidth(0);
                                 column.setWidth(0);
                                 column.setPreferredWidth(0);
                                 doLayout();
                                
                                 o1=0;
                                 }
                             else{
                            	 cols[0]=true;
                            	 TableColumn column = table.getColumnModel().getColumn(1);
                                 column.setMinWidth(200);
                                 column.setMaxWidth(200);
                                 column.setWidth(200);
                                 column.setPreferredWidth(200);
                                 doLayout();
                                 o1=1; 
                             }
                            }
                        });
                m32.addActionListener( new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {if(cols[1]){
                    	 cols[1]=false;
                   	 TableColumn column = table.getColumnModel().getColumn(2);
                        column.setMinWidth(0);
                        column.setMaxWidth(0);
                        column.setWidth(0);
                        column.setPreferredWidth(0);
                        doLayout(); 
                        o2=0;
                    }
                        else{
                        	 cols[1]=true;
                       	 TableColumn column = table.getColumnModel().getColumn(2);
                            column.setMinWidth(200);
                            column.setMaxWidth(200);
                            column.setWidth(200);
                            column.setPreferredWidth(200);
                            doLayout();
                            o2=1; 
                        }
                    }
               });
                m33.addActionListener( new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {if(cols[2]){
                    	 cols[2]=false;
                   	 TableColumn column = table.getColumnModel().getColumn(3);
                        column.setMinWidth(0);
                        column.setMaxWidth(0);
                        column.setWidth(0);
                        column.setPreferredWidth(0);
                        doLayout();
                        o3=0;
                   }
                    else{
                    	 cols[2]=true;
                   	 TableColumn column = table.getColumnModel().getColumn(3);
                        column.setMinWidth(200);
                        column.setMaxWidth(200);
                        column.setWidth(200);
                        column.setPreferredWidth(200);
                        doLayout();
                        o3=1; 
                    }}
               });
                m34.addActionListener( new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {
                    	if(cols[3]){
                    	System.out.println("list :(");
                    		cols[3]=false;
                   	 TableColumn column = table.getColumnModel().getColumn(4);
                        column.setMinWidth(0);
                        column.setMaxWidth(0);
                        column.setWidth(0);
                        column.setPreferredWidth(0);
                        doLayout();  
                   o4=0;
                    }
                    else{
                    	 cols[3]=true;
                   	 TableColumn column = table.getColumnModel().getColumn(4);
                        column.setMinWidth(200);
                        column.setMaxWidth(200);
                        column.setWidth(200);
                        column.setPreferredWidth(200);
                        doLayout();
                        o4=1; 
                    }}
               });
                m35.addActionListener( new ActionListener() {
                    public void actionPerformed( ActionEvent e )
                    {if(cols[4]){
                    	 cols[4]=false;
                   	 TableColumn column = table.getColumnModel().getColumn(5);
                        column.setMinWidth(0);
                        column.setMaxWidth(0);
                        column.setWidth(0);
                        column.setPreferredWidth(0);
                        doLayout();  
                   o5=0;
                    }
                    else{
                    	 cols[4]=true;
                   	 TableColumn column = table.getColumnModel().getColumn(5);
                        column.setMinWidth(200);
                        column.setMaxWidth(200);
                        column.setWidth(200);
                        column.setPreferredWidth(200);
                        doLayout();
                        o5=1; 
                    }}
               });
                
              //--------------------------------------------------------control menu-------------------------------------
               control=new Menu("Controls");
               play1=new MenuItem("play");
               nxt1=new MenuItem("next");
               prv1=new MenuItem("previous");
            	plrc1=new Menu("Playrecent");
            	gotocurr1=new MenuItem("Go to current song");
            	incvol1=new MenuItem("increase volume");
            	decvol1=new MenuItem("Decrease Volume");
            	shuffle1=new CheckboxMenuItem("shuffle");
            	repeat1=new CheckboxMenuItem("repeat");
              
            	control.add(play1);
            	control.add(nxt1);
            	control.add(prv1);
            	control.add(plrc1);
            	control.add(gotocurr1);
            	control.add(incvol1);
            	control.add(decvol1);
            	
                control.addSeparator();
            	control.add(shuffle1);
            	control.add(repeat1);
            	Jdbc.recentsongs();

            	refreshcontrols();
            	 play1.addActionListener(
                         new ActionListener() {
                 
                            public void actionPerformed( ActionEvent e )
                            {  
                                Stop.stop();
       	                      isplaying= 1;
       	                      row= rowhold;
          System.out.println("length:"+recent.size());
      	 System.out.println(recent.size());
      	
      	 if(value==null){
 			value=table.getValueAt(0,0).toString();
 			System.out.println("]]]]]]]]]]]]]]]]"+value);
 			 selectionModel.addSelectionInterval(0, 0);
 		}
System.out.println(dec);
      timer= new Timer(1000, new MyTimerActionListener());
System.out.println("int timer");
      	 Abc a=new Abc();
           a.play();
      	 refreshcontrols();
     doLayout();
     table.requestFocusInWindow(); 
                            }
                                });
                       
                      
                       
                      
                       nxt1.addActionListener(
                                 new ActionListener() {
                                    public void actionPerformed( ActionEvent e )
                                    { if(!rpt){ Stop.stop();
                                    stopped=true;
                                    System.out.println("stopped"+row);  
        if(shfl){    	 
        	String sh[][]= null;
        if(node!=null){
        	 
        if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
        else{
        sh= Playlist.getSongs(actvplaylist);
        }	}	
        else{
        sh= Jdbc.jdbc2(); 
        }ArrayList sh2= new ArrayList();
        for(int z=0; z<sh.length; z++)
        {
        sh2.add(sh[z]);
        }

        row = 0 + (int)(Math.random()*sh.length);
        System.out.println("rooooooooowwwwwwww In shuffle"+row);
        value=table.getModel().getValueAt(row+1, 0).toString(); 
        selectionModel.setSelectionInterval(row+1,row+1);
        Stop.stop();
        Abc a=new Abc();
        a.play();
        row=row+1;
        table.requestFocusInWindow(); }
        else{
//             	       col = table.getSelectedColumn();  
             	      
          //   	       row = table.getSelectedRow();  
             	        System.out.println(model.getRowCount());
             	       if(row+1>=model.getRowCount()){row=-1;
             	       
             	       }
             	      table.getModel().getValueAt(row+1, 0); 
             	   
//             	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                                     System.out.println("in forward"+title);
//                                         String s=Fetchpath.nextSong(title);
             	    System.out.println(row);
             	      if(row+1>model.getRowCount()){System.out.println("mnop");}
             	     selectionModel.setSelectionInterval(row+1,row+1);  
             	      List.value= (String) table.getModel().getValueAt(row+1, 0);
             	     title=List.value;
             	  //  col = table.getSelectedColumn();  
           	      
          	      // row = table.getSelectedRow();  
             	      Abc a=new Abc();
                        System.out.println(Thread.currentThread().getName());
                a.play();
                row= row+1;
                refreshcontrols();
                table.requestFocusInWindow(); 
        }   
                                     } }
                                 }
                              );
                       prv1.addActionListener(
                                 new ActionListener() {
                                    public void actionPerformed( ActionEvent e )
                                    { 
                                        if(!rpt){	 Stop.stop();
                                        stopped=true;
                                        	 if(shfl){    	  String sh[][]= null;
                                       	  if(node!=null){
                                         	 
            	 	      if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
            	 	      else{
            	 	    	 sh= Playlist.getSongs(actvplaylist);
            	 	      }	}	
            	 	     else{
            	 	    	sh= Jdbc.jdbc2(); 
            	 	     }ArrayList sh2= new ArrayList();
            	 	        	for(int z=0; z<sh.length; z++)
            	 	        	{
            	 	        	sh2.add(sh[z]);
            	 	        	}
            	 	        	
            	 	        	row = 0 + (int)(Math.random()*sh.length);
            	 	        	System.out.println("rooooooooowwwwwwww In shuffle"+row);
            	 	        	value=table.getModel().getValueAt(row+1, 0).toString(); 
            	 	        	  selectionModel.setSelectionInterval(row+1,row+1);
            	 	        	Stop.stop();
            	 	        	  Abc a=new Abc();
            	 	        	  a.play();
            	 	        	  row=row+1;
            	 	        	 table.requestFocusInWindow(); }else{
//                                       col = table.getSelectedColumn();  
//                  	     row = table.getSelectedRow();  
                  	        System.out.println(model.getRowCount());
                  	       if(row-1<=-1){row=model.getRowCount();}
                  	      table.getModel().getValueAt(row-1, 0); 
                                        
//                                            System.out.println("in forward"+title);
//                                             String s=Fetchpath.prevSong(title);
//                                         List.value=s;
                                          selectionModel.setSelectionInterval(row-1,row-1);  
                    	      List.value= (String) table.getModel().getValueAt(row-1, 0);
                    	      title=List.value;
//                    	      col = table.getSelectedColumn();  
                     	      
              //      	       row = table.getSelectedRow();  
                                         Abc a=new Abc();
                                        System.out.println(Thread.currentThread().getName());
                                a.play();
                                row= row-1;
                                refreshcontrols();

                                table.requestFocusInWindow(); }
                                         } }}
                              );
                        
                       incvol1.addActionListener(
                               new ActionListener() {
                       
                                  public void actionPerformed( ActionEvent e )
                                  {  
                                  	               setVolume(slider.getValue()+5);
                                  	               slider.setValue(slider.getValue()+5);
                                  	             table.requestFocusInWindow(); 
                                  }
                                      });
                       decvol1.addActionListener(
                               new ActionListener() {
                       
                                  public void actionPerformed( ActionEvent e )
                                  {  
                                	  setVolume(slider.getValue()-5);
                     	               slider.setValue(slider.getValue()-5);
                     	              table.requestFocusInWindow(); 
                                  }
                                      });
                       shuffle1.addItemListener(
                               new ItemListener() {
                                   public void itemStateChanged(ItemEvent e )
                                  {
if(shfl){shfl=false;}else{ shfl=true;
                                if(List.isplaying==0){	  String sh[][]= null;
                                	  if(node!=null){
                                	 
    	 	      if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
    	 	      else{
    	 	    	 sh= Playlist.getSongs(actvplaylist);
    	 	      }	}	
    	 	     else{
    	 	    	sh= Jdbc.jdbc2(); 
    	 	     }ArrayList sh2= new ArrayList();
    	 	        	for(int z=0; z<sh.length; z++)
    	 	        	{
    	 	        	sh2.add(sh[z]);
    	 	        	}
    	 	        	
    	 	        	row = 0 + (int)(Math.random()*sh.length);
    	 	        	System.out.println("rooooooooowwwwwwww In shuffle"+row);
    	 	        	value=table.getModel().getValueAt(row+1, 0).toString(); 
    	 	        	  selectionModel.setSelectionInterval(row+1,row+1);
    	 	        	Stop.stop();
    	 	           timer= new Timer(1000, new MyTimerActionListener());
    	 	        	  Abc a=new Abc();
    	 	        	  a.play();
    	 	        	  row=row+1;}
    	 	        	 table.requestFocusInWindow(); 
} }
                                      });
                       repeat1.addItemListener(
                               new ItemListener() {
                                  public void itemStateChanged(ItemEvent e )
                                  { System.out.println("rpt------"+rpt);
                                	  if(rpt){
                                	  rpt=false;
                                	  System.out.println("rpt-----false");
                                	 }
                                  else{
                                	 System.out.println("rpt------true");
                                	  rpt=true;
                                
                                  }}
                                      });
                       gotocurr1.addActionListener(
                               new ActionListener() {
                       
                                  public void actionPerformed( ActionEvent e )
                                  {
                                	  table.scrollRectToVisible(table.getCellRect(row, 0, false));
                                	  table.requestFocusInWindow(); 
                               
                                  }
                                      });
                 
            	mbar.add(control);
                //------------------------------------------
//       add(myPanel);
                audiocontrols.add(jmenu2);
                audiocontrols.add(play);
                audiocontrols.add(pause);
                audiocontrols.add(forward);
                audiocontrols.add(rewind);
                audiocontrols.add(stop);
                new  FileDrop(audiocontrols, new FileDrop.Listener()
                  {   public void  filesDropped( java.io.File[] files )
                      {  
//                    List.dragged=true;
                     
                          Stop.stop();
                   System.out.println("stopping");
//                
                        for(int i=0;i<files.length;i++){
                            System.out.println(files[i].getName());
                            System.out.println(files[i].getAbsolutePath());
                            try {
								Jdbc.addsong(files[i],getTagInfo(files[i].getAbsolutePath()));
							} catch (UnsupportedTagException
									| InvalidDataException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                      
                        }
                    String location= files[0].getAbsolutePath();
                    String filename= files[0].getName();  
                    System.out.println(files[0].getName());
                    System.out.println(files[0].getAbsolutePath());
                    model.setRowCount(0);
                    String rowdata[][]=Jdbc.jdbc2();
    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
    	     
    	        for(int o=0;o<rowdata.length;o++)
    	   	     { model.addRow(rowdata[o]);}
    	table.revalidate();
    	table.repaint();

                    
 
                      } 
                  });   
               
           








	     	
	     	
	     	//--------------------tree------------------------------------------------------

	     	  jmenu=new JPopupMenu();
 
	
	          // Create MenuItems
	          m1=new JMenuItem("Open playlist in new window ");
	          m2=new JMenuItem("Delete playlist");
	   m1.addActionListener(
	 	      new ActionListener() {
	 	         public void actionPerformed( ActionEvent e )
	 	         {
	                 model.setRowCount(0);
	                 String rowdata[][]=Jdbc.jdbc2();
	 	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	 	     
	        for(int o=0;o<rowdata.length;o++)
	   	     { model.addRow(rowdata[o]);}
	 	table.revalidate();
	 	table.repaint();

	                 
OpenPlaylist op=new OpenPlaylist(node);
System.out.println(cols);
refreshplaylist();
tree.setSelectionRow(1);
acl= 0;
op.setVisible(true);

	}
	
	        });
	    
	    m2.addActionListener(
	 	      new ActionListener() {
	 	         public void actionPerformed( ActionEvent e )
	 	         {
	 	        	 System.out.println(selectednode);
	 	        	final JOptionPane optionPane = new JOptionPane(
	 	                 "Are you sure you want to delete this playlist",
	 	                   JOptionPane.QUESTION_MESSAGE,
	 	                   JOptionPane.YES_NO_OPTION);
//	 	        getContentPane().add(optionPane);
	 	       final JDialog dialog = new JDialog(frame, 
	                             "Click a button",
	                             true);
	 	      optionPane.addPropertyChangeListener(
	 	    	    new PropertyChangeListener() {
	 	    	        public void propertyChange(PropertyChangeEvent e) {
	 	    	            String prop = e.getPropertyName();

	 	    	            if (dialog.isVisible() 
	 	    	             && (e.getSource() == optionPane)
	 	    	             && (prop.equals(JOptionPane.VALUE_PROPERTY))) {
	 	    	               
	 	    	                dialog.setVisible(false);
	 	    	            }
	 	    	        }
	 	    	    });
	 	      dialog.setContentPane(optionPane);
	 	      dialog.pack();
	 	     dialog.setVisible(true);
	 	    int value = ((Integer)optionPane.getValue()).intValue();
	 	   if (value == JOptionPane.YES_OPTION) {
	 	        	 Playlist.deleteplaylist(selectednode);	
refreshplaylist();
	 	        	 refreshlibrary();
refreshjmenu();
acl=0;
	 	   } else if (value == JOptionPane.NO_OPTION) {
	 	      System.out.println("no");
	 	   refreshplaylist();
	 	   }


	 	         }
	        });
	          
	          
	          jmenu.add(m1);
	   jmenu.add(m2)
	   ;
	   
	 


      

jmenulist=new JPopupMenu();
   
       // Create MenuItems
       jmenulist1=new JMenu("Add to Playlist");
  test=new MenuItem("test");
  final ArrayList submenu=Playlist.getPlaylists();
  for(k=0;k<submenu.size();k++)
  {
	  final JMenuItem ex=new JMenuItem(submenu.get(k).toString());
	  ex.addActionListener(
	      new ActionListener() {
	         public void actionPerformed( ActionEvent e ){ 	
	     JMenuItem m=(JMenuItem) e.getSource();
	System.out.println(m);	
	System.out.println(m.getText());	
	Playlist.addtoplaylist(m.getText(),Playlist.getid(songtoadd));
	
	         }});
       jmenulist1.add(ex);
  
  }
 


  jmenulist.add(jmenulist1);
       listbox.add(jmenulist);

//	     	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Lists");
//	        //create the child nodes
//	        DefaultMutableTreeNode Library = new DefaultMutableTreeNode("Library");
//
//Playlists = new DefaultMutableTreeNode("Playlists");
//	        Playlists.removeAllChildren();
//	        ArrayList playlist=new ArrayList<>();
//	      playlist=Playlist.getPlaylists();
//	      
//	      for(int i=0;i<playlist.size();i++)
//	      {
//	 Playlists.add(new DefaultMutableTreeNode(playlist.get(i)));
//	
//	      }
//	        
//	        root.add(Library);
//	        root.add(Playlists);

	      
	    

	        //create the tree by passing in the root node
	        tree = new JTree(treeModel); 
	        tree.expandRow(2);
	        tree.setModel(CreateTree.getmodel());
	        tree.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent e) {
	if (SwingUtilities.isRightMouseButton(e)){
	acl= 1;
	
	System.out.println("right");   
	jmenu.show(e.getComponent(), e.getX(), e.getY());
	   System.out.println(tree.getRowForLocation(e.getX(), e.getY()));
	System.out.println("--------------"+
	   tree.getPathForLocation(e.getX(), e.getY()).getLastPathComponent().toString());
	System.out.println(":P");   
	 selectednode=tree.getPathForLocation(e.getX(), e.getY()).getLastPathComponent().toString();
	System.out.println(selectednode);
	
	   table.requestFocusInWindow(); }}});
	        
	
	      tree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
	          public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
	        	  if(acl ==0){ 
	        	 
	         node=  evt.getNewLeadSelectionPath().getLastPathComponent().toString();
	if(node.equals("Library")){
	System.out.println("library");
	actvplaylist="library";
	      model.setRowCount(0);
              String rowdata[][]=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
   	     { model.addRow(rowdata[o]);}
	  table.revalidate();
	  table.repaint();
	   table.requestFocusInWindow();       }
	else{
	actvplaylist=node;
	 model.setRowCount(0);
             String rowdata[][]=Playlist.getSongs(node);
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
   	     { model.addRow(rowdata[o]);}
	  table.revalidate();
	  table.repaint();
	   table.requestFocusInWindow(); }	   table.requestFocusInWindow(); 
	
	          }
	      }});
	 
	        subPanel.add(tree);
	        tree.add(jmenu);
	        
	        //-----------------------------------------------------------------------------------
	        
	       rowdata=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	     
	       model = new DefaultTableModel(
	        	rowdata, columnNames
	        	
	        	);
	       
	         table = new JTable(model);
	         table.requestFocusInWindow(); 
	         table.setAutoCreateRowSorter(true);
	         
subPanel_lib.add(new JScrollPane(table));
table.scrollRectToVisible(table.getCellRect(0, 0, true));
	       
	         selectionModel = 
	        	  table.getSelectionModel();
	        	
	        table.addMouseListener(new MouseAdapter() {
	@Override
	    public void mousePressed(MouseEvent e) {
	songstoadd.clear();
	        dragSourceIndex = table.getSelectedRows();
	      
	        col = table.getSelectedColumn();  
	       row = table.getSelectedRow();  
	      table.getModel().getValueAt(row, 0);  
	     int[] abc=table.getSelectedRows();
	     System.out.println("dnd:::"+table.getSelectedRows());
	    ArrayList mn=new ArrayList<>();
	     for(int w=0;w<abc.length;w++){
	    	mn.add(table.getValueAt(abc[w], 0).toString()); 
	    	System.out.println("dnd:::::"+table.getValueAt(abc[w], 0).toString());
	     }
	     String[] s=new String[mn.size()];
	      songstoadd=mn;
	// if(songstoadd.size()==0){
//	 songstoadd.add(listbox.getSelectedValue().toString());
//	 System.out.println("adding");
	// }
//	   songtoadd=(String) listbox.getSelectedValue();
	
	}
	
	  
	    @Override
	    public void mouseDragged(MouseEvent e) {            
	        mouseDragging = true;
	        System.out.println("2");
	    }
	public void mouseClicked(MouseEvent e) {
	    if (SwingUtilities.isRightMouseButton(e)){
	      System.out.println("right click"+listbox.getSelectedValue());
	    	jmenulist.show(e.getComponent(), e.getX(), e.getY());
//	    	listbox.getPathForLocation(e.getX(), e.getY())
	  System.out.println(listbox.locationToIndex(e.getPoint()));
	  row= table.rowAtPoint(e.getPoint());
	 col=table.columnAtPoint(e.getPoint());
	songtoadd=   table.getValueAt(row,0).toString();
//	       
	  //songtoadd=model.getElementAt(table.locationToIndex(e.getPoint())).toString();
	    }
	    else{
	    	 isplaying=0;
	    	 System.out.println("---------------------------"+listbox.getSelectedValuesList());
	        col = table.getSelectedColumn();  
	        rowhold = table.getSelectedRow();  
	       value= table.getValueAt(rowhold, 0).toString();
	     System.out.println("................................."+ table.getSelectedRow());
	       //value= table.getValueAt(row, 1);
	//value = (String)(listbox.getSelectedValue());
	    	title= value;
	if(j==1){
	    	System.out.println("delete");
	    	 for(int rs=0;rs<recent.size();rs++){
            	 if(recent.get(rs).equals(value)){
        recent.remove(rs);
            	 }
             }
	    	Jdbc.deletesong(value);
	    	j=0;
	    	add.setVisible(true);
	    	delete.setVisible(true);
	    	 model.setRowCount(0);
	    	              String rowdata[][]=Jdbc.jdbc2();
	    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	    	        for(int o=0;o<rowdata.length;o++)
	    	   	     { model.addRow(rowdata[o]);}
	    	  table.revalidate();
	    	  table.repaint();
	    	}else{
	System.out.println(value);
	

	            }}
	}});

	        MouseListener popupListener = new PopupListener();
	        table.getTableHeader().addMouseListener(popupListener);
	        //----------------------------------------
	       subPanel_lib.add(table.getTableHeader(), BorderLayout.NORTH);
//	        subPanel_lib.add(table, BorderLayout.CENTER);  
//	    System.out.println(cols[0]);
          
      
           if(List.cols[0]){
               
           	 TableColumn column = table.getColumnModel().getColumn(1);
                column.setMinWidth(200);
                column.setMaxWidth(200);
                column.setWidth(200);
                column.setPreferredWidth(200);
                doLayout();
              
            }
          else{
          	 TableColumn column = table.getColumnModel().getColumn(1);
               column.setMinWidth(0);
               column.setMaxWidth(0);
               column.setWidth(0);
               column.setPreferredWidth(0);
               doLayout();	
          }
       
  if(List.cols[1]){
  	
      	 TableColumn column = table.getColumnModel().getColumn(2);
           column.setMinWidth(200);
           column.setMaxWidth(200);
           column.setWidth(200);
           column.setPreferredWidth(200);
           doLayout();
         
       }   else{
      	 TableColumn column = table.getColumnModel().getColumn(2);
           column.setMinWidth(0);
           column.setMaxWidth(0);
           column.setWidth(0);
           column.setPreferredWidth(0);
           doLayout();	
      }
   
  if(List.cols[2]){
   	
  	 TableColumn column = table.getColumnModel().getColumn(3);
       column.setMinWidth(200);
       column.setMaxWidth(200);
       column.setWidth(200);
       column.setPreferredWidth(200);
       doLayout();
     
   }
  else{
  	 TableColumn column = table.getColumnModel().getColumn(3);
      column.setMinWidth(0);
      column.setMaxWidth(0);
      column.setWidth(0);
      column.setPreferredWidth(0);
      doLayout();	
  }

  if(List.cols[3]){
   
  	 TableColumn column = table.getColumnModel().getColumn(4);
       column.setMinWidth(200);
       column.setMaxWidth(200);
       column.setWidth(200);
       column.setPreferredWidth(200);
       doLayout();
     
   }
  else{
  	 TableColumn column = table.getColumnModel().getColumn(4);
      column.setMinWidth(0);
      column.setMaxWidth(0);
      column.setWidth(0);
      column.setPreferredWidth(0);
      doLayout();	
  }

  if(List.cols[4]){
   	
  	 TableColumn column = table.getColumnModel().getColumn(5);
       column.setMinWidth(200);
       column.setMaxWidth(200);
       column.setWidth(200);
       column.setPreferredWidth(200);
       doLayout();
    
   } 
  else{
  	 TableColumn column = table.getColumnModel().getColumn(5);
      column.setMinWidth(0);
      column.setMaxWidth(0);
      column.setWidth(0);
      column.setPreferredWidth(0);
      doLayout();	
  }
	     	//----------------------------------------------tree----------------------------------------------
	     	
	listbox.setVisibleRowCount(-1);
	table.setDragEnabled(true);
	
	listbox.addMouseListener(new MouseAdapter() {
	@Override
	    public void mousePressed(MouseEvent e) {
	songstoadd.clear();
	        dragSourceIndex = table.getSelectedRows();
	        System.out.println("---------------------------"+listbox.getSelectedValuesList());
songstoadd=listbox.getSelectedValuesList();
// if(songstoadd.size()==0){
//	 songstoadd.add(listbox.getSelectedValue().toString());
//	 System.out.println("adding");
// }
//	   songtoadd=(String) listbox.getSelectedVaslue();
	
	}
	  
	    @Override
	    public void mouseDragged(MouseEvent e) {            
	        mouseDragging = true;
	        System.out.println("2");
	    }
	public void mouseClicked(MouseEvent e) {
	    if (SwingUtilities.isRightMouseButton(e)){
	      System.out.println("right click"+listbox.getSelectedValue());
	    	jmenulist.show(e.getComponent(), e.getX(), e.getY());
//	    	listbox.getPathForLocation(e.getX(), e.getY())
	  System.out.println(listbox.locationToIndex(e.getPoint()));
	 
	  row= table.rowAtPoint(e.getPoint());
	  
	  col=table.columnAtPoint(e.getPoint());
	songtoadd=   table.getValueAt(row, col).toString();
//	    }
	    }	    else{
	value = (String)(listbox.getSelectedValue());
    	title= value;
	if(j==1){
    	System.out.println("delete");
    	Jdbc.deletesong(value);
    	j=0;
    	add.setVisible(true);
    	delete.setVisible(true);
    	 model.setRowCount(0);
    	              String rowdata[][]=Jdbc.jdbc2();
    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
    	        for(int o=0;o<rowdata.length;o++)
    	   	     { model.addRow(rowdata[o]);}
    	  table.revalidate();
    	  table.repaint();	}else{
	System.out.println(value);
	

	            }}
	}});////subPanel_lib.add(listbox,BorderLayout.CENTER);
subPanel_lib.add(btnpanel,BorderLayout.SOUTH);
	add = new JButton("add a song");
	
	        add.addActionListener(
	 	      new ActionListener() {
	 	         public void actionPerformed( ActionEvent e )
	 	         {
	 	        	 
	 	        	 try {
	 	        	
	openFile();

	    	 ID3v2 id3v1Tag = getTagInfo(file.getAbsolutePath());
	Jdbc.addsong(file,id3v1Tag);
	acl=0;
	 model.setRowCount(0);
	              String rowdata[][]=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
	   	     { model.addRow(rowdata[o]);}
	  table.revalidate();
	  table.repaint();
	} catch (ID3ReadException | IOException e1)
	 	        	 {
	e1.printStackTrace();
	} catch (UnsupportedTagException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (InvalidDataException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	 	         }
	 	      }
	 	   );   
	     btnpanel.add(add);
//	        add.setBounds(0,550,80,25);

	 delete = new JButton("delete song");
	        delete.setSize(20,20);
	        delete.addActionListener(
	 	      new ActionListener() {
	 	         public void actionPerformed( ActionEvent e )
	 	         {
	 	        j=1;
	 	         add.setVisible(false);
	 	        delete.setVisible(false);
	 	         }
	 	      }
	 	   );   
	        btnpanel.add(delete);
//	        delete.setBounds(80,550,80,25);
	        shuffle = new JButton("shuffle");
	       shuffle.setSize(20,20);
	       shuffle.addActionListener(
	 	      new ActionListener() {
	 	         public void actionPerformed( ActionEvent e )
	 	         {String sh[][]= null;
	 	      if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
	 	      else{
	 	    	 sh= Playlist.getSongs(actvplaylist);
	 	      }	 	        	ArrayList sh2= new ArrayList();
	 	        	for(int z=0; z<sh.length; z++)
	 	        	{
	 	        	sh2.add(sh[z]);
	 	        	}
	 	        	Collections.shuffle(sh2);
	 	        	
	 	        	
	 	        	for(int z=0; z<sh.length; z++)
	 	        	{
	 	        	sh[z]= (String[]) sh2.get(z);
	 	        	}
	 	           model.setRowCount(0);
	                    String rowdata[][]=sh;
	    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	    	     
	    	        for(int o=0;o<rowdata.length;o++)
	    	   	     { model.addRow(rowdata[o]);}
	    	table.revalidate();
	    	table.repaint();
	
	 	       }
	 	         
	 	         
	 	      }
	 	   );   
	        btnpanel.add(  shuffle);
	        //=========================================================
	        table.setFocusable(true);
	        table.requestFocusInWindow(); 
	        table.addKeyListener(new KeyAdapter() {
	
	            @Override
	            public void keyTyped(KeyEvent e) {
//	               myKeyEvt(e, "keyTyped");
	            }
	
	            @Override
	                  public void keyReleased(KeyEvent e) {
//	               myKeyEvt(e, "keyReleased");
	            }
	
	            @Override
	            public void keyPressed(KeyEvent e) {
	               myKeyEvt(e, "keyPressed");
	            }
	
	            private void myKeyEvt(KeyEvent e, String text) {
	               int key = e.getKeyCode();
	               System.out.println("TEST");
	
	               if (key == KeyEvent.VK_KP_LEFT && e.isControlDown() || key == KeyEvent.VK_LEFT && e.isControlDown())
	               {
	                   System.out.println(text + " LEFT");
	                   if(!rpt){	 Stop.stop();
                       stopped=true;
                       	 if(shfl){    	  String sh[][]= null;
                      	  if(node!=null){
                        	 
	      if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
	      else{
	    	 sh= Playlist.getSongs(actvplaylist);
	      }	}	
	     else{
	    	sh= Jdbc.jdbc2(); 
	     }ArrayList sh2= new ArrayList();
	        	for(int z=0; z<sh.length; z++)
	        	{
	        	sh2.add(sh[z]);
	        	}
	        	
	        	row = 0 + (int)(Math.random()*sh.length);
	        	System.out.println("rooooooooowwwwwwww In shuffle"+row);
	        	value=table.getModel().getValueAt(row+1, 0).toString(); 
	        	  selectionModel.setSelectionInterval(row+1,row+1);
	        	Stop.stop();
	        	  Abc a=new Abc();
	        	  a.play();
	        	  row=row+1;
	        	 table.requestFocusInWindow(); }else{
//                      col = table.getSelectedColumn();  
// 	     row = table.getSelectedRow();  
 	        System.out.println(model.getRowCount());
 	       if(row-1<=-1){row=model.getRowCount();}
 	      table.getModel().getValueAt(row-1, 0); 
                       
//                           System.out.println("in forward"+title);
//                            String s=Fetchpath.prevSong(title);
//                        List.value=s;
                         selectionModel.setSelectionInterval(row-1,row-1);  
   	      List.value= (String) table.getModel().getValueAt(row-1, 0);
   	      title=List.value;
//   	      col = table.getSelectedColumn();  
    	      
//      	       row = table.getSelectedRow();  
                        Abc a=new Abc();
                       System.out.println(Thread.currentThread().getName());
               a.play();
               row= row-1;
               refreshcontrols();

               table.requestFocusInWindow(); }
                        }
	                   //Call some function
	               }
	               if (key == KeyEvent.VK_SPACE)
	               {
	                   System.out.println(text + " SPACE");
	                   if(!rpt){ Stop.stop();
                       stopped=true;
                      System.out.println("stopped"+row);  
if(shfl){    	 
String sh[][]= null;
if(node!=null){

if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
else{
sh= Playlist.getSongs(actvplaylist);
}	}	
else{
sh= Jdbc.jdbc2(); 
}ArrayList sh2= new ArrayList();
for(int z=0; z<sh.length; z++)
{
sh2.add(sh[z]);
}

row = 0 + (int)(Math.random()*sh.length);
System.out.println("rooooooooowwwwwwww In shuffle"+row);
value=table.getModel().getValueAt(row+1, 0).toString(); 
selectionModel.setSelectionInterval(row+1,row+1);
Stop.stop();
Abc a=new Abc();
a.play();
row=row+1;
table.requestFocusInWindow(); }
else{
//	       col = table.getSelectedColumn();  
	      
//   	       row = table.getSelectedRow();  
	        System.out.println(model.getRowCount());
	       if(row+1>=model.getRowCount()){row=-1;
	       
	       }
	      table.getModel().getValueAt(row, 0); 
	   
//	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                       System.out.println("in forward"+title);
//                           String s=Fetchpath.nextSong(title);
	    System.out.println(row);
	      if(row+1>model.getRowCount()){System.out.println("mnop");}
	     selectionModel.setSelectionInterval(row,row);  
	      List.value= (String) table.getModel().getValueAt(row, 0);
	     title=List.value;
	  //  col = table.getSelectedColumn();  
	      
      // row = table.getSelectedRow();  
	      Abc a=new Abc();
          System.out.println(Thread.currentThread().getName());
  a.play();
  row= row+1;
  refreshcontrols();
  table.requestFocusInWindow(); 
}   
                       }
	               }
	               else if (key == KeyEvent.VK_KP_RIGHT && e.isControlDown()|| key == KeyEvent.VK_RIGHT && e.isControlDown())
	               {
	                   System.out.println(text + " RIGHT");
	                   if(!rpt){ Stop.stop();
                       stopped=true;
                      System.out.println("stopped"+row);  
if(shfl){    	 
String sh[][]= null;
if(node!=null){

if(node.equals("Library")){  	sh= Jdbc.jdbc2();}
else{
sh= Playlist.getSongs(actvplaylist);
}	}	
else{
sh= Jdbc.jdbc2(); 
}ArrayList sh2= new ArrayList();
for(int z=0; z<sh.length; z++)
{
sh2.add(sh[z]);
}

row = 0 + (int)(Math.random()*sh.length);
System.out.println("rooooooooowwwwwwww In shuffle"+row);
value=table.getModel().getValueAt(row+1, 0).toString(); 
selectionModel.setSelectionInterval(row+1,row+1);
Stop.stop();
Abc a=new Abc();
a.play();
row=row+1;
table.requestFocusInWindow(); }
else{
//	       col = table.getSelectedColumn();  
	      
//   	       row = table.getSelectedRow();  
	        System.out.println(model.getRowCount());
	       if(row+1>=model.getRowCount()){row=-1;
	       
	       }
	      table.getModel().getValueAt(row+1, 0); 
	   
//	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                       System.out.println("in forward"+title);
//                           String s=Fetchpath.nextSong(title);
	    System.out.println(row);
	      if(row+1>model.getRowCount()){System.out.println("mnop");}
	     selectionModel.setSelectionInterval(row+1,row+1);  
	      List.value= (String) table.getModel().getValueAt(row+1, 0);
	     title=List.value;
	  //  col = table.getSelectedColumn();  
	      
      // row = table.getSelectedRow();  
	      Abc a=new Abc();
          System.out.println(Thread.currentThread().getName());
  a.play();
  row= row+1;
  refreshcontrols();
  table.requestFocusInWindow(); 
}   
                       }
	                                                    //Call some function
	               }
	               else if (key == KeyEvent.VK_I && e.isControlDown())
	               {

      	               setVolume(slider.getValue()+5);
      	               slider.setValue(slider.getValue()+5);
      	             table.requestFocusInWindow(); 
	               }
	               else if (key == KeyEvent.VK_D && e.isControlDown())
	               {

      	               setVolume(slider.getValue()-5);
      	               slider.setValue(slider.getValue()-5);
      	             table.requestFocusInWindow(); 
	               }
	               else if (key == KeyEvent.VK_L && e.isControlDown())
	               {


                 	  table.scrollRectToVisible(table.getCellRect(row, 0, false));
                 	  table.requestFocusInWindow(); 
                 	  
	               }
	            }
	
	
	         });
	        
	      	        //--------------------------------------------------------------------------------------------
	        new DropTarget(tree,new DropTargetListener() {
	
	@Override
	public void dropActionChanged(DropTargetDragEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	
	@Override
	public void drop(DropTargetDropEvent e) {
	e.getLocation();
	Point p=e.getLocation();
	  String ply = tree.getPathForLocation(p.x,p.y).getLastPathComponent().toString();
	   System.out.println(ply);
	   if(songstoadd.size()>0){
	   for(int o=0;o<songstoadd.size();o++){
	   System.out.println(songstoadd.get(o).toString());
	   Playlist.addtoplaylist(ply,Playlist.getid(songstoadd.get(o).toString()));   
	   }
	   }
	   else{
	   Playlist.addtoplaylist(ply,Playlist.getid(songtoadd));
	   }	
	}
	
	@Override
	public void dragOver(DropTargetDragEvent e) {
	
	
	}
	
	@Override
	public void dragExit(DropTargetEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	
	@Override
	public void dragEnter(DropTargetDragEvent arg0) {
	// TODO Auto-generated method stub
	
	}
	});
	        
	        
	        
//	        new  FileDrop(subPanel_lib, new FileDrop.Listener()
//	                  {   public void  filesDropped( java.io.File[] files )
//	                      {  
//	                	  System.out.println("filedrop");
////	                    List.dragged=true;
//	                     
//	                          Stop.stop();
//	                   System.out.println("stopping");
////	                 if(node!=null){
//	                    if(node.equals("Library")){
//	                        for(int i=0;i<files.length;i++){
//	                            System.out.println(files[i].getName());
//	                            System.out.println(files[i].getAbsolutePath());
//	                            Jdbc.addsong(files[i],getTagInfo(files[i].getAbsolutePath()));
//	                      
//	                        }
//	                        }
//	                    else{
//	                    	for(int i=0;i<files.length;i++){
//	                            System.out.println(files[i].getName());
//	                            System.out.println(files[i].getAbsolutePath());
//	                            Jdbc.addsong(files[i],getTagInfo(files[i].getAbsolutePath()));
//	                      Playlist.addtoplaylist(node, id);
//	                    }
//	                    String location= files[0].getAbsolutePath();
//	                    String filename= files[0].getName();  
//	                    System.out.println(files[0].getName());
//	                    System.out.println(files[0].getAbsolutePath());
//	                    model.setRowCount(0);
//	                    if(node!=null){
//	                    if(node.equals("Library")){
//	                    String rowdata[][]=Jdbc.jdbc2();
//	    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
//	    	     
//	    	        for(int o=0;o<rowdata.length;o++)
//	    	   	     { model.addRow(rowdata[o]);}}
//	                    else{
//	                    	 String rowdata[][]=Jdbc.jdbc2();
//	    	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
//	    	     
//	    	        for(int o=0;o<rowdata.length;o++)
//	    	   	     { model.addRow(rowdata[o]);}	
//	                    }
//	                    }	    	table.revalidate();
//	    	table.repaint();
//
//	                    
//	 
//	                      } 
//	                  }); }
	
	        new  FileDrop(subPanel_lib, new FileDrop.Listener()
	                  {   public void  filesDropped( java.io.File[] files )
	                      {  
//	                    List.dragged=true;
	                     
	                          Stop.stop();
	                   System.out.println("stopping");
//	                
	                        for(int i=0;i<files.length;i++){
	                            System.out.println(files[i].getName());
	                            System.out.println(files[i].getAbsolutePath());
	                            System.out.println("working-----------------1");
	                            try {
									Jdbc.addsong(files[i],getTagInfo(files[i].getAbsolutePath()));
								} catch (UnsupportedTagException
										| InvalidDataException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
	                         if(!actvplaylist.equals("Library"))   {
	                            Playlist.addtoplaylist(actvplaylist,Playlist.getid(files[i].getName()));
	                         }
	                         System.out.println("working-----------------");
	                         model.setRowCount(0);
	                         String rowdata[][];
	                         if(!actvplaylist.equals("Library"))   {
	                        rowdata=Playlist.getSongs(actvplaylist);
	                        }
	                         else{
	                        	 rowdata=Jdbc.jdbc2();
	                         }
	                        for(int m=0;m<rowdata.length;m++){
	                        	 model.addRow(rowdata[m]);}System.out.println("left");
	          table.revalidate();
	                table.repaint();
	                        }
	                        
	                    String location= files[0].getAbsolutePath();
	                    String filename= files[0].getName();  
	                    System.out.println(files[0].getName());
	                    System.out.println(files[0].getAbsolutePath());
	                    
	 
	                      } 
	                  });   
	        }
	        
	//-------------------------------------------------------------
	        
	        
	        //	        listbox.setDragEnabled(true);
//	        tree.setTransferHandler(new TransferHandler("text"));
//	        listbox.setTransferHandler(new TransferHandler("text"));
//	        MouseListener listener = new DragMouseAdapter();
//	        
//	        DragSource ds = new DragSource(listbox, DND.DROP_MOVE);
//	        ds.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//	        ds.addDragListener(new DragSourceAdapter() {
//	          public void dragSetData(DragSourceEvent event) {
//	            // Set the data to be the first selected item's text
//	            event.data = listbox.getSelectedValue();
//	          }
//	        });
//	        DropTarget dt = new DropTarget(tree, DND.DROP_MOVE);
//	        dt.setTransfer(new Transfer[] { TextTransfer.getInstance() });
//	        dt.addDropListener(new DropTargetAdapter() {
//	          public void drop(DropTargetEvent event) {
//	            // Set the buttons text to be the text being dropped
//	            tree.getDropLocation();
//	          }
//	        });
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        
	        //---------------------------------------------------------------
	        
	
	
	private void addKeyListener(ActionListener actionListener) {
	// TODO Auto-generated method stub
	
	}

	public static void refreshplaylist(){
	//TreePath path=tree.getPathForRow(1);
	
	
	tree.setModel(CreateTree.getmodel());
	((DefaultTreeModel) tree.getModel()).reload();
	expandAll(tree);
	//	tree.setExpandedState(path, true);
	//(DefautreeltTree
	//tree.invalidate();
tree.validate();
tree.repaint();
	tree.updateUI();
	tree.validate();
	tree.repaint();
	
	}
	        public static void columnselection(){
	        	 if(cols[0]){
	                 System.out.println("if true"+cols[0]);
	        		 m31.setSelected(true);}
	        	 else{  System.out.println("if false"+cols[0]); 
	        		 m31.setSelected(false);}
	                if(cols[1]){
	                    m32.setSelected(true);}
	                else{ m32.setSelected(false);}
	                if(cols[2]){
	                    m33.setSelected(true);} else{ m33.setSelected(false);}
	                if(cols[3]){
	                    m34.setSelected(true);} else{ m34.setSelected(false);}
	                if(cols[4]){
	                    m35.setSelected(true);} else{ m35.setSelected(false);}
	        }
	
	public void setVolume(int fps) {

	// TODO Auto-generated method stub

	javax.sound.sampled.Mixer.Info[] mixers = AudioSystem.getMixerInfo();

	Mixer.Info mixerInfo = mixers[4];

	    Mixer mixer = AudioSystem.getMixer(mixerInfo);

	    Line.Info[] lineinfos = mixer.getTargetLineInfo();

	try {

	 Line line = mixer.getLine(lineinfos[0]);

	            line.open();

	            if(line.isControlSupported(FloatControl.Type.VOLUME)){

	            	FloatControl control = (FloatControl) line.getControl(FloatControl.Type.VOLUME);

	            	control.setValue((float) 0.6);

	                int value = (int) (control.getValue()*100);  

	                System.out.println("control.getMinimum()*100 "+ control.getMinimum()*100

	                	+"control.getMaximum()*100 "+control.getMaximum()*100+"Value "+value);

	                control.setValue((float) (fps/100f));

	System.out.println("fps setVolume "+fps);

	//theSoundPlayer.setGain(fps);

	   } 

	}catch (LineUnavailableException e) {

	            e.printStackTrace();}

	        }

	      public static void refreshlist(String text){
	        
                  model.setRowCount(0);
	              String rowdata[][]=Playlist.getSongs(text);
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
	   	     { model.addRow(rowdata[o]);}
	  table.revalidate();
	  table.repaint();
	}
	      public static void refreshlibrary(){
	    	  model.setRowCount(0);
	              String rowdata[][]=Jdbc.jdbc2();
	        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
	        for(int o=0;o<rowdata.length;o++)
	   	     { model.addRow(rowdata[o]);}
	  table.revalidate();
	  table.repaint();
	}
	      public static void refreshjmenu(){
	    	  
	    	  jmenulist1.removeAll();
	    	  final ArrayList submenu=Playlist.getPlaylists();
	    	  for(k=0;k<submenu.size();k++)
	    	  {
	    	  final JMenuItem ex=new JMenuItem(submenu.get(k).toString());
	    	  ex.addActionListener(
	    	      new ActionListener() {
	    	         public void actionPerformed( ActionEvent e ){ 	
	    	     JMenuItem m=(JMenuItem) e.getSource();
	    	System.out.println(m);	
	    	System.out.println(m.getText());	
	    	Playlist.addtoplaylist(m.getText(),Playlist.getid(songtoadd));
	    	
	    	         }});
	    	       jmenulist1.add(ex);
	    	       jmenulist1.repaint();
	    	  }}
	    	  public static void refreshcontrols(){
	    	  
	    	  plrc1.removeAll();
	    	
	    	  for(k=0;k<recent.size();k++)
	    	  {
	    	  final MenuItem ex=new MenuItem(recent.get(k).toString());
	    	  ex.addActionListener(
	    	      new ActionListener() {
	    	         public void actionPerformed( ActionEvent e ){ 	
	    	        	 MenuItem m=(MenuItem) e.getSource();
	    	System.out.println(m);	
	    	System.out.println(m.getLabel());
	    	        	 value=m.getLabel();
	    	             for(int rs=0;rs<rowdata.length;rs++){
	    	            	 if(rowdata[rs][0].equals(value)){
	    	            		 selectionModel.setSelectionInterval(rs, rs);
	    	            	 }
	    	             }
	    	        	 Stop.stop();
	    	             isplaying=1;
	    	        	 Abc a=new Abc();
	                                 
	                                 a.play();
	                                 
	                                 System.out.println("length:"+recent.size());
	                             	 System.out.println(recent.size());
	                          	   refreshcontrols();

	    	         }});
	    	       plrc1.add(ex);
	    	     
	    	  }
	    	  }
	    	  
	    	  static ID3v2 getTagInfo(String currentFileOrURL2) throws UnsupportedTagException, InvalidDataException {

	  	    	// TODO Auto-generated method stub

	  	    	Mp3File mp3file;

	  	    	 ID3v2 id3v1Tag =null;

	  	    	try {

	  	    	mp3file = new Mp3File(currentFileOrURL2);
	  	    	
	  	    	//ID3v1 id3v1=mp3file.getID3v1Tag();

	  	    	//AbstractID3v2 id3v2=mp3file.getID3v2Tag();

	  	    	//id3v2.

	  	    	//System.out.println(id3v1.getSize());

	  	    	if (mp3file.hasId3v2Tag()) {
	  //
//	  	    	   id3v1Tag = mp3file.getID3v1Tag();
	  	    	   id3v1Tag = mp3file.getId3v2Tag();
	  	    	//  System.out.println("Track: " + id3v1Tag.getTrack());

	  	    	  System.out.println("Artist: " + id3v1Tag.getArtist());

	  	    	  System.out.println("Title: " + id3v1Tag.getTitle());

	  	    	  System.out.println("Album: " + id3v1Tag.getAlbum());

	  	    	  System.out.println("Year: " + id3v1Tag.getYear());

	  	    	  System.out.println("Genre: " +  id3v1Tag.getGenreDescription());// + " (" + id3v1Tag.getGenreDescription() + ")");

	  	    	  System.out.println("Comment: " + id3v1Tag.getComment());

	  	    	  //id3v1Tag.getSongGenre();

	  	    	  

	  	    	  

	  	    	}

	  	    	} catch (IOException e) {

	  	    	// TODO Auto-generated catch block

	  	    	e.printStackTrace();

	  	    	}
	  	    	return id3v1Tag;

	  	    	}
	      public static void expandAll(JTree tree) {
	    	    int rows = 0;
	    	    while (rows < tree.getRowCount()) {
	    	      tree.expandRow(rows);
	    	      rows++;
	    	      }
	    	    }

	private void openFile() throws IOException, ID3ReadException
	{      
	   JFileChooser fileChooser = new JFileChooser();

	   fileChooser.setFileSelectionMode(
	      JFileChooser.FILES_ONLY );
	   int result = fileChooser.showOpenDialog( this );

	   // user clicked Cancel button on dialog
	   if ( result == JFileChooser.CANCEL_OPTION )
	      file = null;
	   else{
	      file = fileChooser.getSelectedFile();
	      
	      Debug.debug();
	Debug.debug("file",file);

	String fileName =file.getName();     
	System.out.println(file.getName());
	 System.out.println(file.getAbsolutePath());
//	
//	MP3File song = new MP3File(file);
//	 System.out.println(file.getAbsolutePath());
//	MusicMetadataSet src_set = new MyID3().read(file); // read metadata
//	 System.out.println(file.getAbsolutePath());
//	
//	 
//	 
//	if (song.hasID3v2Tag()){
//	     ID3v2_2 id3v2tag = (ID3v2_2) song.getID3v2Tag();
//	     IMusicMetadata metadata = src_set.getSimplified();
//	     String artist = metadata.getArtist();  
//	     String album = metadata.getAlbum();  
//	     String song_title = metadata.getSongTitle(); 
//	   System.out.println(artist);
//	   System.out.println(album);
//	   System.out.println(song_title);
	   System.out.println(file.getAbsolutePath());
	}
	
	   }
	
	// Main entry point for this example
	public static void main( String args[] )
	{
	// Create an instance of the test application
	List mainFrame= new List();
	
	mainFrame.setVisible( true );

	}
	//----------------------------------------------------------------------------------
	 
	}
class MyTimerActionListener implements ActionListener {
	  public void actionPerformed(ActionEvent e) {
	
		  List.pval=(int)((Play.time/1000));
	  List.tm=(List.tm+List.pval);
System.out.println("'''''''''''''''''''''''''''''"+Play.time);
	    System.out.println("asdf"+ "List");
//List.omg1=(int) (List.omg1+1000/List.pval);
	    List.omg1=List.omg1+1;
float temp=(List.omg1+1000/List.pval)%1;
//if(temp>0.5){List.omg1=List.omg1+1;}
System.out.println(List.pval);
System.out.println(List.pbar.getMaximum());
System.out.println(List.pbar.getMinimum());
List.pbar.setValue((int)List.omg1);
//List.omg1=List.omg1+temp;
if(List.inc<(Play.time/1000)){
List.inc++;

if(List.inc<10){
	  List.clock1.setText("00:00:0"+(int)List.inc);
	  
}
else if(List.inc>=10&&List.inc<60){
	  List.clock1.setText("00:00:"+(int)List.inc);
	  
	  
}
else if(List.inc>=60&&List.inc<3600){
	  int min=(int)List.inc/60;
	  float sec=List.inc%60;
	  if(sec<10){
	  List.clock1.setText("00:"+min+":0"+(int)sec);
	  }
	  else{
	  List.clock1.setText("00:"+min+":"+(int)sec);
	  }
}
System.out.println("-------------------------"+List.dec);
if(List.dec>0){
List.dec--;

if(List.dec<10){
	  List.clock2.setText("00:00:0"+(int)List.dec);
	  
}
else if(List.dec>=10&&List.dec<60){
	  List.clock2.setText("00:00:"+(int)List.dec);
	  
	  
}
else if(List.dec>=60){
	  int min=(int)List.dec/60;
	  float sec=List.dec%60;
	  if(sec<10){
	  List.clock2.setText("00:"+min+":0"+(int)sec);
	  }
	  else{
	  List.clock2.setText("00:"+min+":"+(int)sec);
	  }
}}
}

}
	
	  }