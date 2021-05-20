package threads;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MultipleThreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int threadCnt=3;
		ExecutorService executor = Executors.newFixedThreadPool(threadCnt);
		Callable<String> callableTask = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    FileReader file=new FileReader("output.txt");
		    FileInputStream fstream = new FileInputStream("output.txt");
		    DataInputStream in = new DataInputStream(fstream);
		    BufferedReader br = new BufferedReader(new InputStreamReader(in));
		    String data  = br.readLine();
		    String[] tmp = data.split(" "); 
		    file.close(); 
		    //Split space
		    
		    FileWriter fw = new FileWriter("Thread_output.txt");
		    ArrayList<String> list=new ArrayList<String>();
		    for(String s: tmp)
		       list.add(s);
		    System.out.print(list); 
	        int sum = 0;
	        for (String i : list) {

	          int num1 = Integer. parseInt(i);
	          System.out.println(num1);
	          fw.write(Integer.toString(num1));
	          fw.write(" ");
	          sum += num1;
	         }
	         System.out.println();
	         System.out.println("sum = " + sum);
	         fw.write("sum = ");
	         fw.write(Integer.toString(sum));
	         fw.close();
	           
		    return "Writing successful";
		};
		executor.submit(callableTask);
	}

}