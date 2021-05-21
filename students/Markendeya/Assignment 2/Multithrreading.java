package com.day2;

import java.io.FileReader;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Multithrreading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int threadCnt=3;
		ExecutorService executor = Executors.newFixedThreadPool(threadCnt);
		Callable<String> callableTask = () -> {
		    TimeUnit.MILLISECONDS.sleep(300);
		    FileReader fr=new FileReader("E:\\test.txt");
	          int i; 
	          int sum=0;
	          while((i=fr.read())!=-1) {  
	          System.out.print((char)i);  
	          char a=(char)i;
	          if(a!=' ') {
	        	  int num=Character.getNumericValue(a);  
	        	  sum+=num;
	          }
	          }
	          System.out.println();
	          System.out.println("sum = " + sum);
	          fr.close();   
		    return "task execution";
		};
		executor.submit(callableTask);
	}

}
