package com.musicplayer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopupListener2 extends MouseAdapter {
	 public void mousePressed(MouseEvent e) {
	      showPopup(e);
	    }

	    public void mouseReleased(MouseEvent e) {
	      showPopup(e);
	    }

	    private void showPopup(MouseEvent e) {
	      if (e.isPopupTrigger()) {
	        System.out.println("?????");
	    	  OpenPlaylist.jmenulist3.show(e.getComponent(), e.getX(), e.getY());
	      }
	    }

}
