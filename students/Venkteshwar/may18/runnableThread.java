package javaMay18Assign;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
public class runnableThread {

    private static ExecutorService tpool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws IOException
    {
    	FileInputStream fi=new FileInputStream("E:\\Eclipse IDE\\helloWorld\\TestCase.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fi));
		String data  = br.readLine();
		String[] arreglo = data.split(",");
		int summ=sumaConcurrente(arreglo);
        System.out.println(summ);

        br.close();
        fi.close();
        File file = new File("E:\\Eclipse IDE\\helloWorld\\Test.txt");
        FileWriter fr = new FileWriter(file, true);
        BufferedWriter brr = new BufferedWriter(fr);
        brr.write(String.valueOf(summ));
        brr.close();
        fr.close();
        
    }

    public static int sumaConcurrente(String[] arreglo)
    {
        AtomicInteger total = new AtomicInteger(0);

        for(int i = 0 ; i < arreglo.length; i++){

            int a = Integer.parseInt(arreglo[i]);
			

            tpool.submit(new Runnable(){
                public void run() {
                    total.addAndGet(a);
                    
                    return;
                    }
                });
        }

        tpool.shutdown(); //wait for everything to finish
        try {
              tpool.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {  
            }
        return total.get();
    }
    
}

