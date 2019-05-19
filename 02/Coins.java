package week02;
import java.util.*;

/**Flipping coin game.
   @author Grace Park COSC241.
   10.03.2017
   Coins.java
*/
public class Coins{

    /** set the boolean value to HEADS. */
    public static final boolean HEADS = true;
    /** set the boolean value to TAILS. */
    public static final boolean TAILS = false;
    /** set the boolean value to array coins. */
    private boolean[] coins;
    
    /** sets the value of the datafield boolean to input parameter value.
        @param coins describing array of booleand (true or flase)
    */
    public Coins(boolean[] coins){
        this.coins = coins;
        
    }
    
    /** sets the value of the datafield String.
        to input parameter value.
        @param c converting character from string to boolean
    */
    public Coins (String c){
        this.coins = new boolean[c.length()];
        for (int id = 0; id < c.length(); id++){
            if(c.charAt(id)=='T'){
                coins[id] = TAILS;
            }else{
                coins[id] = HEADS;
            }
        }
                
        
    }

    /** sets the value of the datafield int to input parameter value.
        @param length telling random legnth of the array mad of T and F
    */
    public Coins (int length){
        this.coins = new boolean[length];
        Random r = new Random();
        
        for (int idx = 0; idx< coins.length; idx++){
            boolean trueFalse = r.nextBoolean();
        }
    }
    
    /** return the number of count runs.
        @return runNum 
    */
    public int countRuns(){
        int runNum = 1;
        for (int i = 0; i< coins.length - 1; i++){
            if (coins[i]!= coins[i+1]){
                runNum++;
            }
        }
        return runNum;
         
    }
    
    /** return the numbers of how many heads occurred.
        @return occurHead
    */
    public int countHeads(){
        int occurHead = 0;
        for (int i = 0; i < coins.length; i++){
            if (coins[i]){
                occurHead++;
            }
        }
        return occurHead;
    }
    /** return the string telling heads and tails.
        @return s
    */
    public String toString(){
        String s = "";
        for(int index = 0; index<coins.length; index++) {
            if (coins[index]) {
                s += "H";
            } else {
                s += "T";
            }
        }
        return s;
    }
    /** sets the value of the datafield String to the input parameter value.
        @param args printing how many heads are on the array 
    */
    public static void main(String[] args){
        boolean[] b = {HEADS, TAILS, HEADS, HEADS, TAILS};
        Coins c = new Coins(b);
        System.out.println(c.countHeads());
        System.out.println(c.countRuns());
    }
    

}
