package cn.jimmy.tools.junit.old;

import org.junit.Assert;
import org.junit.Test;

public class TestStringArray {
	@Test
	public void testStringArray (){
		String[] expected = "Hamster mpirun".split(" ");
		String[] actual1 = {"Hamster", "mpirun"};
		Assert.assertArrayEquals(expected, actual1);
		
		String[] actual2 = {"Hamster", "mpirun"};
		Assert.assertNotSame(expected, actual2); 
	}

}
