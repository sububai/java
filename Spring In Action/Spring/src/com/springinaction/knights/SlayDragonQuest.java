package com.springinaction.knights;

import java.io.PrintStream;

public class SlayDragonQuest implements Quest {
	
	private PrintStream stream;
	
	public SlayDragonQuest(PrintStream stream) {
		this.stream = stream;
	}
	
	@Override
	public void embark() {
		// TODO Auto-generated method stub
		stream.println("Embarking on quest to slay the dragon");
	}

}
