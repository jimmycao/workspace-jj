package cn.jimmy.tools.junit.old;

import org.junit.Test;

public class JunitTest4 {
	@Test(timeout = 1000)
	public void infinity() {
		while (true);
	}
}
