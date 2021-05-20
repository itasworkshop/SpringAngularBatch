package threads;
import java.io.FileWriter;
import java.io.IOException;
public class File_input_output {

	    public static void main(String[] args) throws IOException
	    {

	        FileWriter fw = new FileWriter("output.txt");
	        for (int i = 1; i <= 1000; i++) {
	        	System.out.println(i);
	            fw.write(Integer.toString(i));
	            fw.write(" ");
	        }
	  
	        System.out.println("Writing successful");
	        //close the file 
	        fw.close();
	    }
	}
