package cn.jimmy.sandbox.sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor {
	public void exe(String cmd) throws IOException, InterruptedException {
		//Runtime.getRuntime().exec
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		//new BufferedReader(new InputStreamReader(p.getInputStream))
		BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
		BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
		
		String line = null;
		while (null != (line = bri.readLine())) {
			System.out.println(line);
		}
		while (null != (line = bre.readLine())) {
		  System.err.println(line);
		}
		/* 
		 * actually, if we hope to output the getInputStream() and getErrorStream() in realtime,
		 * we should make these two stream with the thread respectively. 
		 */
	}
	
	public static void main(String[] args) throws IOException, InterruptedException  {
		ShellExecutor s = new ShellExecutor();
		s.exe("ls -l /");
	}
}