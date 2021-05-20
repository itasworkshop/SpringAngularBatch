package may17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class compare {
    public static void main(String[] args) 
    {
        ArrayList<Student1> employees = getUnsortedEmployeeList();
         
        //Compare by first name and then last name
        Comparator<Student1> compareByName = Comparator
                                                .comparing(Student1::getId)
                                                .thenComparing(Student1::getName);
         
        Collections.sort(employees, compareByName);
         
        System.out.println(employees);
    }
 
    private static ArrayList<Student1> getUnsortedEmployeeList() 
    {
        ArrayList<Student1> list = new ArrayList<>();
        list.add( new Student1(2, "Lokesh") );
        list.add( new Student1(1, "Alex") );
        list.add( new Student1(4, "Brian") );
        list.add( new Student1(5, "Neon") );
        list.add( new Student1(3, "David") );
        list.add( new Student1(2, "Alex") );
        list.add( new Student1(6, "Brian") );
        return list;
    }
}