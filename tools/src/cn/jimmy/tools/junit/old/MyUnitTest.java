package cn.jimmy.tools.junit.old;

import org.hamcrest.BaseMatcher;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;


public class MyUnitTest {
	
	@Test
	public void testConcatenate() {
		MyUnit my = new MyUnit();
		String result = my.concatenate("first", "second");
		Assert.assertEquals("firstsecond", result);
		
	}

	@Test
	public void testGetStringArray() {
		MyUnit my = new MyUnit();
		String[] result = my.getStringArray("hello world");
		String[] expected = new String[] {"hello", "world"};
		Assert.assertArrayEquals(expected, result);
	}
	
	@Test
	public void testGetBoolean() {
		MyUnit my = new MyUnit();
		Assert.assertTrue(my.getBoolean());
//		Assert.assertFalse(my.getBoolean());
	}
	
	@Test
	public void testGetObject() {
		MyUnit my = new MyUnit();
		Assert.assertNull(my.getObject());
//		Assert.assertNotNull(my.getObject());
	}
	
	@Test
	public void testGetSameObject() {
		MyUnit my = new MyUnit();
		String str = new String("String");
		Assert.assertEquals(str, my.getSameObject(str));
		Assert.assertSame(str, my.getSameObject(str));
//		Assert.assertNotSame(str, my.getSameObject(str));
	}
	
	@Test
	public void testWithMatchers() {
		Assert.assertThat(new String("123"), CoreMatchers.any(Object.class));
		Assert.assertThat("this string", CoreMatchers.is("this string"));
		Assert.assertThat(123, CoreMatchers.is(123));
		//---------------------------
		Assert.assertThat(123, CoreMatchers.not(CoreMatchers.is(456)));		
		//---------------------------
		Assert.assertThat(new String("123"), CoreMatchers.equalTo(new String("123")));
		Assert.assertThat("123", CoreMatchers.instanceOf(String.class));
		Assert.assertThat(new String("123"), CoreMatchers.notNullValue());
		Assert.assertThat(null, CoreMatchers.nullValue());
		String str1 = new String("123");
		String str2 =  str1;
		Assert.assertThat(str1, CoreMatchers.sameInstance(str2));
	}
	
	public static Matcher matches(final Object expected){
		return new BaseMatcher() {
			protected Object theExpected = expected;
			public boolean matches(Object o) {
				return theExpected.equals(o);
			}

			public void describeTo(Description description) {
				description.appendText(theExpected.toString());
			}
		};
	}
	
	
	
	
	
}
