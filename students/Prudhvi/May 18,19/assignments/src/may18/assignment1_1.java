package may18;

import java.util.ArrayList;
import java.util.List;

public class assignment1_1 {

	public static void main(String[] args) {
		students st1 = new students(102, "Suraj");
		
		students st2 = new students(103, "dheeraj");
		
		students st3 = new students(104, "teja");
		
		students st4 = new students(105, "dileep");
		
		students st5 = new students(106, "sherlock");
		
		List<students> mylist = new ArrayList<students>();
		
		mylist.add(st1);
		mylist.add(st2);
		mylist.add(st3);
		mylist.add(st3);
		mylist.add(st4);
		mylist.add(st5);
		mylist.add(st5);
		
		System.out.println(assignment1_1.findunique(mylist));
		
	}

	public static List<students> findunique(List<students> L)
	{
		List<students> uniquelist = new ArrayList<students>();
		
		int i=0;
		
		for(i=0;i<L.size();i++)
		{boolean flag = true;
			for(int j=0;j<uniquelist.size();j++)
			{
				if(L.get(i)==uniquelist.get(j))
				{
					flag = false;
				}
			}
			if(flag == true)
			{
				uniquelist.add(L.get(i));
			}

		}
		return uniquelist;
		
	}
	
}
