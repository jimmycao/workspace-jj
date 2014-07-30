package cn.jimmy.sandbox.basic.str;

public class StrMatch {
	public static void main(String[] args) {
		String str1 = "abcde";
		System.out.println(str1.matches("^ab"));
		//str2 is only one char which is one of "[123]"
		String str2 = "2";
		System.out.println(str2.matches("[123]"));
		
		//����������������������������������������
		//����LikeType������������������patten��������������������sourceStr������������������sourceStr��������LikeType������������
		String likeType = "23";
		String pattern = "[a-zA-Z0-9]*[" + likeType + "]{1}[a-zA-Z0-9]*";
		String sourceStr = "adfjaslfj23ldfalsf";
		System.out.println(sourceStr.matches(pattern)); 
		//����������������������������������,������������������������������
		 String sourceStr2 = "423236664";
		 String pattern2 = "%%%23%%%*";
		 pattern2 = pattern2.replaceAll("%", "\\\\d").replaceAll("\\*", "\\\\d\\*");
		 System.out.println(pattern2);
		 System.out.println(sourceStr2.matches(pattern2)); 
	}
}
