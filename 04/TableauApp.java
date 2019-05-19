package week04;
import java.util.*;
/**
 * Skeleton code for an array based implementation of Young's tableau.
 *
 * @author Iain Hewson
 */
public class TableauApp {

    /**
     * The main method is just used for testing.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        final int[][] valid = {{1, 4, 5, 10, 11}, {2, 6, 8}, {3, 9, 12}, {7}};
        System.out.println(TableauApp.toString(valid));
        System.out.println(isSetOf1toN(valid));
    }

    /**
     * Determines whether the array passed to it is a valid tableau or not.
     *
     * @param t a two-dimensional array to test for tableau-ness.
     *
     * @return true if the parameter is a valid tableau, otherwise false
     */
    public static boolean isTableau(int[][] t){
        if(rowLengthsDecrease(t) && rowValuesIncrease(t)){
            if(columnValuesIncrease(t) && isSetOf1toN(t)){
                return true;
            }
        }
        return false;
    }
    

    /**
     * A method that returns ture if  the integers are increasing.
     *@return true if the integers are increasing in row 
     *@param t = array
     */
    public static boolean rowValuesIncrease(int [][] t){
        boolean rowValuesIncreasing = true;
        for(int id = 0; id<t.length; id++){
            for(int e = 0; e< t[id].length-1; e++){
                if(t[id][e] < t[id][e+1]){
                }else{
                    rowValuesIncreasing = false;
                }
            }
        }
        return rowValuesIncreasing;
    }

    /**
     * A method that returns true if no row is longer than a preceding row.
     *@return boolean returning true if no row is longer than a preceding row
     *@param t = array
     */
    public static boolean rowLengthsDecrease (int [][] t){
        boolean rowIsDecreasing = true;
        for(int i = 0; i<t.length-1; i++){
            if (t[i].length >= t[i+1].length){
            } else{
                rowIsDecreasing = false;
            }
        }
        return rowIsDecreasing;
    }

    /**
     * A method that returns true if from top to bottom, integers increase.
     *@return boolean returning true if the integers are increasing in col
     *@param t = array
     */
    public static boolean columnValuesIncrease (int [][] t){
        boolean columnIsIncreasing = true;
        for (int x= 1; x<t.length; x++){
            for(int el= 0; el<t[x].length; el++){
                if (t[x-1][el] < t[x][el]){
                    
                }else{
                    columnIsIncreasing = false;
                }//else close
            }//for end
        }//for end
        return columnIsIncreasing;
    }//end column

    

    /** A method that returns true if all the elements are present.
     *@return true if all the elements are present
     *@param t = array
     */
    public static boolean isSetOf1toN(int [][] t){
        int count = 0;
        ArrayList<Integer> elements = new ArrayList<Integer>();
        for(int i =0; i<t.length; i++){
            count+= t[i].length;
        }
        for(int id=0; id<t.length; id++){
            for(int e=0; e<t[id].length; e++){
                elements.add(t[id][e]);
                Collections.sort(elements);
            }
        }
        for (int d=0; d<count; d++){
            if(elements.get(d)==d+1){
            }else{
                return false;
            }
        }
        return true;
  
    }
   
                    
      

    /**
     *  Returns a string representation of an array based tableau.
     *
     * @param t a two-dimensional array which represents a tableau.
     *
     * @return a string representation of an array based tableau.
     */
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

