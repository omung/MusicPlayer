package com.musicplayer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.farng.mp3.id3.ID3v1;

import com.mpatric.mp3agic.ID3v2;





public class Jdbc {
	static Statement stmt;
	static Connection conn;
	static String[] list;
	static String[][] arr;
	static ArrayList list2=new ArrayList();
	static ArrayList list3=new ArrayList();
	static String[] att= new String[6];
	static int i=0;
	static String[][] btt;
	public static String[][] jdbc2(){
	   try{
		  list2.clear();
		   Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
		                   	 stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT * from songs";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String title  = rs.getString("title");
	         att[0]= rs.getString("title");
	         att[1]= rs.getString("ARTIST");
	         att[2]= rs.getString("ALBUM");
	         att[3]= rs.getString("YEAR");
	         att[4]= rs.getString("GENRE");
	         att[5]= rs.getString("COMMENT");
	        
	         System.out.println(att[1]);
	         btt=new String[1][7];
	         btt[0][0]=att[0];
	         btt[0][1]=att[1];
	         btt[0][2]=att[2];
	         btt[0][3]=att[3];
	         btt[0][4]=att[4];
	         btt[0][5]=att[5];

	         
list3.add(title);
list2.add(btt[0]);
	        i++;
	         //Display values
	         System.out.print("title: " + title);
	       
	      }
	      arr=new String[list2.size()][];
	      for(int i1=0;i1<list2.size();i1++)
	      {
	    	 arr[i1]=(String[]) list2.get(i1); 
	    	  
	      }	      
	      System.out.println(arr);
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
	   System.out.println("Goodbye!"+list2.size());
	   for(int i=0;i<list2.size();i++){System.out.println("--------------------------"+list2.get(i));}
	return arr;
	}//end main
	
	
	
	//------------------------------------------------------------------------------------------------------
	public static ArrayList jdbc(){
		   try{
			  list2.clear();
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT * from songs";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String title  = rs.getString("title");
		         att[0]= rs.getString("title");
		         att[1]= rs.getString("ARTIST");
		         att[2]= rs.getString("ALBUM");
		         att[3]= rs.getString("YEAR");
		         att[4]= rs.getString("GENRE");
		         att[5]= rs.getString("COMMENT");
		        
		         System.out.println(att[1]);
		         btt=new String[1][7];
		         btt[0][0]=att[0];
		         btt[0][1]=att[1];
		         btt[0][2]=att[2];
		         btt[0][3]=att[3];
		         btt[0][4]=att[4];
		         btt[0][5]=att[5];
		        
		      
	list3.add(rs.getString("title"));
	list2.add(btt[0]);
		        i++;
		         //Display values
		         System.out.print("title: " + title);
		       
		      }
		      arr=new String[list2.size()][];
		      for(int i1=0;i1<list2.size();i1++)
		      {
		    	 arr[i1]=(String[]) list2.get(i1); 
		    	  
		      }	      
		      System.out.println(arr);
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
		   System.out.println("Goodbye!"+list2.size());
		   for(int i=0;i<list2.size();i++){}
		return list2;
		}//end main

	//---------------------------------------------------------------------------------------------------------
	public static Boolean addsong(File file, ID3v2 id3v2){
		   try{
			   System.out.println("Artist: " + id3v2.getArtist());

		    	  System.out.println("Title: " + id3v2.getTitle());

		    	  System.out.println("Album: " + id3v2.getAlbum());

		    	  System.out.println("Year: " + id3v2.getYear());

		    	  System.out.println("Genre: " +  id3v2.getGenreDescription());// + " (" + id3v1Tag.getGenreDescription() + ")");

		    	  System.out.println("Comment: " + id3v2.getComment());

			   
			   String title = file.getName();
			   String location=file.getAbsolutePath();
			   String location2 = location.replace("\\", "/");
			   System.out.println(location2);
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "INSERT INTO SONGS(TITLE,ARTIST,ALBUM,YEAR,LOCATION,GENRE,COMMENT) VALUES('"+title+"','"+id3v2.getArtist()+"','"+id3v2.getAlbum()+"','"+id3v2.getYear()+"','"+location2+"','"+id3v2.getGenreDescription()+"','"+id3v2.getComment()+"');";
		      stmt.executeUpdate(sql);

		    
	
		      stmt.close();
		      conn.close();
		      return true;
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
		return false;
		}//end main
	public static Boolean deletesong(String title){
		   try{
		
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "delete from songs where title='"+title+"'";
		      stmt.executeUpdate(sql);

		    
	
		      stmt.close();
		      conn.close();
		      return true;
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
		return false;
		}//end main
	public static Boolean[] getColumns(){
		Boolean columns[]=new Boolean[5];
		try{
			  list2.clear();
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		    
			                   	 String sql;
		      sql = "SELECT * from columns";
		      ResultSet rs = stmt.executeQuery(sql);
int m2=0;
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		        
		         columns[m2]= rs.getBoolean("value");
		    
		        m2++;
		
		      }	      
		      System.out.println(arr);
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
		  
		return columns;
		}//end main
		
	public static void updateColumns(){
		Boolean columns[]=new Boolean[5];
		try{
			  Statement stmt1 = null;
			  Connection conn1;
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn1 =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	
			 	 stmt1 = conn1.createStatement();
			                   	 String sql;
		  for(int r=0;r<5;r++){    
	      sql = "Update columns set value="+List.cols[r]+" where id="+(r+1)+"";
		    stmt1.executeUpdate(sql);
		    System.out.println("Update columns set value="+List.cols[r]+" where id="+(r+1)+"");
		  }
		     
		     
		      
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
		  
		
		}//end main
	public static void recentsongs(){
		try{
			  Statement stmt1 = null;
			  Connection conn1;
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn1 =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	
			 	 stmt1 = conn1.createStatement();
			                   	 String sql;
		 
	      sql = "select * from recentsongs";
	      ResultSet rs = stmt1.executeQuery(sql);
	      int m2=0;
	      		      //STEP 5: Extract data from result set
	      		      while(rs.next()){
	      		         //Retrieve by column name
	      		        System.out.println("..................................................."+rs.getString("song"));
	      		        List.recent.add(rs.getString("song"));
	      		    
	      		        m2++;
	      		
	
	      
		   }}catch(SQLException se){
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
		  
		
		}//end main
		
	public static void updaterecentlyplayed(){
		Boolean columns[]=new Boolean[5];
		try{
			  Statement stmt1 = null;
			  Connection conn1;
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn1 =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	
			 	 stmt1 = conn1.createStatement();
			                   	 String sql;
		  for(int r=0;r<List.recent.size();r++){    
	      sql = "replace into recentsongs values("+(r+1)+",'"+List.recent.get(r)+"')";
		    stmt1.executeUpdate(sql);
		    System.out.println("insert or replace into recentsongs values(r+1,"+List.recent.get(r)+")");
		  }
	      
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

			  
		
		}//end main
	
	}//end FirstExample

