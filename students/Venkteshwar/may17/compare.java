package javaMay17Assign;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class compare {
    public static void main(String[] args) 
    {   
        ArrayList<Student1> list = new ArrayList<>();
        list.add( new Student1(2, "Lokesh") );
        list.add( new Student1(1, "Alex") );
        list.add( new Student1(4, "Brian") );
        list.add( new Student1(5, "Neon") );
        list.add( new Student1(3, "David") );
        list.add( new Student1(2, "Alex") );
        list.add( new Student1(6, "Brian") );

		System.out.println(list);
		
		Collections.sort(list, new Comparator<Student1>() {

			@Override
			public int compare(Student1 o1, Student1 o2) {
				if(o1.id-o2.id==0)
				{
					return o1.name.compareTo(o2.name);
				}
				
				return o1.id-o2.id;
			}	
			
		});
		System.out.println(list);
    }
 
}