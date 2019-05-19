package week05;

public class RecursiveApp{

    public static long digits(long n){
        if(-10<n && n<10){
            return 1;
        }else{
            return 1+ digits(n/10);
        }
    }

    public static long sumOfDigits(long n){
        if(-10<n && n<10){
            return n;
        }else{
            return n%10 + sumOfDigits(n/10);
        }
    }

    

      
   

}
