package javaMay17Assign;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class Weekday {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("MONDAY");
		list.add("FRIDAY");
		list.add("WEDNESDAY");
		list.add("SUNDAY");
		list.add("TUESDAY");
		list.add("SUNDAY");
		list.add("SATURDAY");
		
		DayOfWeek dayOfWeek;		
		for(String i: list)
		{
			dayOfWeek = DayOfWeek.valueOf(i);
		
			System.out.println(dayOfWeek.getValue()+" "+ i);
		}
	}

}
