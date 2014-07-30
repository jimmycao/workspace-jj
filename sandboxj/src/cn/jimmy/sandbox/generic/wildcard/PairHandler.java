package cn.jimmy.sandbox.generic.wildcard;

public class PairHandler {
	
	public static boolean hasNull(Pair<?> p){
		return p.getFirst() == null || p.getSecond() == null;
	}
	//����������������
	public static void swap(Pair<?> p){
		swapHelper(p);
	}
	//��������
	public static <T> void swapHelper(Pair<T> p){
		T firstTmp = p.getFirst();
		p.setFirst(p.getSecond());
		p.setSecond(firstTmp);
	}
	
	public static void main(String[] args) {
		Pair<Employee> ePair = new Pair<Employee>();
		System.out.println(PairHandler.hasNull(ePair));
		
		ePair.setFirst(new Employee("cao", 10000, 2010, 3, 31));
		ePair.setSecond(new Employee("lin", 10000, 2008, 7, 31));
		System.out.println(ePair.getFirst().getName());
		
		PairHandler.swap(ePair);
		System.out.println(ePair.getFirst().getName());
	}
}