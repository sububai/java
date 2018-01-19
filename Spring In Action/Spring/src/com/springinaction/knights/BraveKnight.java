package com.springinaction.knights;

public class BraveKnight implements Knight {
	private Quest quest;
	
	//constructor
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}
	
	public void embarkOnQuest() {
		quest.embark();
	}
	
}
