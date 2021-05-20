package assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student6 {
    int id;
    String name;

    Student6(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student6{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

}

public class Test1Comparator {


    public static void main(String args[]){
    	List<Student6> mylist = new ArrayList<Student6>();
    	mylist.add(new Student6(106,"Rohan"));
    	mylist.add(new Student6(105,"Sankalp"));
    	mylist.add(new Student6(101,"Suraj"));
    	mylist.add(new Student6(102,"Mohan"));
    	mylist.add(new Student6(101,"lalal"));
    	mylist.add(new Student6(104,"Soham"));
    	mylist.add(new Student6(102,"Ram"));
    	
    	
    	System.out.println(mylist);
    	
        Collections.sort(mylist, new Comparator<Student6>() {
        	@Override
            public int compare(Student6 o1, Student6 o2) {
            
                  if (o1.id != o2.id)
                      return o1.id - o2.id;
                 return (o1.name.compareTo(o2.name));
            }
        	
        });

        System.out.println(mylist);

    }
}

