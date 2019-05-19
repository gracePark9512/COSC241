package week06;

import java.util.*;
import java.io.*;

/**generating frequencies.
   @author Grace Park COSC 241.
   08.04.2017
   FrequencyGenerator.java
*/
public class FrequencyGenerator implements WordGenerator {
    /** set the random value.*/
    private Random random;
    /** set the int value to ALPHA.*/
    private static final int ALPHA =26;
    /**set the double value to array freArray.*/
    private double [] frArray = new double [ALPHA];
    
    /**method creating random letter frequencies.
       @param r describes randomly generated frequencies
    */
    public FrequencyGenerator(Random r) {
        random = r;
        try {
            File filename = new File ("letter-frequencies.txt");
            Scanner input = new Scanner (filename);
            for(int i =0; i<ALPHA; i++){
                frArray[i] = input.nextDouble();
            }
        } catch (FileNotFoundException e){
            System.err.println ("error try again");
        }
            
    }

    /**method creating new numbers in string value.
       @param n describes number of nextwords
       @return s after running the method 
    */
    public String nextWord(int n) {
        String s = "";
        for (int i =0; i<n; i++){
            char a = (char)('a' +chooseIndex());
            s += a;
        }
        return s;
       
    }
    
    /**method returning int value.
       @return i after running the method
    */
    public int chooseIndex(){
        double r = random.nextDouble();
        int i =0;
        while (r> frArray[i]){
            r = r- frArray[i];
            i+= 1;
        }
        return i;
    }


}
