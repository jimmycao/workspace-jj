package cn.jimmy.tools.junit.old;

import java.util.ArrayList;
import java.util.Collection;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest1j {
	private Collection<String> col = null;
	
	@BeforeClass
	public static void classSetUp() {
		System.out.println("classSetUp");
	}
	
	@AfterClass
	public static void classTearDown() {
		System.out.println("classTearDown");
	}
	
	@Before
	public void setUp() {
		col = new ArrayList<String>();
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown");
	} 

	@Test
	public void emptyTest() {
		Assert.assertTrue(col.isEmpty());
		System.out.println("emptyTest");
	}
	
	@Test
	public void oneItemTest() {
		col.add("ok");
		Assert.assertEquals(1, col.size());
		System.out.println("oneItemTest");
	}
}
