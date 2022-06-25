package D_notepad;

import java.awt.Font;

public class functionformat {
	 mainfile m;
	Font ELEPHANT,Roman,system,Cooper;
	  String selectedFOnt;
	  public functionformat( mainfile m) {
		  this.m=m;
	  }
	  
	  public void wordWrap() {
		  if(m.wordWrapOn == false) {
			  m.wordWrapOn=true;
			  m.t.setLineWrap(true);
			  m.t.setWrapStyleWord(true);	
			  m.iWrap.setText("Word Wrap: on");
		  }
		  else if(m.wordWrapOn==true) {
			  m.wordWrapOn=false;
			  m.t.setLineWrap(false);
			  m.t.setWrapStyleWord(false);	
			  m.iWrap.setText("Word Wrap: off");
		  }
	  }
	  
	  public void createFont(int Fontsize)
	  {
		  ELEPHANT = 	new Font("ELEPHANT",Font.HANGING_BASELINE,Fontsize);
		  Roman = 	new Font("Times New Roman",Font.PLAIN,Fontsize);
		  system = new Font("System",Font.ITALIC,Fontsize);
		  Cooper = new Font("Cooper",Font.BOLD,Fontsize);
		  setfont(selectedFOnt);
	  }
	  
	  public void setfont(String FOnt) {
		  selectedFOnt=FOnt;
		 
		  switch(selectedFOnt) {
		  case "ELEPHANT":
			  m.t.setFont(ELEPHANT);
			  break;
			  
		  case "TIMES NEW ROMAN":
			  m.t.setFont(Roman);
			  break;
			  
		  case "system":
			  m.t.setFont(system);
			  break;
			  
		  case "Cooper":
			  m.t.setFont(Cooper);
			  break;
		  }
	  }
}
