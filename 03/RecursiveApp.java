package week03;
import java.util.*;

/**Define digits and return sum of it.
   RecursiveApp.java
    @author Grace Park COSC 241
    17.03.2017
*/

public class RecursiveApp{
    
    /** returns how many digits in given parameter.
        @param n in long 
        @return number of digits in the parameter
    */
    public static long digits(long n){
        if (n>0L && n<10L){
            return 1L;
        } else if (n<0L){
            n=  n*(-1L);
            return 1L+digits(n/10);
        }else{
            return 1L+digits(n/10);
        }
        
    }

    /** returns sum of digits in given parameter.
        @param n in long
        @return sun of all digits
    */
    public static long sumOfDigits(long n){
        if (n<0L){
            n= n*-1L;
            if(n<10L){
                return n*-1;
            }else{
                return (n%10+sumOfDigits(n/10))*-1;
            }
        }else{
            if(n<10L){
                return n;
            }else{
                return n%10+sumOfDigits(n/10);
            }
        }
    }
}
