package com.musicplayer;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlayExternal implements Runnable{
	String filename;
	String location;
static int a=0;
static Player mp3player2;
	public PlayExternal(String filename,String location) {
this.location=location;
this.filename=filename;
		
}
	public void run() {
		String song = location;
		   System.out.println(song);
		 a=1;
		   BufferedInputStream in = null;
		    try {
		    	final URL fileurl = new URL("file:///"+song);
		      in = new BufferedInputStream(fileurl.openStream());
		
		      mp3player2 = new Player(in);
		mp3player2.play();
		    } catch (MalformedURLException ex) {System.out.println("raabta1");
		    } catch (IOException e) {System.out.println("raabta2");
		    } catch (JavaLayerException e) {System.out.println("raabta3");
		    } catch (NullPointerException ex) {System.out.println("raabta4");
		    }	
		}	// TODO Auto-generated constructor stub
	}
 

