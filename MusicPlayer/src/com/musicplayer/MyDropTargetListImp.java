package com.musicplayer;

import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.SystemColor;
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
import java.awt.dnd.DropTargetListener;
import java.io.IOException;
 

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


	class MyDropTargetListImp extends DropTargetAdapter
	{

private DropTarget dropTarget;
private JList listbox;

public MyDropTargetListImp(JList listbox) {
	this.listbox = listbox;

	dropTarget = new DropTarget(listbox, DnDConstants.ACTION_COPY, this,
			true, null);
}


@Override
public void drop(DropTargetDropEvent event) {
	try {
		Transferable tr = event.getTransferable();		
			event.acceptDrop(DnDConstants.ACTION_COPY);
			System.out.println("abc");
			event.dropComplete(true);
			this.listbox.validate();
			return;

	} catch (Exception e) {
		e.printStackTrace();
		event.rejectDrop();
	}
	
}

}

