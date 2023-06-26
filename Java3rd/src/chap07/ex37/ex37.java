package chap07.ex37;

import java.awt.*;
import java.awt.event.*;

class ex37 {
	public static void main(String[] args) {
		Button b = new Button("Start");
		b.addActionListener(new EventHandler());
	}
}

class EventHGandler implements ActionListener {
	public void actionPerforemd(ActionEvent e) {
		System.out.println("ActionEvent occurred!!!");
	}
 }

