package may18;

import java.util.HashMap;
import java.util.Map;

public class weeks implements Comparable<weeks> {
	String name;
	static Map<String,Integer> weekvalue = new HashMap<String,Integer>();
	
	weeks(String name) {
		this.name = name;
		
		if(weekvalue.isEmpty())
		{
			weekvalue.put("mon",1);
			weekvalue.put("tue",2);
			weekvalue.put("wed",3);
			weekvalue.put("thu",4);
			weekvalue.put("fri",5);
			weekvalue.put("sat",6);
			weekvalue.put("sun",7);
		}
	}

	@Override
	public int compareTo(weeks o) {
		
		return weekvalue.get(this.name).compareTo(weekvalue.get(o.name));
	}
	public String toString() {
		return this.name;
	}
	
	
}
