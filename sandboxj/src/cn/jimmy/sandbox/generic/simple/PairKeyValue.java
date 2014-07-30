package cn.jimmy.sandbox.generic.simple;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PairKeyValue<K, V extends Comparable & Serializable> {
	private K key;
	private V value;
	
	public PairKeyValue(K key, V value){
		this.key = key;
		this.value = value;
	}
	
	public void setKey(K key){
		this.key = key;
	}
	
	public void setValue(V value){
		this.value = value;
	}
	
	public K getKey(){
		return this.key;
	}
	
	public V getValue(){
		return this.value;
	}

	public static void main(String[] args) {
		List<PairKeyValue<Long, String>> pairList = new ArrayList<PairKeyValue<Long, String>>();  
 		pairList.add(new PairKeyValue<Long, String>(18706701065L, "jimmy"));
 		pairList.add(new PairKeyValue<Long, String>(18722222222L, "amao"));
 		pairList.add(new PairKeyValue<Long, String>(18755555522L, "cao"));
 		for(PairKeyValue<Long, String> e : pairList)
 			System.out.println(e.getKey() + ":" + e.getValue());
 		
 		PairKeyValue<String, Integer> p = new PairKeyValue<String, Integer>("Mother", 62);
 		// whether is object of Pair, ignore <String, Integer>
 		//or use: p instanceof Pair<?, ?>
 		if(p instanceof PairKeyValue)
 			System.out.println("true");
 		else System.out.println("false");
 		
 		PairKeyValue<String, Long> p2 = new PairKeyValue<String, Long>("Father", 63L);
 		System.out.println(p2.getClass());
 		//getClass can only get its generic class 
 		if(p.getClass() == p2.getClass())System.out.println("p.getClass() == p2.getClass()");
	}
}
