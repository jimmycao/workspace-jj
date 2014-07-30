package cn.jimmy.sandbox.sys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellExecutor2 {
	public void exe(String cmd) throws IOException, InterruptedException {
		//Runtime.getRuntime().exec
		Process p = Runtime.getRuntime().exec(cmd);
		p.waitFor();
		//new BufferedReader(new InputStreamReader(p.getInputStream))
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line = null;
		while (null != (line = br.readLine())) {
			System.out.println(line);
		}
	}
	
	public static void main(String[] args) throws IOException,
			InterruptedException {
		ShellExecutor2 s = new ShellExecutor2();
		s.exe("ls -l /");
	}
}