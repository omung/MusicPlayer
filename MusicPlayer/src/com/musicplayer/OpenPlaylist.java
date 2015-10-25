package com.musicplayer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Point;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import net.iharder.dnd.FileDrop;

import org.cmc.music.common.ID3ReadException;

import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.UnsupportedTagException;


public class OpenPlaylist extends JFrame{
    JSlider slider;
    JLabel label;
    static int j=0; 
    private JPanel      topPanel;
    private JPanel      audiocontrols;
    private JPanel      listPanel;
    private JPanel      mainpanel;
    private JButton add;
    private JButton cancel;
    static JLabel clock1;
	static JLabel clock2;
	static Timer timer;
	static Timer timer2;
	//----------------------------
	static Menu control;
	MenuItem play1;
	static Menu plrc1;
	MenuItem gotocurr1;
	MenuItem nxt1;
	MenuItem prv1;
	MenuItem incvol1;
	MenuItem decvol1;
	MenuItem shuffle1;
	MenuItem repeat1;
	//-----------------------------
	static JPopupMenu jmenulist3;
	JCheckBoxMenuItem m31, m32, m33, m34, m35;
    ListSelectionModel selectionModel;
    int row;
    static JProgressBar pbar;
	JPanel pbarpanel;
	static float inc=0;
	static float dec;
	static int pval;
	static int omg1=0;
	static int tm=0;
    int col;
    private JList       listbox;
    String title=List.value;
    DefaultListModel model2 ;
    int i=0;
    MenuBar mbar;
    Menu menu,submenu;

    JPopupMenu jmenu;
	static JTable table2;
	static  DefaultTableModel model;
	 String rowdata[][];

    JMenuItem m1;
    JMenuItem m2,m3,m4,m5,m6;
    MenuItem menu1,menu2,menu3,menu4,menu5,menu6;

    public static File file;
    
    static Boolean dragged=false;
    String playlistname="";
    InputStream inputStream = null;  
      OutputStream outputStream = null;  
      JLabel listname;
public OpenPlaylist(final String playlistname){
    this.playlistname=playlistname;
    System.out.println("______________"+List.cols[0]);
    System.out.println("______________"+List.cols[1]);
    System.out.println("______________"+List.cols[2]);
    System.out.println("______________"+List.cols[3]);
    System.out.println("______________"+List.cols[4]);
    setTitle( "Musicplayer" );
    setSize( 1360, 650);
    setBackground( Color.gray );
    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    addWindowListener(new WindowAdapter() {
	      public void windowClosing(WindowEvent e) {
//	       Stop.stop();
	       Jdbc.updateColumns();
	List.columnselection();
	      }
	    });
    // Create a panel to hold all other components
    topPanel = new JPanel();
    topPanel.setLayout(new BorderLayout());
    listPanel = new JPanel();
 pbarpanel=new JPanel();
audiocontrols = new JPanel();
topPanel.add(listPanel,BorderLayout.CENTER);
mainpanel=new JPanel();
mainpanel.setLayout(new BorderLayout());
mainpanel.add(pbarpanel,BorderLayout.SOUTH);
mainpanel.add(audiocontrols,BorderLayout.NORTH);

topPanel.add(mainpanel,BorderLayout.NORTH);
        getContentPane().add( topPanel );
//-------------------------------------------listpanel------------------------------------------------------------
        
        listPanel.setLayout(new BorderLayout());
        

        
        listPanel.setBackground(Color.BLACK);
        listname=new JLabel(playlistname);
        listname.setFont(new Font("Ariel", Font.PLAIN,40)); 
        
        
        listPanel.add(listname,BorderLayout.NORTH);
     mainpanel=new JPanel();
        rowdata=Playlist.getSongs(playlistname);
        Object columnNames[] = { "title", "artist", "album", "year", "genre", "comment" };
     
       model = new DefaultTableModel(
        		rowdata, columnNames
        		
        		);
        
         table2 = new JTable(model);
        
   
         table2.setAutoCreateRowSorter(true);
  listPanel.add(new JScrollPane(table2));
  table2.scrollRectToVisible(table2.getCellRect(0, 0, true));
       
         selectionModel = 
        		  table2.getSelectionModel();
        		
        table2.addMouseListener(new MouseAdapter() {
  		
  		public void mouseClicked(MouseEvent e) {
  		    if (SwingUtilities.isRightMouseButton(e)){
  		    
  		  //songtoadd=model.getElementAt(table2.locationToIndex(e.getPoint())).toString();
  		    }
  		    else{

  			        col = table2.getSelectedColumn();  
  			        row = table2.getSelectedRow();  
  			       List.value= table2.getValueAt(row, 0).toString();
  			     System.out.println("................................."+ table2.getSelectedRow());
  			       //value= table2.getValueAt(row, 1);
  			//value = (String)(listbox.getSelectedValue());
  			title= List.value;
  			
  			System.out.println(List.value);
  		

  		}}});

        MouseListener popupListener2 = new PopupListener2();
        table2.getTableHeader().addMouseListener(popupListener2);
        
        listPanel.add(table2.getTableHeader(), BorderLayout.NORTH);
        //--------------------------------------------------------------------------------
        m31=new JCheckBoxMenuItem("Artist");
        m32=new JCheckBoxMenuItem("Album");
        m33=new JCheckBoxMenuItem("Year");
        m34=new JCheckBoxMenuItem("Genre");
        m35=new JCheckBoxMenuItem("Comment");
       if(List.cols[0]){
        m31.setSelected(true);}
       if(List.cols[1]){
           m32.setSelected(true);}
       if(List.cols[2]){
           m33.setSelected(true);}
       if(List.cols[3]){
           m34.setSelected(true);}
       if(List.cols[4]){
           m35.setSelected(true);}
        jmenulist3=new JPopupMenu();;
        jmenulist3.add(m31);
        jmenulist3.add(m32);
        jmenulist3.add(m33);
        jmenulist3.add(m34);
        jmenulist3.add(m35);
        if(List.cols[0]){
            System.out.println("ok ok");
            TableColumn column = table2.getColumnModel().getColumn(1);
            column.setMinWidth(200);
            column.setMaxWidth(200);
            column.setWidth(200);
            column.setPreferredWidth(200);
            doLayout();
            System.out.println("ok ok");
            TableColumn columnlist = List.table.getColumnModel().getColumn(1);
            column.setMinWidth(200);
            column.setMaxWidth(200);
            column.setWidth(200);
            column.setPreferredWidth(200);
            doLayout();
          
        }
      else{
           TableColumn column = table2.getColumnModel().getColumn(1);
           column.setMinWidth(0);
           column.setMaxWidth(0);
           column.setWidth(0);
           column.setPreferredWidth(0);
           doLayout();    
           TableColumn columnlist = List.table.getColumnModel().getColumn(1);
           column.setMinWidth(0);
           column.setMaxWidth(0);
           column.setWidth(0);
           column.setPreferredWidth(0);
           doLayout();    
      }
   
if(List.cols[1]){
  
       TableColumn column = table2.getColumnModel().getColumn(2);
       column.setMinWidth(200);
       column.setMaxWidth(200);
       column.setWidth(200);
       column.setPreferredWidth(200);
       doLayout();
     
   }   else{
       TableColumn column = table2.getColumnModel().getColumn(2);
       column.setMinWidth(0);
       column.setMaxWidth(0);
       column.setWidth(0);
       column.setPreferredWidth(0);
       doLayout();    
  }

if(List.cols[2]){
   
   TableColumn column = table2.getColumnModel().getColumn(3);
   column.setMinWidth(200);
   column.setMaxWidth(200);
   column.setWidth(200);
   column.setPreferredWidth(200);
   doLayout();
 
}
else{
   TableColumn column = table2.getColumnModel().getColumn(3);
  column.setMinWidth(0);
  column.setMaxWidth(0);
  column.setWidth(0);
  column.setPreferredWidth(0);
  doLayout();    
}

if(List.cols[3]){

   TableColumn column = table2.getColumnModel().getColumn(4);
   column.setMinWidth(200);
   column.setMaxWidth(200);
   column.setWidth(200);
   column.setPreferredWidth(200);
   doLayout();
 
}
else{
   TableColumn column = table2.getColumnModel().getColumn(4);
  column.setMinWidth(0);
  column.setMaxWidth(0);
  column.setWidth(0);
  column.setPreferredWidth(0);
  doLayout();    
}

if(List.cols[4]){
   
   TableColumn column = table2.getColumnModel().getColumn(5);
   column.setMinWidth(200);
   column.setMaxWidth(200);
   column.setWidth(200);
   column.setPreferredWidth(200);
   doLayout();

} 
else{
   TableColumn column = table2.getColumnModel().getColumn(5);
  column.setMinWidth(0);
  column.setMaxWidth(0);
  column.setWidth(0);
  column.setPreferredWidth(0);
  doLayout();    
}
       
m31.addActionListener( new ActionListener() {
    public void actionPerformed( ActionEvent e )
    {System.out.println("list :(");
    	if(List.cols[0]){
   	 List.cols[0]=false;
   	 TableColumn column = table2.getColumnModel().getColumn(1);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
      
        doLayout();
        List.cols[0]=false;
      	 TableColumn columnlist = List.table.getColumnModel().getColumn(1);
           columnlist.setMinWidth(0);
           columnlist.setMaxWidth(0);
           columnlist.setWidth(0);
           columnlist.setPreferredWidth(0);
         
           doLayout();
           
       
               }
    else{
   	 List.cols[0]=true;
   	 TableColumn column = table2.getColumnModel().getColumn(1);
        column.setMinWidth(200);
        column.setMaxWidth(200);
        column.setWidth(200);
        column.setPreferredWidth(200);
        doLayout();
     //   o1=1; 
        List.cols[0]=false;
     	 TableColumn columnlist = List.table.getColumnModel().getColumn(1);
     	 columnlist.setMinWidth(200);
         columnlist.setMaxWidth(200);
         columnlist.setWidth(200);
         columnlist.setPreferredWidth(200);
        
          doLayout();
    }
   }
});
m32.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e )
{if(List.cols[1]){
List.cols[1]=false;
TableColumn column = table2.getColumnModel().getColumn(2);
column.setMinWidth(0);
column.setMaxWidth(0);
column.setWidth(0);
column.setPreferredWidth(0);
doLayout(); 
List.cols[1]=false;
 TableColumn columnlist = List.table.getColumnModel().getColumn(2);
 columnlist.setMinWidth(0);
 columnlist.setMaxWidth(0);
 columnlist.setWidth(0);
 columnlist.setPreferredWidth(0);

 doLayout();
   
}
else{
	 List.cols[1]=true;
	 TableColumn column = table2.getColumnModel().getColumn(2);
   column.setMinWidth(200);
   column.setMaxWidth(200);
   column.setWidth(200);
   column.setPreferredWidth(200);
   doLayout();
  // o2=1; 
	 TableColumn columnlist = List.table.getColumnModel().getColumn(2);
 	 columnlist.setMinWidth(200);
     columnlist.setMaxWidth(200);
     columnlist.setWidth(200);
     columnlist.setPreferredWidth(200);
    
      doLayout();
   
}
}
});
m33.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e )
{if(List.cols[2]){
List.cols[2]=false;
TableColumn column = table2.getColumnModel().getColumn(3);
column.setMinWidth(0);
column.setMaxWidth(0);
column.setWidth(0);
column.setPreferredWidth(0);
doLayout();
TableColumn columnlist = List.table.getColumnModel().getColumn(3);
columnlist.setMinWidth(0);
columnlist.setMaxWidth(0);
columnlist.setWidth(0);
columnlist.setPreferredWidth(0);

doLayout();
   
}
else{
List.cols[2]=true;
TableColumn column = table2.getColumnModel().getColumn(3);
column.setMinWidth(200);
column.setMaxWidth(200);
column.setWidth(200);
column.setPreferredWidth(200);
doLayout();
//o3=1; 
TableColumn columnlist = List.table.getColumnModel().getColumn(3);
 columnlist.setMinWidth(200);
columnlist.setMaxWidth(200);
columnlist.setWidth(200);
columnlist.setPreferredWidth(200);

 doLayout();
}}
});
m34.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e )
{if(List.cols[3]){
List.cols[3]=false;
TableColumn column = table2.getColumnModel().getColumn(4);
column.setMinWidth(0);
column.setMaxWidth(0);
column.setWidth(0);
column.setPreferredWidth(0);
doLayout();  
TableColumn columnlist = List.table.getColumnModel().getColumn(4);
columnlist.setMinWidth(0);
columnlist.setMaxWidth(0);
columnlist.setWidth(0);
columnlist.setPreferredWidth(0);

doLayout();

}
else{
List.cols[3]=true;
TableColumn column = table2.getColumnModel().getColumn(4);
column.setMinWidth(200);
column.setMaxWidth(200);
column.setWidth(200);
column.setPreferredWidth(200);
doLayout();
TableColumn columnlist = List.table.getColumnModel().getColumn(4);
 columnlist.setMinWidth(200);
columnlist.setMaxWidth(200);
columnlist.setWidth(200);
columnlist.setPreferredWidth(200);

 doLayout();
}}
});
m35.addActionListener( new ActionListener() {
public void actionPerformed( ActionEvent e )
{if(List.cols[4]){
List.cols[4]=false;
TableColumn column = table2.getColumnModel().getColumn(5);
column.setMinWidth(0);
column.setMaxWidth(0);
column.setWidth(0);
column.setPreferredWidth(0);
doLayout();  
TableColumn columnlist = List.table.getColumnModel().getColumn(5);
columnlist.setMinWidth(0);
columnlist.setMaxWidth(0);
columnlist.setWidth(0);
columnlist.setPreferredWidth(0);

doLayout();
//o5=0;
}
else{
List.cols[4]=true;
TableColumn column = table2.getColumnModel().getColumn(5);
column.setMinWidth(200);
column.setMaxWidth(200);
column.setWidth(200);
column.setPreferredWidth(200);
doLayout();
TableColumn columnlist = List.table.getColumnModel().getColumn(5);
 columnlist.setMinWidth(200);
columnlist.setMaxWidth(200);
columnlist.setWidth(200);
columnlist.setPreferredWidth(200);

 doLayout();
//o5=1; 
}}
});
    
               
        //------------------------------------------------------------------------------------------------------------
 JButton play = new JButton("play");
 play.setBounds(20, 50, 20, 25);
   play.addActionListener(
      new ActionListener() {

         public void actionPerformed( ActionEvent e )
         {  
         	                      Stop.stop();
         	                      List.isplaying= 1;
         	                      row= List.rowhold;
            System.out.println("length:"+List.recent.size());
        	 System.out.println(List.recent.size());
        	
if(List.value==null){
	List.value=table2.getValueAt(0,0).toString();
	 selectionModel.addSelectionInterval(0, 0);
}
System.out.println(List.dec);
       timer= new Timer(1000, new MyTimerActionListener2());
System.out.println("int timer");
        	 Abc a=new Abc();
             a.play();
             refreshcontrols();
       doLayout();
       table2.requestFocusInWindow(); 
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
    table2.requestFocusInWindow(); 
    }  }
                  
              }
              
           );
    JButton stop = new JButton("stop");
    stop.addActionListener(
            new ActionListener() {
               public void actionPerformed( ActionEvent e ){  
              List.rpt=false;
           List.stopped=true;
                  System.out.println("stop");
                  System.out.println(Play.titleid3);
Stop.stop();
table2.requestFocusInWindow(); 
               }
            }
         );
  
   
    JButton forward = new JButton("forward");
    forward.setBounds(60, 80, 80, 25);
    forward.addActionListener(
              new ActionListener() {
                 public void actionPerformed( ActionEvent e )
                 { if(!List.rpt){ Stop.stop();
                 List.stopped=true;
                System.out.println("stopped"+row);  
if(List.shfl){    	 
String sh[][]= null;

sh= Playlist.getSongs(playlistname);

row = 0 + (int)(Math.random()*sh.length);
System.out.println("rooooooooowwwwwwww In shuffle"+row);
List.value=table2.getModel().getValueAt(row+1, 0).toString(); 
selectionModel.setSelectionInterval(row+1,row+1);
Stop.stop();
Abc a=new Abc();
a.play();
row=row+1;
table2.requestFocusInWindow(); }
else{
//    col = table.getSelectedColumn();  
   
//   	       row = table.getSelectedRow();  
     System.out.println(model.getRowCount());
    if(row+1>=model.getRowCount()){row=-1;
    
    }
   table2.getModel().getValueAt(row+1, 0); 

//   System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                 System.out.println("in forward"+title);
//                     String s=Fetchpath.nextSong(title);
 System.out.println(row);
   if(row+1>model.getRowCount()){System.out.println("mnop");}
  selectionModel.setSelectionInterval(row+1,row+1);  
   List.value= (String) table2.getModel().getValueAt(row+1, 0);
  title=List.value;
//  col = table.getSelectedColumn();  
 
// row = table.getSelectedRow();  
   Abc a=new Abc();
    System.out.println(Thread.currentThread().getName());
a.play();
row= row+1;
refreshcontrols();
table2.requestFocusInWindow(); 
}   
                 }
              }
              }
           );
    JButton rewind = new JButton("rewind");
    rewind.setBounds(140, 80, 80, 25);
    rewind.addActionListener(
              new ActionListener() {
                 public void actionPerformed( ActionEvent e )
                 { 
                	 Stop.stop();
//               col = table.getSelectedColumn();  
//   row = table.getSelectedRow();  
      System.out.println(model.getRowCount());
     if(row-1<=-1){row=model.getRowCount();}
    table2.getModel().getValueAt(row-1, 0); 
                
//                    System.out.println("in forward"+title);
//                     String s=Fetchpath.prevSong(title);
//                 List.value=s;
                  selectionModel.setSelectionInterval(row-1,row-1);  
      List.value= (String) table2.getModel().getValueAt(row-1, 0);
      title=List.value;
//      col = table.getSelectedColumn();  
	      
//      	       row = table.getSelectedRow();  
                 Abc a=new Abc();
                System.out.println(Thread.currentThread().getName());
        a.play();
        row= row-1;
        refreshcontrols();
        List.refreshcontrols();
        table2.requestFocusInWindow(); 
                 }}
           );
               
                //---------------------------------------------------------------
    clock1 = new JLabel();
	clock2 = new JLabel();
	pbar=new JProgressBar();
	  pbar.setStringPainted(true);
	  pbar.addMouseListener(new MouseAdapter() {            
      	
      	public void mouseClicked(MouseEvent e) {
      		Stop.stop();
       	 List.seeking=true;
       	 System.out.println(".......................................................................rpt");
       	 if(List.rpt){
       		List.rpttemp=true;
       		List.rpt=false;
       	 }
       		int v = pbar.getValue();
       	       System.out.println("----"+v);
       	    
       	       //Retrieves the mouse position relative to the component origin.
       	       int mouseX = e.getX();
       	      if(List.seeked==0){ timer2= new Timer(1000, new MyTimerActionListener2());}
       	       //Computes how far along the mouse is relative to the component width then multiply it by the progress bar's maximum value.
       	   List.progressBarVal = (int)Math.round(((double)mouseX / (double)pbar.getWidth()) * pbar.getMaximum());

       	       pbar.setValue(List.progressBarVal);
       	     omg1=  List.progressBarVal;
       	  //   float secs=(progressBarVal*pval)/1000;
       	     inc=List.progressBarVal;
       	  List.startpos=List.progressBarVal;
       	    	
			System.out.println("p destroyed");
       	     dec=Play.time/1000-List.progressBarVal;
       	     System.out.println("==================================="+omg1);
       	  List.seeking=true;
       	     Abc a=new Abc();
					a.play();
				
      	}                                     
      });
        pbar.setMinimum(0);
        pbar.setMaximum(1000);
  
	pbarpanel.add(clock1);
	pbarpanel.add(pbar);
	pbarpanel.add(clock2);
	///-----------------------------------------controlbar------------------------------------
	   control=new Menu("Controls");
       play1=new MenuItem("play");
       nxt1=new MenuItem("next");
       prv1=new MenuItem("previous");
    	plrc1=new Menu("Playrecent");
    	gotocurr1=new MenuItem("Go to current song");
    	incvol1=new MenuItem("increase volume");
    	decvol1=new MenuItem("Decrease Volume");
    	shuffle1=new MenuItem("shuffle");
    	repeat1=new MenuItem("repeat");
      
    	control.add(play1);
    	control.add(nxt1);
    	control.add(prv1);
    	control.add(plrc1);
    	control.add(gotocurr1);
    	control.add(incvol1);
    	control.add(decvol1);
    	control.add(gotocurr1);
        control.addSeparator();
    	control.add(shuffle1);
    	control.add(repeat1);
    	 play1.addActionListener(
                 new ActionListener() {
         
                    public void actionPerformed( ActionEvent e )
                    {  
                    	                      Stop.stop();
                    	                      
                     	                      Stop.stop();
                     	                      List.isplaying= 1;
                     	                      row= List.rowhold;
                        System.out.println("length:"+List.recent.size());
                    	 System.out.println(List.recent.size());
                    	
                    	 if(List.value==null){
                 			List.value=table2.getValueAt(0,0).toString();
                 			System.out.println("]]]]]]]]]]]]]]]]"+List.value);
                 			 selectionModel.addSelectionInterval(0, 0);
                 		}
            System.out.println(List.dec);
                   timer= new Timer(1000, new MyTimerActionListener2());
            System.out.println("int timer");
                    	 Abc a=new Abc();
                         a.play();
                  
                   doLayout();
                   refreshcontrols();
                   List.refreshcontrols();
                   table2.requestFocusInWindow(); 
                    }
                        });
               
              
               
              
               nxt1.addActionListener(
                         new ActionListener() {
                            public void actionPerformed( ActionEvent e )
                            {  Stop.stop();
                           System.out.println("stopped");  
                           
                            
    	      col = table2.getSelectedColumn();  
    	         row = table2.getSelectedRow();  
    	        System.out.println(model.getRowCount());
    	       if(row+1>=model.getRowCount()){row=-1;}
    	      table2.getModel().getValueAt(row+1, 0); 
    	   
//    	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//                            System.out.println("in forward"+title);
//                                String s=Fetchpath.nextSong(title);
    	    System.out.println(row);
    	      if(row+1>model.getRowCount()){System.out.println("mnop");}
    	     selectionModel.setSelectionInterval(row+1,row+1);  
    	      List.value= (String) table2.getModel().getValueAt(row+1, 0);
    	     title=List.value;
    	      Abc a=new Abc();
               System.out.println(Thread.currentThread().getName());
       a.play();
       refreshcontrols();
       List.refreshcontrols();
   	table2.requestFocusInWindow();
       }
                         }
                      );
               prv1.addActionListener(
                         new ActionListener() {
                            public void actionPerformed( ActionEvent e )
                            {  Stop.stop();
                          col = table2.getSelectedColumn();  
     	       row = table2.getSelectedRow();  
     	        System.out.println(model.getRowCount());
     	       if(row-1<=-1){row=model.getRowCount();}
     	      table2.getModel().getValueAt(row-1, 0); 
                           
//                               System.out.println("in forward"+title);
//                                String s=Fetchpath.prevSong(title);
//                            List.value=s;
                             selectionModel.setSelectionInterval(row-1,row-1);  
       	      List.value= (String) table2.getModel().getValueAt(row-1, 0);
       	      title=List.value;
                            Abc a=new Abc();
                           System.out.println(Thread.currentThread().getName());
                  
                           a.play();
                           refreshcontrols();
                           List.refreshcontrols();
                           table2.requestFocusInWindow();
                       	table2.requestFocusInWindow();
                            }
                            }
                      );
                
               incvol1.addActionListener(
                       new ActionListener() {
               
                          public void actionPerformed( ActionEvent e )
                          {  
                          	               setVolume(slider.getValue()+5);
                          	               slider.setValue(slider.getValue()+5);
                          	         	table2.requestFocusInWindow();
                          }
                              });
               decvol1.addActionListener(
                       new ActionListener() {
               
                          public void actionPerformed( ActionEvent e )
                          {  
                        	  setVolume(slider.getValue()-5);
             	               slider.setValue(slider.getValue()-5);
             	          	table2.requestFocusInWindow();
                          }
                              });
               shuffle1.addActionListener(
                       new ActionListener() {
               
                          public void actionPerformed( ActionEvent e )
                          {   String sh[][]= null;
    
 	    	 sh= Playlist.getSongs(playlistname);
 	   	
 	   
 	     ArrayList sh2= new ArrayList();
 	        	for(int z=0; z<sh.length; z++)
 	        	{
 	        	sh2.add(sh[z]);
 	        	}
 	        	
 	        	row = 0 + (int)(Math.random()*sh.length);
 	        	System.out.println("rooooooooowwwwwwww In shuffle"+row);
 	        	List.value=table2.getModel().getValueAt(row+1, 0).toString(); 
 	        	  selectionModel.setSelectionInterval(row+1,row+1);
 	        	Stop.stop();
 	        	  Abc a=new Abc();
 	        	  a.play();
 	        	  row=row+1;
                        	refreshcontrols();
                        	List.refreshcontrols();
                        	table2.requestFocusInWindow();
                        	 }
                              });
               repeat1.addActionListener(
                       new ActionListener() {
               
                          public void actionPerformed( ActionEvent e ){
                          System.out.println("rpt------false"+List.rpt);
                    	  if(List.rpt){
                    	  List.rpt=false;
                    	  System.out.println("rpt------true");
                    	 }
                      else{
                    	 System.out.println("rpt------false");
                    	  List.rpt=true;
                    
                      }}
                              });
               gotocurr1.addActionListener(
                       new ActionListener() {
               
                          public void actionPerformed( ActionEvent e )
                          {
                        	  table2.scrollRectToVisible(table2.getCellRect(row+1, 0, true));
                       
                          }
                              });
         
	//----------------------------------------------------------------------------------------keystrokes
    	 table2.setFocusable(true);
	        table2.requestFocusInWindow(); 
	        table2.addKeyListener(new KeyAdapter() {
	
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
	                   Stop.stop();
	                              col = table2.getSelectedColumn();  
	      	        row = table2.getSelectedRow();  
	      	        System.out.println(model.getRowCount());
	      	       if(row-1<=-1){row=model.getRowCount();}
	      	      table2.getModel().getValueAt(row-1, 0); 
	                            
//	                                System.out.println("in forward"+title);
//	                                 String s=Fetchpath.prevSong(title);
//	                             List.value=s;
	                              selectionModel.setSelectionInterval(row-1,row-1);  
	        	      List.value= (String) table2.getModel().getValueAt(row-1, 0);
	        	      title=List.value;
	                             Abc a=new Abc();
	                            System.out.println(Thread.currentThread().getName());
	                    a.play();
	                    refreshcontrols();
	                   //Call some function
	               }
	               if (key == KeyEvent.VK_SPACE)
	               {
	                   System.out.println(text + " SPACE");
	                   if(List.value==null){
                			List.value=table2.getValueAt(0,0).toString();
                			System.out.println("]]]]]]]]]]]]]]]]"+List.value);
                			 selectionModel.addSelectionInterval(0, 0);
	                   }  
	                   Stop.stop();
	   	                   timer= new Timer(1000, new MyTimerActionListener2());
	   	                      System.out.println("Value for Space Key"+List.value);;
	   	                      List.startpos=0;
	   	                      Abc a=new Abc();
	   	                        
	   	                        a.play();
	   	                        System.out.println("length:"+List.recent.size());
	   	                    	 System.out.println(List.recent.size());
	   	                 	   List.refreshcontrols();
	   	                 	   refreshcontrols();
	   	                   doLayout(); //Call some function
	               }
	               else if (key == KeyEvent.VK_KP_RIGHT && e.isControlDown()|| key == KeyEvent.VK_RIGHT && e.isControlDown())
	               {
	                   System.out.println(text + " RIGHT");
	                   Stop.stop();
	                            System.out.println("stopped");  
	                            
	                             
	     	      col = table2.getSelectedColumn();  
	     	    row = table2.getSelectedRow();  
	     	        System.out.println(model.getRowCount());
	     	       if(row+1>=model.getRowCount()){row=-1;}
	     	      table2.getModel().getValueAt(row+1, 0); 
	     	   
//	     	      System.out.println("======="+table.getModel().getValueAt(row+1, 0));
//	                             System.out.println("in forward"+title);
//	                                 String s=Fetchpath.nextSong(title);
	     	    System.out.println(row);
	     	      if(row+1>model.getRowCount()){System.out.println("mnop");}
	     	     selectionModel.setSelectionInterval(row+1,row+1);  
	     	      List.value= (String) table2.getModel().getValueAt(row+1, 0);
	     	     title=List.value;
	     	      Abc a=new Abc();
	                System.out.println(Thread.currentThread().getName());
	        a.play();
	        refreshcontrols();                                 //Call some function
	               }
	               else if (key == KeyEvent.VK_I && e.isControlDown())
	               {

      	               setVolume(slider.getValue()+5);
      	               slider.setValue(slider.getValue()+5);
      	             table2.requestFocusInWindow(); 
	               }
	               else if (key == KeyEvent.VK_D && e.isControlDown())
	               {

      	               setVolume(slider.getValue()-5);
      	               slider.setValue(slider.getValue()-5);
      	             table2.requestFocusInWindow(); 
	               }
	               else if (key == KeyEvent.VK_L && e.isControlDown())
	               {


                 	  table2.scrollRectToVisible(table2.getCellRect(row+1, 0, true));
                 	  table2.requestFocusInWindow(); 
	               }
	            }
	
	         
	
	
	         });
	      	        //--------------------------------------------------------------------------------------------
	
    	//--------------------------------------------------------------------------
                //--------------------------------Drag and drop
                JPanel  myPanel = new JPanel();
           

                slider = new JSlider(JSlider.HORIZONTAL, 0, 100,1);

                slider.setMinorTickSpacing(2);
                slider.setMajorTickSpacing(10);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);

               
                slider.setLabelTable(slider.createStandardLabels(10));

                audiocontrols.add(slider);
                label = new JLabel("Volume 20%");
                audiocontrols.add(label);
                audiocontrols.add(slider);
              slider.addChangeListener( new ChangeListener(){
            	    public void stateChanged(ChangeEvent event){
                        setVolume(slider.getValue());
                        table2.requestFocusInWindow(); 
                            }});
              
              slider.setVisible(true);
//              
                
                //----------------------------menubar------------------------
                // Create the menu bar
 mbar=new MenuBar();
                
                // Create the menu
                menu=new Menu("Menu");
                // Create the menu
                jmenu=new JPopupMenu();
                
               
                
                // Create MenuItems
                m1=new JMenuItem("Add a song");
                m2=new JMenuItem("Delete song");
                m3=new JMenuItem("Play a song not in lib");
                m4=new JMenuItem("Go to library");
                m5=new JMenuItem("exit");
             m6=new JMenuItem("Create Playlist");
                menu1=new MenuItem("Add a song");
                menu2=new MenuItem("Delete song");
                menu3=new MenuItem("Play a song not in lib");
                menu4=new MenuItem("Go to library");
                menu5=new MenuItem("exit");
                menu6= new MenuItem("Create Playlist");
            
                // Attach menu items to menu
               //menu.add(menu1);
               //menu.add(menu2);
               //menu.add(menu3);
               menu.add(menu4);
           //    menu.add(menu6);
               menu.add(menu5);
               setMenuBar(mbar);
                //jmenu.add(m1);
                //jmenu.add(m2);
               //jmenu.add(m3);
                jmenu.add(m4);
                //jmenu.add(m6);
                jmenu.add(m5);
                mbar.add(menu);
                mbar.add(control);
                menu1.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                try {
                                    openFile();
                                    Jdbc.addsong(file,List.getTagInfo(file.getAbsolutePath()));
                                } catch (IOException e1) {
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
                
                menu2.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {System.out.println(title);
                                Jdbc.deletesong(title);
                System.out.println(":p");
                
                            }
                        });
                menu3.addActionListener(
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
                                }
                                
            String location=    file.getAbsolutePath();
                    String filename=file.getName();
                
                   Abc abc=new Abc(filename,location);
                   abc.playext();
                             }}
                        }); 
                menu4.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e ){
                           Stop.stop();
                 
                            List a  = new List();
                            setVisible(false);
                            a.setVisible( true );
                             }
                          }
                       );
                menu5.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                System.exit(0);
                
                            }
                        });
                menu6.addActionListener(
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
                     jmenu.show(Me.getComponent(), Me.getX(), Me.getY());
                      }
                      }
                      });
                m1.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                try {
                                    openFile();
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                System.out.println(":p");
                
                            }
                        });
                
                m2.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {System.out.println(title);
                                Jdbc.deletesong(title);
                System.out.println(":p");
                
                            }
                        });
                m3.addActionListener(
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
                                }
                                
            String location=    file.getAbsolutePath();
                    String filename=file.getName();
                   
                    Thread playExternal= new Thread(new PlayExternal(filename, location));
                    playExternal.start();
                             }}
                        ); 
                m4.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                             
                            List a  = new List();
                            setVisible(false);
                            a.setVisible( true );
                             }
                          }
                       );
                m5.addActionListener(
                          new ActionListener() {
                             public void actionPerformed( ActionEvent e )
                             {
                                System.exit(0);
                
                            }
                        });
                m6.addActionListener(
                        new ActionListener() {
                           public void actionPerformed( ActionEvent e )
                           {
                        	   CreatePlaylist cr=new CreatePlaylist();
					 	       cr.setVisible(true);

              
                          }
                      });
                //------------------------------------------
//       add(myPanel);
                audiocontrols.add(jmenu);
                audiocontrols.add(play);
                audiocontrols.add(pause);
                audiocontrols.add(forward);
                audiocontrols.add(rewind);
                audiocontrols.add(stop);
//                new  FileDrop(listPanel, new FileDrop.Listener()
//                {   public void  filesDropped( java.io.File[] files )
//                    {  
////                  List.dragged=true;
//                   
//                        Stop.stop();
//                 System.out.println("stopping");
////              
//                      for(int i=0;i<files.length;i++){
//                          System.out.println(files[i].getName());
//                          System.out.println(files[i].getAbsolutePath());
//                          System.out.println("working-----------------1");
//                          Jdbc.addsong(files[i],List.getTagInfo(files[i].getAbsolutePath()));
//                   
//                          Playlist.addtoplaylist(playlistname,Playlist.getid(files[i].getName()));
//                       
//                       System.out.println("working-----------------");
//                       model.setRowCount(0);
//                       String rowdata[][];
//                     
//                      rowdata=Playlist.getSongs(playlistname);
//            
//                       
//                      for(int m=0;m<rowdata.length;m++){
//                      	 model.addRow(rowdata[m]);}System.out.println("left");
//				          table.revalidate();
//			                table.repaint();
//                      }
//                      
//                  String location= files[0].getAbsolutePath();
//                  String filename= files[0].getName();  
//                  System.out.println(files[0].getName());
//                  System.out.println(files[0].getAbsolutePath());
//                  
//
//                    } 
//                });  
                
                new  FileDrop(listPanel, new FileDrop.Listener()
                {   public void  filesDropped( java.io.File[] files )
                    {  
//                  List.dragged=true;
                   try{
                  
                 System.out.println("stopping");
//              
                      for(int i=0;i<files.length;i++){
                          System.out.println(files[i].getName());
                          System.out.println(files[i].getAbsolutePath());
                          Jdbc.addsong(files[i],List.getTagInfo(files[i].getAbsolutePath()));
//                        List.value=files[i].getName();
                          Playlist.addtoplaylist(playlistname,Playlist.getid(files[i].getName()));
                      }
                
                      String location= files[0].getAbsolutePath();
                  String filename= files[0].getName();  
                  System.out.println(files[0].getName());
                  System.out.println(files[0].getAbsolutePath());
                  System.out.println("working-----------------");
                  model.setRowCount(0);;
                 String rowdata[][];
                 rowdata=Playlist.getSongs(playlistname);
                 for(int m=0;m< rowdata.length;m++){
                	 model.addRow(rowdata[m]);}System.out.println("left");System.out.println("left");
			         table2.revalidate();
		                table2.repaint();
		                List.refreshlibrary();
                   }
                   catch(Exception a){
                  	 for(int o=0;o<List.songstoadd.size();o++){
							   System.out.println(List.songstoadd.get(o).toString());
							   Playlist.addtoplaylist(playlistname,Playlist.getid(List.songstoadd.get(o).toString()));   
						   }
//       		System.out.println(playlistname);
//       		System.out.println(List.songtoadd);
//       		   Playlist.addtoplaylist(playlistname,Playlist.getid(List.songtoadd));
//       					 
                  	  model.setRowCount(0);;
                      String rowdata[][];
                      rowdata=Playlist.getSongs(playlistname);
                      for(int m=0;m< rowdata.length;m++){
                     	 model.addRow(rowdata[m]);}System.out.println("left");System.out.println("left");
     			         table2.revalidate();
     		                table2.repaint();
                    } }
                });   
//
//                new  FileDrop(listbox, new FileDrop.Listener()
//                {   public void  filesDropped( java.io.File[] files )
//                    {  
////                  List.dragged=true;
//                   
//                        Stop.stop();
//                 System.out.println("stopping");
////              
//                      for(int i=0;i<files.length;i++){
//                          System.out.println(files[i].getName());
//                          System.out.println(files[i].getAbsolutePath());
//                          Jdbc.addsong(files[i]);
//                    
//                          Playlist.addtoplaylist(playlistname,Playlist.getid(files[i].getName()));
//                       
//                       model.clear();
//				         ArrayList a=Playlist.getSongs(playlistname);
//				         for(int m=0;m<a.size();m++){
//				          model.addElement(a.get(m));}System.out.println("left");
//				          listbox.revalidate();
//			                listbox.repaint();
//                      }
//                  String location= files[0].getAbsolutePath();
//                  String filename= files[0].getName();  
//                  System.out.println(files[0].getName());
//                  System.out.println(files[0].getAbsolutePath());
//                  
//
//                    } 
//                });   
//		        






             }
public static void refreshcontrols(){
	  
	  plrc1.removeAll();
	
	  for(int k=0;k<List.recent.size();k++)
	  {
	  final MenuItem ex=new MenuItem(List.recent.get(k).toString());
	  ex.addActionListener(
	      new ActionListener() {
	         public void actionPerformed( ActionEvent e ){ 	
	        	 MenuItem m=(MenuItem) e.getSource();
	System.out.println(m);	
	System.out.println(m.getLabel());
	        	 List.value=m.getLabel();
	             Stop.stop();
	        	 Abc a=new Abc();
                           
                           a.play();
                           System.out.println("length:"+List.recent.size());
                       	 System.out.println(List.recent.size());
                    	   refreshcontrols();

	         }});
	       plrc1.add(ex);}
	     
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
            private void openFile() throws IOException
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
                  
               
                    String fileName =file.getName();     
            System.out.println(file.getName());
             System.out.println(file.getAbsolutePath());

               System.out.println(file.getAbsolutePath());
            }
        
               }
            class MyTimerActionListener2 implements ActionListener {
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
          	OpenPlaylist.pbar.setValue((int)List.omg1);
          	//List.omg1=List.omg1+temp;
          	if(List.inc<(Play.time/1000)){
          	List.inc++;

          	if(List.inc<10){
          		OpenPlaylist.clock1.setText("00:00:0"+(int)List.inc);
          		  
          	}
          	else if(List.inc>=10&&List.inc<60){
          		OpenPlaylist.clock1.setText("00:00:"+(int)List.inc);
          		  
          		  
          	}
          	else if(List.inc>=60&&List.inc<3600){
          		  int min=(int)List.inc/60;
          		  float sec=List.inc%60;
          		  if(sec<10){
          			OpenPlaylist.clock1.setText("00:"+min+":0"+(int)sec);
          		  }
          		  else{
          			OpenPlaylist.clock1.setText("00:"+min+":"+(int)sec);
          		  }
          	}
          	System.out.println("-------------------------"+List.dec);
          	if(List.dec>0){
          	List.dec--;

          	if(List.dec<10){
          		OpenPlaylist.clock2.setText("00:00:0"+(int)List.dec);
          		  
          	}
          	else if(List.dec>=10&&List.dec<60){
          		  List.clock2.setText("00:00:"+(int)List.dec);
          		  
          		  
          	}
          	else if(List.dec>=60){
          		  int min=(int)List.dec/60;
          		  float sec=List.dec%60;
          		  if(sec<10){
          			OpenPlaylist.clock2.setText("00:"+min+":0"+(int)sec);
          		  }
          		  else{
          			OpenPlaylist.clock2.setText("00:"+min+":"+(int)sec);
          		  }
          	}}
          	}

          	}
            }}

