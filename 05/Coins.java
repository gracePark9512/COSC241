package week05;
import java.util.*;


public class Coins{

    public static final boolean HEADS = true;
    public static final boolean TAILS = false;
	
    private boolean[] coins;
	
    public Coins(boolean[] coins) {
        this.coins = coins;
    }

    public int countHeads(){
        int occur = 0;
        for(int i =0; i< coins.length; i++){
            if(coins[i]){
                occur++;
            }
        }
        return occur;
    }

    public String toString(){
        String s = "";
        for(int i = 0; i< coins.length; i++){
            if(coins[i]){
                s += "H";
            }else{
                s+= "T";
            }
        }
        return s;
    }

    public Coins (String c){
        this.coins = new boolean [c.length()];
        for(int i = 0; i< c.length(); i++){
            if(c.charAt(i) == 'T'){
                coins[i] = TAILS;
            }else{
                coins[i] = HEADS;
            }
        }
    }

    public Coins (int length){
        this.coins = new boolean [length];
        Random r = new Random();
        for(int i = 0; i< coins.length; i++){
            boolean generate = r.nextBoolean();
        }
    }


    public int countRuns(){
        int count = 1;
        for(int i =0; i< coins.length-1; i++){
            if(coins[i] != coins[i+1]){
                count++;
            }
        }
        return count;
    }
    
                    
            
                    
    
		
}
