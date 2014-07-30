package cn.jimmy.sandbox.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class REValidator {
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";
	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private static final String HEX_PATTERN = "^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{3})$";
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	public REValidator(){
		this.pattern = Pattern.compile(USERNAME_PATTERN);
	}
	
	public boolean validate(String username) {
		this.matcher = this.pattern.matcher(username);
		return this.matcher.matches();
	}
	
	public static void main(String[] args) {
		//username
		System.out.println(Pattern.matches(USERNAME_PATTERN, "-_3stoneriver"));
		//passwd
		System.out.println(Pattern.matches(PASSWORD_PATTERN, "stoneR3@"));
		System.out.println(Pattern.matches(PASSWORD_PATTERN, "stoneR@"));
		//# then hex 6 or 3
		System.out.println(Pattern.matches(HEX_PATTERN, "#1F2A3b"));
		//
	}
}
