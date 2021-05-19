package may18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assignment_1_2 {

	public static void main(String[] args) {
		
			students st1 = new students(102, "Suraj");
	
	students st2 = new students(103, "dheeraj");
	
	students st3 = new students(104, "teja");
	
	students st4 = new students(105, "dileep");
	
	students st5 = new students(106, "sherlock");
	
	List<students> mylist = new ArrayList<students>();
	
	mylist.add(st5);
	mylist.add(st2);
	mylist.add(st1);
	mylist.add(st3);
	mylist.add(st4);
	mylist.add(st1);
	
	
	System.out.println(mylist);
	
	Collections.sort(mylist);
	
	System.out.println(mylist);
	}

}
