package week09;
import java.util.*;

/** Overhand App - Class that extends Overhand Shuffler.
    A class that translate the methods in OverhandShuffler.
    java into cumstome terminal commands. Able to call
    methods and pass values in the terminalwindow.
    Bassed off ExampleApp.java provided.
    @author Kate Li, Grace Park, Tiare Horwood.
 */

public class OverhandApp extends OverhandShuffler{

    /** Main Method.
        Creats a new instance of Overhand Shuffler and of
        Scanner class. Passes the Keboard input into scanner
        and then passes both instances into the method handleLine.
        @param args command line arguments are not used.
     */
    public static void main(String [] args){
        OverhandShuffler o = new OverhandShuffler();//instance of
        Scanner in = new Scanner(System.in);//scanner reading
        while (in.hasNextLine()){
            handleLine(o, in.nextLine());
        }//while end
    }//main end
    
    /** Get Nums method.
        Places the integers that are passed in through the scanner class
        into a List Array. It then transform the List Array into an int[].
        @param in - integers that are passed through scanner.
        @return int[] - Containing the integers passed by scanner.
     */
    private static int[] getNums(Scanner in){
        List<Integer> numlist = new ArrayList<Integer>();
        while (in.hasNextInt()){
            numlist.add(in.nextInt());
        }//while end
        int[] nums = new int[numlist.size()];
        for (int i =0; i< nums.length; i++){
            nums[i] = numlist.get(i);
        }
        return nums;
    }//getNum end

    /**Handle LIne Method.
       Creats a switch statment that is fed in <code>command</code>
       which is a String form of scanner. It then places different
       methodsfrom OverhandShuffler into cases under prompts
       and promtshortcut. In places where arrays had to be passed
       into OverhandShuffler.java
       methods, get nums method were used.
       @param ovr - instance of Overhand Shuffler.
       @param in - Inputs from scanner in the form of String.
     */
    public static void handleLine(OverhandShuffler ovr, String in){
        Scanner s = new Scanner(in);
        if(s.hasNext()){
            String command = s.next();
            switch (command){
                case "make-new": case "m": //new ordered deck from 0 to 17
                    while (s.hasNextInt()){
                        ovr.makeNew(s.nextInt());
                    }
                    break;
                case "print": case "p"://print current deck
                    System.out.println(Arrays.toString(ovr.getCurrent()));
                    break;
                case "shuffle": case "s"://call shuffle ([2,3,10,3])
                    int[] nums = getNums(s);
                    ovr.shuffle(nums);
                    //ovr.shuffle(Integer.parseInt(command));
                    break;
                case "order": case "o"://print result calling ([1,4,11,2]
                    int[] nums1 = getNums(s);
                    System.out.println(ovr.order(nums1));
                    break;
                case "unbroken-pairs": case "u": //print unbrockenPairs()
                    System.out.println(ovr.unbrokenPairs());
                    break;
                case "random-shuffle": case "r": //call randomShuffle()
                    ovr.randomShuffle();
                    break;
                case "count-shuffles": case "c": //print countShuffles(15);
                    while (s.hasNextInt()){
                        System.out.println(ovr.countShuffles(s.nextInt()));
                    }
                    break;
                case "load": case "l": //load deck with given number
                    int[] nums2 = getNums(s);
                    ovr.load(nums2);
                    break;
                    
            }//switch end 
        }//if end
    }//handleLine end 
}//class end 
