package may17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

class Student1 {
	
	int id;
	String name;
	String ColgName = "IITD";
	
	Student1(int id,String name){
		this.id = id;
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[" +"id=" + id + ", name=" + name+"]";
	}
	
}
	

public class uniqueItems {

	public static void main(String[] args) {
		
		Student1 st = new Student1(101, "Suraj");
		Student1 st1 = new Student1(103, "John");
		Student1 st2 = new Student1(102, "Raj");
		Student1 st3 = new Student1(12, "John");
		Student1 st4 = new Student1(132, "Raj");
		
		List<Student1> mylist = new ArrayList<Student1>();
		mylist.add(st);
		mylist.add(st1);
		mylist.add(st2);	
		mylist.add(st3);
		mylist.add(st4);
		
		System.out.println(mylist);
		

	}

}
