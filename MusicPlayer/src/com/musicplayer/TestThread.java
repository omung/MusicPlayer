package com.musicplayer;

public class TestThread extends Thread {

		public void run() {
		   final long start = 0;
		   float millis =Play.time - start;
		   int seconds = (int) (millis / 1000);
		   int minutes = seconds / 60;
		   seconds     = seconds % 60;

		   if (seconds < 10) {
		      System.out.println("" + minutes + ":0" + seconds);
		   } else { System.out.println("" + minutes + ":" + seconds);            
		   }
			for(int tm=0;tm<Play.time;tm++)
			{
				System.out.println(tm);
				try {
					this.wait(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				tm=tm+1000;
			}
//		   mHandler.postAtTime(this,
//		           start + (((minutes * 60) + seconds + 1) * 1000));
		
		};
}
