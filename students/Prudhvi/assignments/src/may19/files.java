package may19;


import java.io.FileWriter;
import java.io.IOException;

public class files {
public static void main(String args[]){  



      try {
    	  FileWriter out = new FileWriter("D:/output.txt");
         
         int c=0;
         	while(c<1000) {
            out.write(Integer.toString(c));
            out.write(",");
            c++;
         	}
         	out.write((Integer.toString(1000)));
         	out.write("\n");
         	c++;
         	while(c<2000) {
                out.write(Integer.toString(c));
                out.write(",");
                c++;
             	}
         	out.write((Integer.toString(2000)));
         	out.write("\n");
         	c++;
         	while(c<3000) {
                out.write(Integer.toString(c));
                out.write(",");
                c++;
             	}
         	out.write((Integer.toString(3000)));
         	out.write("\n");
         	c++;
         out.close();
         
         
         
      }
      catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }

      }
   }

