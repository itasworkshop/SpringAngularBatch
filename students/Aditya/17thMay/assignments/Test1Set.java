package assignments;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

//write a program to find out the unique items in the students list

class Student7 {
    int id;
    String name;

    Student7(int id , String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
public class Test1Set {
    public static void main(String []args){
    	Set<Student7> myset = new HashSet<Student7>();
    	
        Student7 st1 = new Student7(101,"Suraj");
        Student7 st2 = new Student7(102,"Mohan");

        Student7 st3 = new Student7(103,"Lalal ");
        Student7 st4 = new Student7(104,"Lalal ");

        
        myset.add(st1);
        myset.add(st2);
        myset.add(st3);
        myset.add(st3);
        System.out.println(myset);


        
    }
}
