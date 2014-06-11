package cn.jimmy.tools.junit.old;

import java.io.IOException;

import org.junit.Test;

public class JunitTest2 {
	@Test (expected = ArithmeticException.class)
	public void divisionWithException() {
		int i =  1/0;
	}
	
	//will not pass
	@Test (expected = IOException.class)
	public void divisionWithException2() {
		int i =  1/0;
	}

}
