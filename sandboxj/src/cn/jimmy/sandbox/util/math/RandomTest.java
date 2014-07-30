package cn.jimmy.sandbox.util.math;

import java.util.Random;

public class RandomTest {
	public static void main(String[] args) {
		Random r = new Random();
		System.out.println(r.nextInt());
		System.out.println(r.nextInt(1000)); //0~1000
		System.out.println(r.nextFloat());
		System.out.println(r.nextLong());
	}
}
