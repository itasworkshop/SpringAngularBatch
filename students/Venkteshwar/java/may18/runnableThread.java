package may18;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class runnableThread {

	
	private int count=0;
	private int j=0;
	// Define a task, the key point
	private class MyThread extends Thread{
		String[] arr;
		@Override
		public void run() {
			try {
			BufferedReader br = new BufferedReader(new FileReader("E:\\Eclipse IDE\\helloWorld\\TestCase.txt"));
		    String line = null;
		    
		    while ((line = br.readLine()) != null) {
		      arr = line.split(",");
		      for (String str : arr) {
		        System.out.println(str);
		      }
		    }
		    br.close();
			}
			catch(Exception e)
			{}
			
			super.run();
				while(j<arr.length)
				{
					synchronized (MyThread.class) {
						if(j>=arr.length){
							return;
						}
						count+=Integer.parseInt(arr[j++]);
						try {
							Thread.sleep(10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						//System.out.println(Thread.currentThread().getName());
				        System.out.println(count);
					}
				}
		}
	}
 
	public void test1(){
		for(int i=0;i<5;i++){
			new MyThread().start();
		}
        try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        //System.out.println(count);
	}
	
	static int sum=0;
	static int k=0;
	public static void main(String[] args) throws Exception {
		
	      runnableThread ru=new runnableThread();
	      ru.test1();
	   }
}

