package week12;
import java.util.*;

public class TableauApp {

    public static boolean rowLengthsDecrease(int [][]t){
        for(int i =0; i<t.length-1; i++)
            if(t[i].length < t[i+1].length)
                return false;
        return true;
    }
       

    public static boolean rowValuesIncrease(int [][]t){
        for(int i = 0; i< t.length; i++)
            for(int j = 0; j<t[i].length-1; j++)
                if(t[i][j+1] < t[i][j])
                    return false;
        return true;
    }
      

    public static boolean columnValuesIncrease(int [][]t){
        for(int i =1; i<t.length; i++)
            for(int j =0; j<t[i].length; j++)
                if(t[i-1][j] > t[i][j])
                    return false;
        return true;
    }
      

    public static boolean isSetOf1toN(int [][]t){
        ArrayList<Integer> value = new ArrayList<Integer>();
        int count = 0;
        for(int [] u : t){
            count += u.length;
            for(int elem :u)
                value.add(elem);
            }
        Collections.sort(value);
        for(int i =0; i<count; i++)
            if(value.get(i) != i+1)
                return false;
        return true;
    }
        
            
      
                       


    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && rowValuesIncrease(t))
            if(columnValuesIncrease(t) && isSetOf1toN(t))
                return true;
        return false;
    }

    public static String toString(int[][] t) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[i].length; j++) {
                result.append(String.format("%-4s", t[i][j]));
            }
            if (i < t.length-1) {
                result.append("\n");
            }
        }
        return result.toString();
    }
}
