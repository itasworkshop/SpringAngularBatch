package com.day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SortListByIdAndName {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1=new Student(101,"firstName1");
		Student s2=new Student(102,"firstName2");
		Student s3=new Student(101,"firstName1");
		Student s4=new Student(104,"firstName4");
		ArrayList<Student> st=new ArrayList<Student>();
		st.add(s1);
		st.add(s2);
		st.add(s3);
		st.add(s4);
		Collections.sort(st,(Student o1,Student o2)-> {
				  int compareByIdAndName = o1.getStudentId() - o2.getStudentId();
			        if(compareByIdAndName==0) compareByIdAndName = o1.getStudentName().compareTo(o2.getStudentName());
			        return compareByIdAndName;
			}
		);
		System.out.println(st);
	}
}
