package com.musicplayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Fetchpath {
	static Statement stmt;
	static Connection conn;
	 static String title=List.value;
	 static String next_song;
	 static String prev_song;
static String location=null;
static int id=0;


public static String path(){
	   try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
		                   	 stmt = conn.createStatement();
	     title=List.value;
		                   	 String sql;
	      sql = "SELECT location from songs where title='"+title+"'";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	     location  = rs.getString("location");
	  
	     //Display values
	         System.out.print("title: " + location);
	       
	      }
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
return location;
	}
public static String nextSong(String title2){
	  try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
		                   	 stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT song_id from songs where title='"+title2+"'";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	 
	     id=rs.getInt("song_id");   
	     //Display values
	         System.out.print("title: " + id);
	       
	      }

	      id=id+1; 
	      System.out.println(id);
	      sql = "SELECT title from songs where song_id="+id+"";
	      ResultSet rs2 = stmt.executeQuery(sql);
int rowcount=rs2.getRow();

	      //STEP 5: Extract data from result set
	      while(rs2.next()){
	         //Retrieve by column name
	    
	     next_song=(String)rs2.getString("title");   
	     //Display values
	         System.out.print("title: " + next_song);
	      
	      }
	
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();

}catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	
	return next_song;
}
public static String prevSong(String title2){
	  try{
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
		                   	 stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT song_id from songs where title='"+title2+"'";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	 
	     id=rs.getInt("song_id");   
	     //Display values
	         System.out.print("title: " + id);
	       
	      }
	      id=id-1;
	      sql = "SELECT title from songs where song_id="+id+"";
	      ResultSet rs2 = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs2.next()){
	         //Retrieve by column name
	 
	     next_song=(String)rs2.getString("title");   
	     //Display values
	         System.out.print("title: " + next_song);
	       
	      }
	 
	      //STEP 6: Clean-up environment
	      rs.close();
	      stmt.close();
	      conn.close();
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            stmt.close();
	      }catch(SQLException se2){
	      }// nothing we can do
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	
	return next_song;
}
}
