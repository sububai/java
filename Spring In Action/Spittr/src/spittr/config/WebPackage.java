package spittr.config;

import java.util.regex.Pattern;

import org.springframework.core.type.filter.RegexPatternTypeFilter;

public  class WebPackage extends RegexPatternTypeFilter {
	public WebPackage() {
		super(Pattern.compile("spittr\\.web"));
	}
	
}