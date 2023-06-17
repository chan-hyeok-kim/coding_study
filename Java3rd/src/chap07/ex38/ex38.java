package chap07.ex38;

import java.awt.*;
import java.awt.event.*;

class ex38 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new ActionListener() {
	        public void actionPerforemd(ActionEvent e) {
		        System.out.println("ActionEvent occurred!!!");
	        } 
        }  
	    );
	}
}
