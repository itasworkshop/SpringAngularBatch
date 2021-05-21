package com.day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class UniqueElement {

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
		HashMap<String,Integer> hm=new HashMap<String,Integer>();
		for(Student s:st) {
			if(hm.containsKey(s.getStudentName())) {
				hm.put(s.getStudentName(), hm.get(s.getStudentName())+1);
			}else {
				hm.put(s.getStudentName(), 1);
			}
		}
		  List<Entry<String, Integer>> result = hm.entrySet() 
		          .stream() 
		          .filter(map -> map.getValue()==1) 
		          .collect(Collectors.toList());  
		  
		      System.out.println("Result: " + result);
	}

}
