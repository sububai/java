package soundsystem;

import java.util.List;

public class BlankDisc implements CompactDisc {

	private String title;
	private String artist;
	
	public BlankDisc(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing " + title + " by " + artist);
	}
 
}
