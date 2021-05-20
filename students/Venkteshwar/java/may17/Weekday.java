package may17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class week implements Comparable<week>{
	int id;
	String name;
	week(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	@Override
    public String toString() {
        return "id=" + id 
                + ", name=" + name;
	}
	
	@Override
	public int compareTo(week o) {
		return this.id - o.id;
	}   
}
public class Weekday {

	public static void main(String[] args) {
		
		week weekVal1 = new week(2, "Tues");
		week weekVal2 = new week(3, "Wed");
		week weekVal3 = new week(1, "Mon");
		week weekVal4 = new week(7, "Sun");
		week weekVal5 = new week(6, "Sat");
		week weekVal6 = new week(4, "Thur");
		week weekVal7 = new week(5, "Fri");
		
		List<week> mylist = new ArrayList<week>();
		
		mylist.add(weekVal1);
		mylist.add(weekVal2);
		mylist.add(weekVal3);
		mylist.add(weekVal4);
		mylist.add(weekVal5);
		mylist.add(weekVal6);
		mylist.add(weekVal7);
			
		System.out.println(mylist);
		
		Collections.sort(mylist);
		
		System.out.println(mylist);
		
	}

}
