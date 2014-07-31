package cn.jimmy.sandbox.coll.array;

import java.util.Arrays;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * 
Either use Arrays.toString() or:

StringBuilder builder = new StringBuilder();
for(String s : arr) {
    builder.append(s);
}
return builder.toString();

You can modify the above depending on what characters, if any, you want in between strings.

You may also see near identical code to the above but using StringBuffer - StringBuilder is 
a newer class that's not thread-safe, but therefore has better performance in a single 
thread because it does away with unneeded synchronization. In short, you're better using 
StringBuilder in 99% of cases.

DON'T use a string and just append to it with += like some of the answers show here. 
This sends the GC through the roof because you're creating and throwing away as many 
string objects as you have items in your array. For small arrays you might not really 
notice the difference, but for large ones it's orders of magnitude slower.
 * @author caoj7
 *
 */
public class StringArrayToString {

	public static String useStringBuffer(String[] strArray) {
		//StringBuffer
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < strArray.length; i++) {
			if (0 != i) 
				sb.append(" ");
			sb.append(strArray[i]);
		}
		
		return sb.toString();
	}
	
	
	public static String useStringBuilder(String[] strArray) {
		//**StringBuilder
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strArray.length; i++) {
			if (0 != i)
				sb.append(" ");
			sb.append(strArray[i]);
		}
		
		return sb.toString();
	}
	
	public static String useStringUtils(String[] strArray) {
		//StringUtils.join
		return StringUtils.join(strArray, ' ');
	}
	
	
	public static void main(String[] args) {
		String[] strArray = new String[] {"HUST", "XJTU", "TSINGHUA", "PEIKING"};
		System.out.println(Arrays.toString(strArray));
		System.out.println(StringArrayToString.useStringBuffer(strArray));
		System.out.println(StringArrayToString.useStringBuilder(strArray));
		System.out.println(StringArrayToString.useStringUtils(strArray));
		
	}

}

