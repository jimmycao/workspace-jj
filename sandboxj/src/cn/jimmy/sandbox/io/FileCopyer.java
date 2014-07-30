package cn.jimmy.sandbox.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCopyer {
	public static void copyFile1(String sourceFilePath, String targetFilePath) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(targetFilePath));
		byte[] buffer = new byte[1024];
		int len;
		while (-1 != (len = bis.read(buffer))) {
			bos.write(buffer, 0, len);
		}
		bos.flush();
		bos.close();
		bis.close();
	}
	
	public static void copyFile2(String sourceFilePath, String targetFilePath) throws IOException {
	  BufferedReader br = new BufferedReader(new FileReader(sourceFilePath));
	  BufferedWriter bw = new BufferedWriter(new FileWriter(targetFilePath));
	  
	  String line = null;
	  while (null != (line = br.readLine())) {
	    bw.append(line).append('\n');
	  }
	  bw.flush();
	  bw.close();
	}
	
	public static void main(String[] args) throws IOException {
	  FileCopyer.copyFile1("data/create.txt", "data/create_1.txt");
	  FileCopyer.copyFile2("data/output.txt", "data/output_1.txt");
	}
}
