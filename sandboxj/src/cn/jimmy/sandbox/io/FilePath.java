package cn.jimmy.sandbox.io;

import java.io.File;
import java.io.IOException;

public class FilePath {
	public static void main(String[] args) throws IOException {
		//File.createTempFile
		File file = File.createTempFile("i-am-a-temp-file", ".txt");
		//getAbsolutePath
		String absolutePath = file.getAbsolutePath();
		System.out.println("absolutePath = " + absolutePath);
		//.lastIndexof
		System.out.println("path = " + absolutePath.substring(0, absolutePath.lastIndexOf(File.separator)));
	}

}
