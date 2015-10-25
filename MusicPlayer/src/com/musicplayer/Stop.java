package com.musicplayer;

public class Stop {
	public static void stop(){
        try{System.out.println("");
        System.out.println(PlayExternal.a);
        if(PlayExternal.a==1)
        {
        	PlayExternal.mp3player2.close();
        }
        else{
        	System.out.println(List.rpt);
  //  List.rpt=false;
    System.out.println(List.rpt);
        Play.mp3player.close();
        List.timer.stop();
        List.timer2.stop();
             	     System.out.println(":P");
        }   
        	     System.out.println(":P");	  
        } catch (NullPointerException ex) {
        	    	System.out.println("exception in stop");System.out.println("raabta4");
        	    }}
}
