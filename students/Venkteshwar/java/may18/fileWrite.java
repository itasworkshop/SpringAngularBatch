package may18;

import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors

public class fileWrite {

	public static void main(String[] args) {
		String sum = "0";
		try {
		      FileWriter myWriter = new FileWriter("TestCase.txt");
		      
		      for(int i=0; i<=1000; i++)
		      {
		    	  myWriter.write(String.valueOf(i)+",");
		      }
		      //myWriter.write(sum);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

	}

}

