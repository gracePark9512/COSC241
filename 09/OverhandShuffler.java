package week09;
import java.util.*;
import java.util.stream.*;
import java.io.*;

/** Overhand Shufler Class - Impliments and overrides Overhand.
    A class that handles the manipultion of a deck of cards in the
    form of int[].
    @author Kate Li, Grace Park, Tiare Horwood.
*/

public class OverhandShuffler implements Overhand{
    /**Data Feild = int[] deck that hold virtual cards
       that re to be manipulated.*/
    private int[] deck;
    /**Data Feild = int[] rBlock that holds a randomly
       generated block size creatd by randomShuffle method.*/
    private int[] rBlock;
    /**Data Feild = final int deckSize, holds the total number of
     elements/cards ina deck.*/
    final int deckSize = 50;
    /**Data Feild = finial int cycle, the number of times we wanted
     to repeat our experiments.*/
    final int cycle = 130;
    
    /** Make New method.
        @override Overhand Make New Method.
        Initialize <code>int[] deck</code> to a given
        size and then fills in the array from 0 to size-1.
        @param size - desired size of <code>deck</code>.
    */
    public void makeNew(int size){
        this.deck = new int[size];
        for (int i = 0; i < size; i++) {
            deck[i] = i;
        }
    }

    /** Get Current Method.
        @override Overhand Get Current Method.
        Returns the current state of <code>int[] deck</code>.
        if <code>deck</code> has yest to be initilized
        then it initilizesone of size 0.
        @return int[] - contains the current state of <code>deck</code>.
     */
    public int[] getCurrent(){
        if (deck == null){
            return this.deck = new int[0];
        }
        return Arrays.copyOf(deck, deck.length);
    }

    /** Shuffle method.
        @override Overhand Shuffle Method.
        Gets passed an <code>int[] blocks</code> that is used
        to shuffles the current sate of <code>int[] deck</code>.
        Contains a Block Size Exception that catchs unwanted
        inputs like negitive numberes or if the sum of
        <code>blocks</code> does not equal the length of
        <code>deck</code>.
        @param blocks - array holding size of blocks to be shfufled.
     */
    public void shuffle(int[] blocks){
        int[] result = new int[deck.length];
        int i = 0;
        try{
            handleBlockException(blocks);
            for (int block : blocks) {
                for (int j =block-1+i, k=deck.length-1-i; j>=i; --j, --k) {
                    result[k] = deck[j];
                }
                i += block;
            }
        }catch(BlockSizeException e){
            System.out.println(e);
        }
        deck = result;
    }

    /** Order Method.
        @override Overhand Order Method.
        Gets passed an <code>int[] blocks</code> that is used to
        shuffle the current state of the deck. Using the,
        Order method keeps shuffling the deck to see how many
        shuffles it takes before it reaches the initial deck
        it started with. Contains a Block Size Exception that
        catchs unwanted inputs like negitive numberes or if
        the sum of <code>blocks</code> does not equal the
        length of <code>deck</code>.
        @param blocks - array holding size of blocks to be shfufled.
        @return i - total shuffles needed to return to initial state.
     */
    public int order(int[] blocks){
        OverhandShuffler original = new OverhandShuffler();
        original.load(this.deck);
        int i = 1;
        boolean isMatch = true;
        try{
            handleBlockException(blocks);
            while (isMatch) {
                shuffle(blocks);
                if (this.toString().equals(original.toString())) {
                    isMatch = false;
                    return i;
                }
                i++;
            }
        }catch(BlockSizeException e){
            System.out.println(e);
        }   
        return i;
    }

    /** To String Method.
        Places elements in an int[] into a single String.
        @return s - int[] in the form of a String.
     */
    public String toString() {
        String s = "";
        for (int card : deck) {
            s += card + " ";
        }
        return s;
    }

    /** Handle Block Exception Method.
        @specialnote Used so the conditions of Block Size
                     Exception did not have to be repeated
                     in both Order Method and Shuffle Method.
        Makes sure the values in <code>int[] blocks</code>
        neither contain a negitive nore the elements in
        the array have a sum greater then the length of
        <code>deck</code>.
        @param blocks - the int[] that is to be tested.
        @throws BlockSizeException - throws exception when conditions are met.
     */
    private void handleBlockException(int[] blocks) throws BlockSizeException {
        int sum = 0;
        for (int block : blocks) {
            sum += block;
            if (block < 0) {
                throw new BlockSizeException("A block value is negative");
            }
        }
        if (sum != deck.length) {
            throw new BlockSizeException("The sum of the blocks is not"
                                         +" equal to the deck size. Sum: "
                                         + sum + ", deck size: " + deck.length);
        }
    }

    /** Unbroken Pairs Method.
        @override Overhand Unbroken Pairs Method.
        Goes through <code>int[] deck</code> and counts the
        number of unbrokenpairs there are in the array.
        @return unbrokenPairs - the total number of unbroken pairs.
     */
    public int unbrokenPairs() {
        int unbrokenPairs = 0;
        for (int i = 1; i < deck.length; i++) {
            if (deck[i - 1] + 1 == deck[i]) {
                ++unbrokenPairs;
            }
        }
        return unbrokenPairs;
    }

    /** Shuffle Array Method.
        @specialnote Created so we could address the first part of
                     our experiment of creating a true/pseudo int[]
                     that we can compare against our Random Overhand
                     Shuffle method.
       Using a Random generator, chooses a number between 0 and the
       length of <code>int[] deck</code>. Once an integer has been
       chosen, it is used as an index. The value of the radonly
       chosen array index is stored in <code>int store</code> and
       is then assigned the value at index <code>int i</code>.
       The value at index <code>i</code> is then assigned what
       was stored in <code>store</code>.
     */
    public void shuffleArray(){
        Random r = new Random();
        for (int i = this.deck.length - 1; i > 0; i--){
            int index = r.nextInt(i + 1);
            int store = this.deck[index];
            this.deck[index] = this.deck[i];
            this.deck[i] = store;
        }
    }
    
    /** Try Repeat Method.
        Goes through the current state of <code>deck</code> that
        has gone through unknown cycles of shufles with an unknown
        block size. 
        Using the values stored in each idex of <code>deck</code>
        as an index pointer. The values that the pointer referenced,
        were copied into <code>int[] endState</code> which represents
        what the deck would look like if it were to be shuffled the
        same number of times with the same <code>int[] blocks</code>.
     */
    public void tryRepeat(){
        int[] endState = new int[this.deck.length];
        for(int i = 0; i<this.deck.length; i++){
            endState[i] = this.deck[this.deck[i]];
        }
        this.deck = endState;
    }

    /** Random Shuffle Method.
        Initilises <code>int[] rBlock</code> to store a randomly
        generated int[] for specifically <code>int[] deck</code>
        of size 50. Using a Random generator to choose where a block
        break happens from numbers 0 to 49 with a 1/10 chance.
        Resulting in a pure/pseudo random int[] block with the sum
        of 50.
    */
    public void randomShuffle(){
        Random r = new Random();
        int blockSize = 0;
        int id = 0;
        final double oneInTen = 0.1;
        this.rBlock = new int[1];
        for (int i = 0; i < this.deckSize; i++){
            ++blockSize;
            if(r.nextDouble() < oneInTen){
                this.rBlock[id] = blockSize;
                id++;
                this.rBlock = Arrays.copyOf(this.rBlock, this.rBlock.length +1);
                blockSize = 0;
            }
        }
        int sum = IntStream.of(this.rBlock).sum();
        if (sum != this.deckSize){
            int add = this.deckSize-sum;
            this.rBlock[this.rBlock.length -1] = add;
        }else{
            this.rBlock = Arrays.copyOf(this.rBlock, this.rBlock.length);
        }
    }

    /** Count Shuffles Methods.
        Counts the number of random shuffles  needed to reach
        the desired unbroken pair count passed into the method
        parameter.
        @param unbrokenPairs - target number of Unbroken pairs.
        @return shuffles - the number of random shufles needed.
     */
    public int countShuffles(int unbrokenPairs) {
        int shuffles = 0;
        while (this.unbrokenPairs() != unbrokenPairs) {
            this.randomShuffle();
            shuffle(this.rBlock);
            shuffles++;
        }
        return shuffles;
    }

    /** Load Method.
        Loads in an int[] into <code>int[] deck</code>.
        @param cards - an int[] that is to be loaded into deck
     */
    public void load(int[] cards){
        deck = Arrays.copyOf(cards, cards.length);
    }

    /** Main Method.
       Creats two instances of OverhandShuffler used to run experiemnts
       on a Random Array method and Random Overhand Shuffle Method.
       The variable <code>cycle</code> is used as the number of tests
       carried out.
       
       For the first experiment, a specified amount of randomly
       generated int[] of size 50 are created and then passed
       through the Unbroken Pairs Method. The highest occurrence
       of unbroken pairs is then used as acomparison for Random
       Overhand Shuffle Method.

       @specialnote This is used to compare to our Shuffle
                    Array method and see if the distribution
                    of unbroken pairs are similar.
       This method re-enact what would happen if you were to
       shuffle a deck of cards a specified number of times
       (under <code>cycle</code> variable) using the Random
       Shuffle Method. It then prints out the nuber of occurrence
       of unborken pairs.

       For the second experiment, a specified number calls on the
       Count Shuffles method is called for the top three highest
       occurrence of unbroken pairs in the first experiment. The
       number of shuffles needed is then averaged out to represent
       the numbres of shuffles needed to the same level of random.
       
       @param args command line arguments are not used. 
    */
    public static void main(String [] args){
        OverhandShuffler test = new OverhandShuffler();
        int[] results = new int[test.cycle];
        for(int i = 0; i<test.cycle; i++){
            test.makeNew(test.deckSize);
            test.shuffleArray();
            results[i] = test.unbrokenPairs();
        }
        Arrays.sort(results);
        int count = 0;
        for(int i = 1; i<results.length; i++){
            count++;
            if(results[i-1] != results[i]){
                System.out.println("Total number of " + results[i-1]
                                   +" Unbroken Pairs " + count + " out of "
                                   + test.cycle);
                count = 0;
            } 
        }
        System.out.println();
        OverhandShuffler workPls = new OverhandShuffler();
        int[] results1 = new int[workPls.cycle];
        for(int i = 0; i<workPls.cycle; i++){
            workPls.makeNew(workPls.deckSize);
            for(int id = 0; id<=workPls.cycle; id++){
                workPls.randomShuffle();
                workPls.shuffle(workPls.rBlock);
            }
            results[i] = workPls.unbrokenPairs();
        }
        Arrays.sort(results);
        count = 0;
        for(int i = 1; i<results.length; i++){
            count++;
            if(results[i-1] != results[i]){
                System.out.println("Total number of " + results[i-1]
                                   +" Unbroken Pairs " + count + " out of "
                                   + workPls.cycle);
                count = 0;
            } 
        }
        System.out.println();
        
        OverhandShuffler test2 = new OverhandShuffler();
        double sum = 0;
        final int topThree = 3;
        for(int j = 0; j<topThree; j++){
            for (int i = 0; i<test2.cycle; i++){
                test2.makeNew(test2.deckSize);
                sum += test2.countShuffles(j);
            }
            System.out.println(sum/test2.cycle
                               + " Average number Random Shuffles"
                               +" needed to reach "+j+" Unbroken Pairs.");
            sum = 0;
        }
    }
}
