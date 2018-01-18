package chapter11;

import java.io.Serializable;

//singleton
public class Elvis implements Serializable {
	public static final Elvis INSTANCE = new Elvis();
	private Elvis() {}
	
	private String[] favoriteSongs = 
		{ "Hound Dog" , "Heartbreak Hotel" };
	public void printFavorites () {
		System.out.println(favoriteSongs);
	}
	
	public void leaveTheBuilding() {}
	
	private Object readResolve() {
		return INSTANCE;
	}
}
