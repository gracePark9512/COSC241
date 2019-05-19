package week06;

import java.util.*;
import java.io.*;

/**generating diagrams.
   @author Grace Park COSC 241.
   08.04.2017
   DiagramGenerator.java
*/

public class DigramGenerator implements WordGenerator {
    /** set the random value.*/
    private Random random;
    /** set the string value into empty string.*/
    private String st = "";
    /**set the int value to ALPHA.*/
    private static final int ALPHA = 26;
    /**set the int value to array stArray.*/
    private String [] stArray = new String [ALPHA];

    /**method creading random letter frequencies.
       @param r describes randomly generated frequencies
    */
    public DigramGenerator(Random r) {
        random = r;
        try{
            File filename = new File ("first-letters.txt");
            Scanner input = new Scanner (filename);
            while(input.hasNext()){
                st+= input.next();
                input.nextLine();
            }
        } catch (FileNotFoundException e){
            System.err.println("error try again");
        }

        try{
            File fn = new File ("continuations.txt");
            Scanner ip = new Scanner (fn);
            for (int i =0; i<ALPHA; i++){
                stArray[i] = ip.next();
            }
        } catch (FileNotFoundException e){
            System.err.println ("error try again 2");
        }
                
    }

    /**method creating new words in character values.
       @param n describes number of nextwords
       @return s after running method
    */
    public String nextWord(int n) {
        StringBuilder word = new StringBuilder();
        int idx =random.nextInt(st.length());
        char first = st.charAt(idx);
        word.append(first);
        for (int i =0; i<n-1; i++){
            int next  = first - 'a';
            int id = random.nextInt(stArray[next].length());
            char nextC = stArray[next].charAt(id);
            word.append(nextC);
            first = nextC;
                                    
        }
        return word.toString();
    }
}
