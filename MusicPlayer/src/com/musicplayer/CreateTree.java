package com.musicplayer;

import java.util.ArrayList;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class CreateTree {
	public static DefaultMutableTreeNode getroot(){
	DefaultMutableTreeNode root = new DefaultMutableTreeNode("Lists");
    //create the child nodes
    DefaultMutableTreeNode Library = new DefaultMutableTreeNode("Library");
    DefaultMutableTreeNode Playlists = new DefaultMutableTreeNode("Playlists");

Playlists = new DefaultMutableTreeNode("Playlists");
    Playlists.removeAllChildren();
    ArrayList playlist=new ArrayList<>();
  playlist=Playlist.getPlaylists();
  
  for(int i=0;i<playlist.size();i++)
  {
Playlists.add(new DefaultMutableTreeNode(playlist.get(i)));

  }
    System.out.println("......................"+Playlists.getDepth());
    root.add(Library);
    root.add(Playlists);
    return root;
	}
	public static DefaultTreeModel getmodel(){
		DefaultTreeModel   treeModel=new DefaultTreeModel(getroot());
		return treeModel;
	       
	}
}
