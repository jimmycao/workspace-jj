package cn.jimmy.sandbox.generic.wildcard;
//����  List<Employee> eList = new ArrayList<Employee>();
//�� Pair<Emplyee>��Pair<Manager>������������������������������������
//������ Pair<? extends Employee>, ��Pair<Employee>��Pair<Manager>��object������������
//������Pair<? super Manager>, ��Pair<Employee>��Pair<Manager>��object������������
public class GenericFuncitonTest {
	public static void printParentAndChildPair(Pair<? extends Employee> p){
		Employee first = p.getFirst();
		Employee second = p.getSecond();
		System.out.println(first.getName());
		System.out.println(second.getName());
	}
	
	public static void setMinMaxSalaryPair(Manager manager1, Manager manager2, Pair<? super Manager> writePair){
		if(manager1.getSalary() > manager2.getSalary()) {
			writePair.setFirst(manager2);
			writePair.setSecond(manager1);
		}else{
			writePair.setFirst(manager1);
			writePair.setSecond(manager2);
		}
	}
	
	public static void setMaxMinSalaryPair(Manager manager1, Manager manager2, Pair<? super Manager> writePair){
		setMinMaxSalaryPair(manager1, manager2, writePair);
		PairHandler.swap(writePair);
	}
	
	public static void main(String[] args) {
		Manager cao = new Manager("cao", 20000, 2010, 3, 31);
		Manager lin = new Manager("lin", 10000, 2008, 7, 31);
		Pair<Manager> mPair = new Pair<Manager>(cao, lin);
		//"Pair<Manager> mPair" can be as parameter for "Pair<? extends Employee> p" for %reading%  
		printParentAndChildPair(mPair);
		System.out.println("========================");
		setMinMaxSalaryPair(cao, lin, mPair); //Pair<? super Manager>
		printParentAndChildPair(mPair);   //Pair<? extends Employee>

		Pair<Employee> ePair = new Pair<Employee>();
		setMinMaxSalaryPair(lin, cao, ePair); //Pair<? super Manager>
		printParentAndChildPair(ePair); //Pair<? extends Employee>
		System.out.println("========================");
		Pair<Manager> maxMinPair = new Pair<Manager>();//Pair<Employee> ePair = new Pair<Employee>();������
		setMaxMinSalaryPair(cao, lin, maxMinPair);
		printParentAndChildPair(maxMinPair); //Pair<? extends Employee>
	}
}