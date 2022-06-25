package D_notepad;

public class functionedit {
	mainfile m;
	 public functionedit( mainfile m) {
		  this.m=m;
	  }
	 
	 public void undo() {
		 m.um.undo();
	 }
	 
public void redo() {
		m.um.redo(); 
	 }
	 
}
