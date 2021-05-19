package com.day1;

import java.util.ArrayList;
import java.util.Collections;

public class SortByWeekDay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Week wday1=new Week(1, "mon");
        Week wday2=new Week(2, "tues");
        Week wday3=new Week(3, "wed");
        Week wday4=new Week(4, "thurs");
        Week wday5=new Week(5, "fri");
        Week wday6=new Week(6, "satur");
        Week wday7=new Week(7, "sun");
    	ArrayList<Week> st=new ArrayList<Week>();
    	st.add(wday7);
		st.add(wday1);
		st.add(wday2);
		st.add(wday3);
		st.add(wday4);
		st.add(wday5);
		st.add(wday6);
		Collections.sort(st,(Week o1,Week o2)-> {
			return o1.getWeekOrderId()- o2.getWeekOrderId();
		});
		System.out.println(st);
	}

}
