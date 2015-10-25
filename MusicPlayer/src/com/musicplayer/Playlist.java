package com.musicplayer;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Playlist {
	static String[] list;
	static String[][] arr;
	static ArrayList list2=new ArrayList();
	static ArrayList list3=new ArrayList();
	static String[] att= new String[6];
	static String[][] btt;

	public static ArrayList getPlaylists(){
		Statement stmt = null;
		 Connection conn = null;
		 ArrayList list=new ArrayList();
	 int i=0; 
		try{
			  list.clear();
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT name from playlist";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         String title  = rs.getString("name");

	list.add(title);
		        i++;
		         //Display values
		         System.out.print("title: " + title);
		       
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
		   System.out.println("Goodbye!"+list.size());

		return list;
		}//end main
	public static String[][] getSongs(String playlist){
		Statement stmt = null;
		 Connection conn = null;
		 ArrayList list=new ArrayList();
	 int i=0; 
		try{
			  list2.clear();
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT songs from playlist where name='"+playlist+"'";
		      ResultSet rs = stmt.executeQuery(sql);
rs.next();
		      for(int l=0;l<1;l++){
		         //Retrieve by column name
		         String songs  = rs.getString("songs");
String[] arr2=songs.split(",");
for(int j=0;j<arr2.length;j++){
	 String sql2;
     sql2 = "SELECT * from songs where song_id='"+arr2[j]+"'";
     ResultSet rs2 = stmt.executeQuery(sql2);
     while(rs2.next()){
    	  //Retrieve by column name
    	  String title  = rs2.getString("title");
	         att[0]= rs2.getString("title");
	         att[1]= rs2.getString("ARTIST");
	         att[2]= rs2.getString("ALBUM");
	         att[3]= rs2.getString("YEAR");
	         att[4]= rs2.getString("GENRE");
	         att[5]= rs2.getString("COMMENT");
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
      

     }
}

	
		     
		      //STEP 6: Clean-up environment
		     
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
		   System.out.println("Goodbye!"+list.size());

		return arr;
		}//end main
	public static Boolean deleteplaylist(String name){
		   try{
			   Statement stmt = null;
				 Connection conn = null;
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		     System.out.println("name"+name);
		      sql = "delete from playlist where name='"+name+"'";
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
		   }
		   System.out.println("Goodbye!");
		return false;
		}//end main
	public static Boolean addplaylist(String name){
		   try{
			  
			   Connection conn=null;
			   Statement stmt=null;
			   Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      System.out.println(name);
		      sql = "INSERT INTO Playlist(name,songs) VALUES('"+name+"','')";
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
		   
		   }//end try
		   System.out.println("Goodbye!");
		return false;
		}
	public static int getid(String title){
		   try{
		   Connection conn=null;
		   Statement stmt=null;
		   int id = 0;
		 Class.forName("com.mysql.jdbc.Driver").newInstance();
		    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
		                   	 stmt = conn.createStatement();
	      String sql;
	      sql = "SELECT song_id from songs where title='"+title+"'";
	      ResultSet rs = stmt.executeQuery(sql);

	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	 
	     id=rs.getInt("song_id");   
	     //Display values
	         System.out.print("title: " + id);
	      }
	      return id;
	   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   
		   }//end try
		return 0;
		
	}
	public static void addtoplaylist(String playlist,int id){
		
		
		 try{
			   Connection conn=null;
			   Statement stmt=null;
			  String str="";
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			    conn =  DriverManager.getConnection("jdbc:mysql://localhost/musicplayer","root","manu");
			                   	 stmt = conn.createStatement();
		      String sql;
		      sql = "SELECT songs from playlist where name='"+playlist+"'";
		      ResultSet rs = stmt.executeQuery(sql);

		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		 
		    str=rs.getString("songs");   
		     //Display values
		         System.out.print("title: " + str);
		      }
	str=str+","+id;
	System.out.println(str);
	String sql2="update playlist set songs='"+str+"' where name ='"+playlist+"'";
	 stmt.executeUpdate(sql2);

		   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   
			   }//end try

				
	}
}
