package threads;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Multiple_Threads {

    private volatile Integer count = 1;
    private volatile Integer threadIdToRun = 1;
    private Object object = new Object();

    
    public static void main(String[] args) throws IOException {

        Multiple_Threads testClass = new Multiple_Threads();
        Thread t1 = new Thread(testClass.new Printer(1));
        Thread t2 = new Thread(testClass.new Printer(2));
        Thread t3 = new Thread(testClass.new Printer(3));
        
        t1.start();
        t2.start();
        t3.start();
    }

    class Printer implements Runnable {

        private int threadId;

        public Printer(int threadId) {
            super();
            this.threadId = threadId;
        }

        @Override
        public void run() {
            try {
            	FileWriter fw=new FileWriter("output.txt");
                while (count <= 1000) {
                    synchronized (object) {
                        if (threadId != threadIdToRun) {
                            object.wait();
                        } else {
                            String ss = "Thread " + threadId + " printed " + count;
                   
							fw.write(ss);
                            count += 1;

                            if (threadId == 1)
                                threadIdToRun = 2;
                            else if (threadId == 2)
                                threadIdToRun = 3;
                            else if (threadId == 3)
                                threadIdToRun = 1;

                            object.notifyAll();
                        }
                    }
//                    fw.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
           

        }
    }
}