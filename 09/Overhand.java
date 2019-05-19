package week09;

/** Overhand - interface class that is to be used and
    overrided by Overhand Shufler.
    @author Kate li, Grace Park, Tiare Horwood.
*/

public interface Overhand {
    
    /**Make New method Interface.
       @override by OverhandShuffler.java.
       @param size - to be overridden.
    */
    public void makeNew (int size);
    
    /**Get Current  method Interface.
       @override by OverhandShuffler.java.
       @return int[] - to be overridden.
    */
    public int[] getCurrent();
    
    /**Shuffle  method Interface.
       @override by OverhandShuffler.java.
       @param blocks - to be overridden.
    */
    public void shuffle(int [] blocks);
    
    /**Order  method Interface.
       @override by OverhandShuffler.java.
       @param blocks - to be overridden.
       @return int - to be overridden.
    */
    public int order(int[] blocks);
    
    /**Unbroken Pairs method Interface.
       @override by OverhandShuffler.java.
       @return int - to be overridden.
    */
    public int unbrokenPairs();
    
}
