package cn.jimmy.sandbox.basic.str;
/**
 * StringBuilder :a fast tool to manipulate String
 */
public class StrBuilder {
	public static void main(String[] args) {
		//1.StringBuilder builder = new StringBuilder();
		StringBuilder builder = new StringBuilder();
		//2. builder.append(String str)
		builder.append("my name is:");
		builder.append("caohaijun,");
		builder.append("my age is:");
		builder.append(32);
		//3. builder.toString();
		String myIntro = builder.toString();
		System.out.println(myIntro);
		//4. builder.length()
		System.out.println("builder.length = " + builder.length());
		//5. builder.substring(0,21)
		System.out.println(builder.substring(0,21));
		//6. builder.delete(21, 23)
		System.out.println(builder.delete(21, 23));
	}
}
