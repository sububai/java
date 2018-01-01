package ch13;

import java.applet.*;
import java.awt.*;

public class Applet2 extends Applet {
		Button b1 = new Button("Button 1");
		Button b2 = new Button("Button 2");
		public void init() {
			add(b1);
			add(b2);
		}
}
