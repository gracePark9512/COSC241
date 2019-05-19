package week01;
import java.util.Scanner;
/**
   Counting lines and words.
   @author Grace Park COSC241
   03.03.2017
   Counter.java
*/

public class Counter{
    /**sets the value datafield String to input parameter value.
      @param args to String
    */
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int lineCount = 0;
        int wordCount = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            lineCount++;
        
            Scanner wordScanner = new Scanner(line);
           
            while (wordScanner.hasNext()){
                String word = (wordScanner.next());
                wordCount++;
            }
        }
        System.out.println ("lines: " +lineCount);
        System.out.println ("words: " +wordCount);
    }
}
        
