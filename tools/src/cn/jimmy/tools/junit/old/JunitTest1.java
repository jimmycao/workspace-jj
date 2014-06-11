package cn.jimmy.tools.junit.old;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest1 {
	private Collection<String> collection;
	
	@BeforeClass
	public static void oneTimeSetUp() {
		System.out.println("@BeforeClass - oneTimeSetUp");
	}
	
	@AfterClass     
	public static void OneTimeTearTown() {
		System.out.println("@AfterClass - OneTimeTearTown");
	}
	
	@Before
	public void setUp() {
		collection = new ArrayList<String>();
		System.out.println("@Before - setUp");
	}
	
	@After 
	public void tearDown() {
		System.out.println("@After - tearDown");
	}
	
	@Test
	public void testEmptyCollection() {
		Assert.assertTrue(collection.isEmpty());
		System.out.println("@Test - testEmptyCollection");
	}
	
	@Test
	public void testOneItemCollection() {
		collection.add("item_A");
		Assert.assertEquals(1, collection.size());
		System.out.println("@Test - testOneItemCollection");
	}
	

}
