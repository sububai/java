package chapter6;

import java.util.Set;

public class Text {
	//位域
	public static final int STYLE_BOLD = 1 << 0; 		// 1
	public static final int STYLE_ITALIC = 1 << 1; 		// 2
	public static final int STYLE_UNDERLINE = 1 << 2;	// 4
	public static final int STYLE_STRIKETHROUGH = 1 << 3; //8	
	//public void applyStyles(int styles) {}
	
	//EnumSet
	public enum Style { BOLD, ITALIC, UNDERLINE, STRIKETHROUGH }
	public void applyStyles(Set<Style> styles) {}
}
