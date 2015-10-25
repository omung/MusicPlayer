package com.musicplayer;

import java.util.Collections;

public class Abc {
static Thread p;
static Thread pe;

	public  Abc(){
	Thread t=new Thread(new Play());
this.p=t;
	}
	public  Abc(String filename,String location){
		Thread pe=new Thread(new PlayExternal(filename,location));
	this.p=pe;
		}
	
public void play(){
	p.start();
	if(!List.shfl){
	if(List.recent.size()<10){
		List.omg++;
		System.out.println("omg"+List.omg);
		List.recent.add(List.value);  
		Collections.rotate(List.recent, 1);  
	}else{
		  List.omg++;
		  Collections.rotate(List.recent, 1);  
		List.recent.set(0,List.value); 

	  }}
	}
public void playext(){p.start();}

public static void pause(){
	if(p.isAlive()){
		System.out.println("1");
		p.suspend();
	}
	else{
		System.out.println("1");
		pe.suspend();
	
	}}
public static void resume(){
	if(p.isAlive()){p.resume();}
	else{pe.resume();}}
public static void stop(){p.destroy();}}