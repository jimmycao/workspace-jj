package cn.jimmy.sandbox.basic.func;

import java.util.ArrayList;
import java.util.List;

public class FilterArgs {

	public static String[] filter(String[] origin) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < origin.length; ) {
			if (origin[i].equalsIgnoreCase("-addFile") || origin[i].equalsIgnoreCase("-addArchive")) {
				i += 2;
				continue;
			}
			
			list.add(origin[i]);
			i++;
		}
		
		String[] resultArgs =  list.toArray(new String[0]);
		return resultArgs;
	} 
	
/**
 * hamster mpirun -addFile /Users/caoj7/jimmy.sh#jimmy -addFile /Users/caoj7/jim.sh#jim -addArchive /Users/caoj7/protobuf-2.5.0.zip -addArchive /Users/caoj7/xz-5.0.4.tar.gz haha	
 * @param args
 */
	public static void main(String[] args) {
	  String line = "hamster mpirun -addFile /Users/caoj7/jimmy.sh#jimmy -addFile /Users/caoj7/jim.sh#jim -addArchive /Users/caoj7/protobuf-2.5.0.zip -addArchive /Users/caoj7/xz-5.0.4.tar.gz haha";
		String[] resultArgs = FilterArgs.filter(line.split(" "));
		for (String str : resultArgs)
			System.out.println(str);
	}

}

