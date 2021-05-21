package may19;

import java.io.*;
import java.util.Scanner;

public class assignment1  {


	public static void main(String[] args) throws InterruptedException {

		Runnable p1 = ()->{try { Thread.sleep(200);
		      File myObj = new File("D:/output.txt");
		      Scanner myReader = new Scanner(myObj);

		        String str = myReader.nextLine();
		        String[] res = str.split("[,]", 0);
		        int sum = 0;
		        for(String myStr: res) {
		           sum = sum+ Integer.parseInt(myStr);
		        }
		        System.out.println(sum);
		      
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}};
		    Runnable p2 = ()->{try {Thread.sleep(200);
			      File myObj = new File("D:/output.txt");
			      Scanner myReader = new Scanner(myObj);
			      myReader.nextLine();
			        String str = myReader.nextLine();
			        String[] res = str.split("[,]", 0);
			        int sum = 0;
			        for(String myStr: res) {
			           sum = sum+ Integer.parseInt(myStr);
			        }
			        System.out.println(sum);
			      
			      myReader.close();
			    } catch (FileNotFoundException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    } catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}};
			    Runnable p3 = ()->{try {Thread.sleep(200);
				      File myObj = new File("D:/output.txt");
				      Scanner myReader = new Scanner(myObj);
				      myReader.nextLine();
				      myReader.nextLine();
				        String str = myReader.nextLine();
				        String[] res = str.split("[,]", 0);
				        int sum = 0;
				        for(String myStr: res) {
				           sum = sum+ Integer.parseInt(myStr);
				        }
				        System.out.println(sum);
				      
				      myReader.close();
				    } catch (FileNotFoundException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    } catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}};
		    
		     Thread t1 = new Thread(p1);
		     Thread t2 = new Thread(p2);
		     Thread t3 = new Thread(p3);
		    t1.start();
		    t2.start();
		    t3.start();
		    

		
		

	}
	

}
