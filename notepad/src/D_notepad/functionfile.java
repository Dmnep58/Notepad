package D_notepad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class functionfile {
  mainfile m;
  String filename,filelocation;
  
  public functionfile( mainfile m) {
	  this.m=m;
  }
  public void newFile() {
	  m.t.setText(" ");
	  m.frame.setTitle("D'Notepad_New");
	  filename=null;
	  filelocation=null;
  }
  
  
  
  public void open() {
	  FileDialog fd = new FileDialog(m.frame,"open",FileDialog.LOAD);
	  fd.setVisible(true);
	  
	  if(fd.getFile()!=null) {
		  filename = fd.getFile();
		  filelocation = fd.getDirectory();
		  m.frame.setTitle(filename);
	  }
	  
	  try {
		 
		  BufferedReader bd = new BufferedReader(new FileReader(filelocation + filename));
		  
		  m.t.setText("");
		  
		  String line = null;
		  
		while((line = bd.readLine()) != null) {
			  m.t.append(line+"\n");
		  }
		bd.close();
	  }
	
		  
	   catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("FILE NOT OPENED");
		
	}
  }
  
  
  public void save() {
	  
	if(filename == null) {
		saveas();
	}
	else {
		try {
			  FileWriter fw = new FileWriter(filelocation + filename);
			  fw.write(m.t.getText());
			  m.frame.setTitle(filename);
			  fw.close();
		  }
		  catch(Exception e) {
			  System.out.println("SOMETHING WENT WRONG");
		  }
	}
	 
  } 
  
  
  
public void saveas() {
	// TODO Auto-generated method stub
	  FileDialog fs = new FileDialog(m.frame,"save",FileDialog.SAVE);
	  fs.setVisible(true);
	  if(fs.getFile()!=null) {
		  filename = fs.getFile();
		  filelocation = fs.getDirectory();
		  m.frame.setTitle(filename);
	  }
	  
	  try {
		  FileWriter fw = new FileWriter(filelocation + filename);
		  fw.write(m.t.getText());
		  fw.close();
	  }
	  catch(Exception e) {
		  System.out.println("SOMETHING WENT WRONG");
	  }
}
public void exit() {
	// TODO Auto-generated method stub
	System.exit(0);
	
}
  
}
