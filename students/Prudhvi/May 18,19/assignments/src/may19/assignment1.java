package may19;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class assignment1  {
	static AtomicInteger a = new AtomicInteger(0);
	

	public static void main(String[] args) throws InterruptedException {

		Runnable p1 = ()->{try { Thread.sleep(200);
		      File myObj = new File("resources\\input.txt");
		      Scanner myReader = new Scanner(myObj);
		        String str = myReader.nextLine();
		        String[] res = str.split("[,]", 0);
		        int sum = 0;
		        int id = (int) (Thread.currentThread().getId()%3);
		        for(int i=id*1000;i<(id+1)*1000;i++) {
		           sum = sum+ Integer.parseInt(res[i]);
		        }
		        //System.out.println(sum);
		        
		      
		      a.addAndGet(sum);
		      
		      
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}};

		    
		     Thread t1 = new Thread(p1);
		     Thread t2 = new Thread(p1);
		     Thread t3 = new Thread(p1);
		    t1.start();
		    t2.start();
		    t3.start();
		    t1.join();
		    t2.join();
		    t3.join();
		    System.out.println(a.get());
		    
		    FileWriter filewrite;
			try {
				filewrite = new FileWriter("resources\\output.txt");
				filewrite.write(Integer.toString(a.get()));
				filewrite.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		
		

	}
	

}
