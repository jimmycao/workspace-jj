package cn.jimmy.sandbox.generic.simple;

public class PairKeyValueWise extends PairKeyValue<Long, String> {
	private int year;
	
	public PairKeyValueWise(Long key, String value, int year) {
		super(key, value);
		this.year = year;
	}

	public void setYear(int year){
		this.year = year;
	}
	
	public int getYear(){
		return this.year;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PairKeyValueWise pairWise = new PairKeyValueWise(198098888L, "stone river", 1988);
		System.out.println(pairWise.getYear()+" : " + pairWise.getKey()+" : "+ pairWise.getValue());
	}
}
