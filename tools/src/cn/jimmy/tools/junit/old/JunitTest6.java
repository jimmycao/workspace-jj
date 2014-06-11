package cn.jimmy.tools.junit.old;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Junit Parameterized Test
 * @author caoj7
 * 
 * The “Parameterized Test” means vary parameter value for unit test. In JUnit, 
 * both @RunWith and @Parameter annotation are use to provide parameter value for 
 * unit test, @Parameters have to return List[], and the parameter will pass into 
 * class constructor as argument.
 *
 * It has many limitations here; you have to follow the “JUnit” way to declare 
 * the parameter, and the parameter has to pass into constructor in order to 
 * initialize the class member as parameter value for testing. The return type 
 * of parameter class is “List []”, data type has been limited to String or 
 * primitive value.
 */
@RunWith(value = Parameterized.class)
public class JunitTest6 {
	private int number;
	
	public JunitTest6(int number) {
		this.number = number;
	}
	
	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {{1}, {2}, {3}, {4}};
		return Arrays.asList(data);
 	}
	
	@Test 
	public void pushTest() {
		System.out.println("Parameterized Number is : " + this.number);
	}
}
