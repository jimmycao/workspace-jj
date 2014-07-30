package cn.jimmy.sandbox.basic.finalstatic;

//You use static methods in two situations:
//1. When a method doesn't need to access the object state because 
//   all needed parameters are supplied as explicit parameters (example: Math.pow)
//2. When a method only needs to access static fields of the class 
//	 (example: Employee.getNextId)

public class FinalAndStaticTest {
	//1. final : define a const variable
	private final double PPII;
	//2. static final member
	//static memeber belongs to Class, not object
	//e.g., System.out => public static final PrintStream out = . . .;
	private static final double PI = 3.14;
	public FinalAndStaticTest(double pi){
		PPII = pi;
	}
	
	public double getAreaDouble(double r){
		return PPII * r * r;
	}
	
	//3. static function
	//cannot access instance fields from a static method. 
	//But static methods can access the static fields in their class
	public static float getAreaFloat(float r){ 
		return (float)PI * r * r;
	}	
	
	public static void main(String[] args) {
		FinalAndStaticTest finalStaticTest = new FinalAndStaticTest(3.1415f);
		double rDouble = 4.1;
		double areaDouble = finalStaticTest.getAreaDouble(rDouble);
		System.out.println(areaDouble);
		
		float rFloat = 5.5f; //4. otherwise, float rFloat = (float)5.5;
		//5. both static member and static functions can be 
		//referred by ClassName.staticMember, e.g., Math.PI, Math.abs(-3.14f),Math.pow(2.0, 3.0)
		float areaFloat = FinalAndStaticTest.getAreaFloat(rFloat);
		System.out.println(areaFloat);
	}
}
