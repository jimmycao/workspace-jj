package cn.jimmy.sandbox.basic.func;

public class VaryArgs {
	public static double getMax(double...args){
		double max = Double.MIN_VALUE;
		for(double value : args)
			max = (value > max) ? value : max;
		return max;
	}
	
	public static void main(String[] args) {
    System.out.println(VaryArgs
        .getMax(new double[] { 2.2, 1.1, 4.4, 3.3, 1.2 }));
	}
}
