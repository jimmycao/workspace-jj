package cn.jimmy.tools.junit.old;

import org.junit.Ignore;
import org.junit.Test;

public class JunitTest3 {
	
	@Ignore ("not ready to run!")
	@Test
	public void divisionWithException() {
		System.out.println("not ready!");
	}

}
