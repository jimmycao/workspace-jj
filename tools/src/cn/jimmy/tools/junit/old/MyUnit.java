package cn.jimmy.tools.junit.old;

public class MyUnit {
	public String concatenate(String str1, String str2) {
			return str1 + str2;
	}

	public String[] getStringArray(String str) {
		return str.split(" ");
	}
	
	public boolean getBoolean() {
		return true;
	}
	
	public Object getObject() {
		return null;
	}
	
	public String getSameObject(String str) {
		return str;
	}
}
