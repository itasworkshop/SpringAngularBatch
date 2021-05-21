package may18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class assignment1_3 {
	public static void main(String[] args) {
	weeks wk1 = new weeks("mon");
	weeks wk2 = new weeks("tue");
	weeks wk3 = new weeks("wed");
	weeks wk4 = new weeks("thu");
	weeks wk5 = new weeks("fri");
	weeks wk6 = new weeks("sat");
	weeks wk7 = new weeks("sun");
	
	List<weeks> mylist1 = new ArrayList<weeks>();
	
	mylist1.add(wk1);
	mylist1.add(wk5);
	mylist1.add(wk4);
	mylist1.add(wk3);
	mylist1.add(wk2);
	mylist1.add(wk7);
	
	
	System.out.println(mylist1);
	
	Collections.sort(mylist1);
	
	System.out.println(mylist1);
	}

}


