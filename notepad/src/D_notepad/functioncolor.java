package D_notepad;

import java.awt.Color;

public class functioncolor {
	mainfile m;
	 public functioncolor( mainfile m) {
		  this.m=m;
	  }
	 
	 public void changecolor(String color) {
		 switch(color) {
		 case "green":
			 m.frame.getContentPane().setBackground(Color.green);
			 m.t.setBackground(Color.green);
			 m.t.setForeground(Color.white);
			 
			 break;
			 
		 case "Black":
			 m.frame.getContentPane().setBackground(Color.BLACK);
			 m.t.setBackground(Color.BLACK);
			 m.t.setForeground(Color.WHITE);
			 break;
			 
		 case "Blue":
			 m.frame.getContentPane().setBackground(Color.BLUE);
			 m.t.setBackground(Color.BLUE);
			 m.t.setForeground(Color.YELLOW);
			 break;
			 
		 }
	 }
}
