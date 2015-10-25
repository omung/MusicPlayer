package com.musicplayer;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTree;

public class DragnDrop 
	extends JFrame implements DragGestureListener{
	 public void dragGestureRecognized(DragGestureEvent event) {
		    Cursor cursor = null;
		
		    JPanel panel = (JPanel) event.getComponent();
JList listbox=(JList)event.getComponent();
		    String str = listbox.getSelectedValue().toString();
		    if (event.getDragAction() == DnDConstants.ACTION_COPY) {
		      cursor = DragSource.DefaultCopyDrop;
		    }
		    event.startDrag(cursor, new TransferableColor(str));
		  }

		  class MyDropTargetListener extends DropTargetAdapter {
		    private DropTarget dropTarget;
	private JList listbox;
	private JTree tree;
		  
		    public MyDropTargetListener(JTree tree) {
			this.tree=tree;	// TODO Auto-generated constructor stub
			  dropTarget = new DropTarget(tree, DnDConstants.ACTION_COPY, this, true, null);
			}

			public void drop(DropTargetDropEvent event) {
		      try {
		        Transferable tr = event.getTransferable();
		        String str = (String) tr.getTransferData(TransferableColor.textFlavor);
		        if (event.isDataFlavorSupported(TransferableColor.textFlavor)) {
		          event.acceptDrop(DnDConstants.ACTION_COPY);
		          System.out.println(str);
		          event.dropComplete(true);
		          return;
		        }
		        event.rejectDrop();
		      } catch (Exception e) {
		        e.printStackTrace();
		        event.rejectDrop();
		      }
		    }
		  }

		 
		}

		class TransferableColor implements Transferable {
		  protected static DataFlavor textFlavor = new DataFlavor(String.class, "A string Object");
		  protected static DataFlavor[] supportedFlavors = { textFlavor };
		  String str;
		  public TransferableColor(String str) {
		    this.str = str;
		  }

		  public DataFlavor[] getTransferDataFlavors() {
		    return supportedFlavors;
		  }

		  public boolean isDataFlavorSupported(DataFlavor flavor) {
		    if (flavor.equals(textFlavor) || flavor.equals(DataFlavor.stringFlavor))
		      return true;
		    return false;
		  }

		  public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException {
		    if (flavor.equals(textFlavor))
		      return str;
		    else if (flavor.equals(DataFlavor.stringFlavor))
		      return str.toString();
		    else
		      throw new UnsupportedFlavorException(flavor);
		  }

}
