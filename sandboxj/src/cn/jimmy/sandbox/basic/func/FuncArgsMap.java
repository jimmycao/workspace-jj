package cn.jimmy.sandbox.basic.func;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class FuncArgsMap {

	private static void addParam(Map<String, String> map) {
		map.put("MCA_ras", "slurm");
		map.put("MCA_plm", "yarn");
		map.put("MCA_state", "hnp");
	}
	
	
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		System.out.println(map.toString());
		
		addParam(map);
		System.out.println(map.toString());
		
		Set<String> keySet = map.keySet();
		Iterator<String> it = keySet.iterator();
		while (it.hasNext())
			System.out.println(it.next());
		
		Collection<String> col = map.values();
		Iterator<String> it2 = col.iterator();
		while (it2.hasNext()) {
			System.out.println(it2.next());
		}
		
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> it3 = entrySet.iterator();
		while (it3.hasNext()) {
			Entry<String, String> entry = it3.next();
			System.out.println(entry.getKey()+":"+entry.getValue());
		}
		
	}

}
