package cn.jimmy.sandbox.basic.enumm;

public class EnumTest {
	private enum WeekDay {
		Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday 
	}
	
	private WeekDay day;
	
	public EnumTest(WeekDay day) {
		this.day = day;
	}
	
	public void tellHowAboutTheDay(){
		switch(day) {
			case Sunday:
					System.out.println("Great!!");
					break;
			case Monday: 
					System.out.println("A new week is comming.");
					break;
			default:
					System.out.println("soso");
					break;
		}
	}
	
	public static void main(String[] args) {
		EnumTest test = new EnumTest(WeekDay.Saturday);
		test.tellHowAboutTheDay();
	}

}
