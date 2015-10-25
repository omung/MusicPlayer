package com.musicplayer;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Map;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.UnsupportedAudioFileException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

import org.tritonus.share.sampled.file.TAudioFileFormat;
public class Play extends Thread  {
   static String titleid3;
   int agn=0;
   
	static AdvancedPlayer mp3player;
	//BasicPlayer bplayer = new BasicPlayer();
	static int time;
static Map props;
	Play(){
	System.out.println("starting play"+List.seeking);
}
	@Override
	public void run() {
		Stop.stop();
	
	   		if(List.shfl&&!List.seeking){
	   		 String sh[][]= null;
       	  if(List.node!=null){
       	 
if(List.node.equals("Library")){  	sh= Jdbc.jdbc2();}
else{
sh= Playlist.getSongs(List.actvplaylist);
}	}	
else{
sh= Jdbc.jdbc2(); 
}ArrayList sh2= new ArrayList();
for(int z=0; z<sh.length; z++)
{
sh2.add(sh[z]);
}

List.row = 0 + (int)(Math.random()*sh.length);
System.out.println("rooooooooowwwwwwww In shuffle"+List.row);
List.value=List.table.getModel().getValueAt(List.row+1, 0).toString(); 
  List.selectionModel.setSelectionInterval(List.row+1,List.row+1);

  List.row=List.row+1;
	   		}
    		Stop.stop();
    		
		System.out.println("play running");
	PlayExternal.a=0;
	String s=Fetchpath.path();
		System.out.println(s);
		String song = s;
	   System.out.println(song);
	    BufferedInputStream in = null;
	    System.out.println("playing 1");
	    try {
	if(!List.seeking){
	    	do{List.seeked=0;
	    		 System.out.println(List.rpt);
	    	final URL fileurl = new URL("file:///"+song);
	      in = new BufferedInputStream(fileurl.openStream());
	
	      mp3player = new AdvancedPlayer(in);
//
//	      if(List.rpttemp){List.rpt=true;
//	  List.rpttemp=false;}
	      System.out.println(List.rpt);
	   // Register the front-end to low-level player events.
	  //	bplayer.addBasicPlayerListener(this);
	  	// Adds controls for front-end to low-level player.
	  	//this.setController(bplayer);
	      AudioFileFormat aff;
		//try {
			aff = AudioSystem.getAudioFileFormat(new File(song));
		
		
			props = ((TAudioFileFormat) aff).properties();
			System.out.println("Total Duration:" +getTimeLengthEstimation(props));
			time=getTimeLengthEstimation(props);
			printTotalTime(getTimeLengthEstimation(props)/1000);
			List.inc=0;
			List.dec=time/1000; 
			  List.pbar.setValue(0);
			  List.omg1=0;
			  List.tm=0;
			  List.pval=0;
			 		System.out.println("..........................."+List.rpt);
if(List.timer2!=null){
List.timer2.stop();	
}
if(OpenPlaylist.timer2!=null){
	OpenPlaylist.timer2.stop();
}
			 		if(List.timer!=null){
			  List.timer.start();}
		else if(OpenPlaylist.timer!=null){OpenPlaylist.timer.start();}
			System.out.println("Starting position"+List.startpos);
List.stopped=false;
List.pbar.setMinimum(0);
List.pbar.setMaximum(time/1000);
System.out.println("playing 2"+List.rpt+List.stopped);
			
mp3player.play();
			System.out.println("playing 2"+List.rpt+List.stopped);

			if(List.timer!=null){
				  List.timer.stop();
				  }
			else{OpenPlaylist.timer.stop();}
			  List.pbar.setValue(0);		 
				System.out.println("playing 2"+List.rpt+List.stopped);

Stop.stop();
	  	System.out.println("playing 2"+List.rpt+List.stopped);


	    }while(List.rpt);
	    if(List.shfl&!List.stopped){
	    	System.out.println("moving to shuffle"+List.stopped);
	    	Stop.stop();
	    	Abc a=new Abc();
	    	a.play();
	    }
	    
	}else{
		List.seeked++;
	if(List.rpttemp){
			
			List.rpt=true;
			List.rpttemp=false;
		}
	do{
		Stop.stop();
	
		System.out.println("running...............................................");
		final URL fileurl = new URL("file:///"+song);
	      in = new BufferedInputStream(fileurl.openStream());
	      mp3player = new AdvancedPlayer(in);
	      int frameSize = ((Integer) props.get("mp3.framesize.bytes"));

	      float fps = ((Float)props.get("mp3.framerate.fps"));
if(agn>0&&List.rpt){
	
	System.out.println("Total Duration:" +getTimeLengthEstimation(props));
	time=getTimeLengthEstimation(props);
	printTotalTime(getTimeLengthEstimation(props)/1000);
	List.inc=0;
	List.dec=time/1000; 
	  List.pbar.setValue(0);
	  List.omg1=0;
	  List.tm=0;
	  List.pval=0;
	
}

System.out.println("seeking............................."+List.rpt);
	      System.out.println("//////////////////////////////////"+fps+"//////////////"+(int)time);
	      if(List.timer!=null){
			  List.timer.stop();
			  System.out.println(List.timer);
			  List.timer2.stop();
			  List.timer2.start();}
		else{OpenPlaylist.timer.stop();
		  OpenPlaylist.timer2.stop();
		OpenPlaylist.timer2.start();}
	      mp3player.play((int) (List.startpos*fps),(int) (time/1000*fps));
			System.out.println("song over"+List.rpt+List.stopped+List.shfl);
			if(List.timer2!=null){
				// List.timer.stop();
				  List.timer2.stop();}
				//if(OpenPlaylist.timer2!=null)  OpenPlaylist.timer2.stop();}
			else{OpenPlaylist.timer2.stop();
			//  List.timer2.stop();
			}
			  List.pbar.setValue(0);
			  List.startpos=0;
			  
			
List.seeking=false;
if(List.rpt){agn++;}

	}while(List.rpt&!List.stopped);
agn=0;
	 if(List.shfl&!List.stopped){
	    System.out.println("Now noving to shuffle");
		 Stop.stop();
	    	Abc a=new Abc();
	    	a.play();
	    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}	
	    } catch (MalformedURLException ex) {System.out.println("raabta1");
	    } catch (IOException e) {System.out.println("raabta2");
	    } catch (JavaLayerException e) {System.out.println("raabta3");
	    }
	    // catch (NullPointerException ex) {System.out.println("raabta4");
	    catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
	}


		public static void seek() throws JavaLayerException, BasicPlayerException {
mp3player.play(2000, time);



System.out.println("playing 2"+List.rpt);


	
	
	}	

		
		
		//============

		

	
		

		
	
	public void progress(int bytesread, long microseconds, byte[] pcmdata, Map properties) {
		// TODO Auto-generated method stub
		/*int byteslength = -1;
		long total = -1;
		// Try to get time from playlist item.
		if (currentPlaylistItem != null) total = currentPlaylistItem.getLength();
		// If it fails then try again with JavaSound SPI.
		if (total <=0) total = (long) Math.round(getTimeLengthEstimation(audioInfo)/1000);
		// If it fails again then it might be stream => Total = -1	
		if (total <=0) total = -1;
		if (audioInfo.containsKey("audio.length.bytes"))
		{
			byteslength = ((Integer) audioInfo.get("audio.length.bytes")).intValue();			
		}
		float progress = -1.0f;
		if ((bytesread > 0) && ((byteslength > 0))) progress = bytesread*1.0f/byteslength*1.0f;	
		
		if (audioInfo.containsKey("audio.type"))
		{
			String audioformat = (String) audioInfo.get("audio.type");
			if (audioformat.equalsIgnoreCase("mp3"))
			{
				//if (properties.containsKey("mp3.position.microseconds")) secondsAmount = (long) Math.round(((Long) properties.get("mp3.position.microseconds")).longValue()/1000000);
				// Shoutcast stream title.
				if (properties.containsKey("mp3.shoutcast.metadata.StreamTitle"))
				{
					String shoutTitle = ((String) properties.get("mp3.shoutcast.metadata.StreamTitle")).trim();
					if (shoutTitle.length()>0)
					{					
						if (currentPlaylistItem != null)
						{
							String sTitle = " ("+currentPlaylistItem.getFormattedDisplayName()+")";
							if (!currentPlaylistItem.getFormattedName().equals(shoutTitle+sTitle))
							{
							
								currentPlaylistItem.setFormattedDisplayName(shoutTitle+sTitle);
													
							}											
						}
					}
				}
				// Equalizer
				
				if (total > 0) 
					secondsAmount = (long) (total*progress);
				else 
					secondsAmount = -1;
			}
			else if (audioformat.equalsIgnoreCase("wave"))
			{
				secondsAmount = (long) (total*progress);			
			}
			else
			{
				secondsAmount = (long) Math.round(microseconds/1000000);
				//equalizer.setBands(null);
			} 
		}
		else
		{
			secondsAmount = (long) Math.round(microseconds/1000000);
			//equalizer.setBands(null); 
		}		
		if (secondsAmount < 0) secondsAmount = (long) Math.round(microseconds/1000000);

		-- Display elapsed time --
		int secondD=0,second=0,minuteD=0,minute=0;
		int seconds=(int) secondsAmount; 
		int minutes=(int) Math.floor(seconds/60); 
		int hours=(int) Math.floor(minutes/60); 
		minutes=minutes-hours*60; 
		seconds=seconds-minutes*60-hours*3600;  
		if (seconds < 10)
		{
		  secondD = 0;
		  second = seconds;
		}
		else
		{
		  secondD = ((int) seconds / 10);
		  second = ((int) (seconds - (((int) seconds / 10)) * 10));
		}
		if (minutes < 10)
		{
		  minuteD = 0;
		  minute = minutes;
		}
		else
		{
		  minuteD = ((int) minutes / 10);
		  minute = ((int) (minutes - (((int) minutes / 10)) * 10));
		}
		System.out.println("hours minute second "+hours+":"+minute+":"+seconds);*/
		System.out.println("playing");
		
	}
	
	/*
	 * Print total time in hr min ss
	 * 
	 * */
	public static void printTotalTime(long milliseconds)
	{
		
		//-- Display elapsed time --
		int secondD=0,second=0,minuteD=0,minute=0;
		int seconds=(int) milliseconds; 
		int minutes=(int) Math.floor(seconds/60); 
		int hours=(int) Math.floor(minutes/60); 
		minutes=minutes-hours*60; 
		seconds=seconds-minutes*60-hours*3600;  
		if (seconds < 10)
		{
		  secondD = 0;
		  second = seconds;
		}
		else
		{
		  secondD = ((int) seconds / 10);
		  second = ((int) (seconds - (((int) seconds / 10)) * 10));
		}
		if (minutes < 10)
		{
		  minuteD = 0;
		  minute = minutes;
		}
		else
		{
		  minuteD = ((int) minutes / 10);
		  minute = ((int) (minutes - (((int) minutes / 10)) * 10));
		}
		System.out.println("hours minute second "+hours+":"+minute+":"+seconds);
		
	}
	/**
	   * Try to compute time length in milliseconds.
	   */
	  public static int getTimeLengthEstimation(Map properties)
	  {
		  int milliseconds = -1;
		  int byteslength = -1;
		  if (properties != null)
		  {
			if (properties.containsKey("audio.length.bytes"))
			{
			  byteslength = ((Integer) properties.get("audio.length.bytes")).intValue();			
			}
			if (properties.containsKey("duration"))
			{
				milliseconds = (int) (((Long) properties.get("duration")).longValue())/1000;			
			}
			else
			{
				// Try to compute duration
				int bitspersample = -1;
				int channels = -1;
				float samplerate = -1.0f;
				int framesize = -1;			 
				if (properties.containsKey("audio.samplesize.bits"))
				{
					bitspersample = ((Integer) properties.get("audio.samplesize.bits")).intValue(); 
				}
				if (properties.containsKey("audio.channels"))
				{
					channels = ((Integer) properties.get("audio.channels")).intValue(); 
				}
				if (properties.containsKey("audio.samplerate.hz"))
				{
					samplerate = ((Float) properties.get("audio.samplerate.hz")).floatValue(); 
				}
				if (properties.containsKey("audio.framesize.bytes"))
				{
					framesize = ((Integer) properties.get("audio.framesize.bytes")).intValue(); 
				}
				if (bitspersample > 0)
				{
					milliseconds = (int) (1000.0f*byteslength/(samplerate * channels * (bitspersample/8))); 
				} 
				else
				{
					milliseconds = (int)(1000.0f*byteslength/(samplerate*framesize)); 
				}			
			}
			long secondsAmount=0;
			if (properties.containsKey("mp3.position.microseconds")) 
				 secondsAmount = (long) Math.round(((Long) properties.get("mp3.position.microseconds")).longValue()/1000000);
			
			System.out.println("get total time"+secondsAmount+"   "+milliseconds);
		  }
		  return milliseconds;
	  }
	
}