package week09;

/** Block Size Exception - Cumstome exception class.
    Catches exception and returns a message passed into it as a String.
    @author Kate Li, Grace Park, Tiare Horwood.
 */

public class BlockSizeException extends Exception {
    /** prevents warning of "has no definition of serialVersionUID"*/
    private static final long serialVersionUID = 1L;

    /** Block Size Exception Method.
        @param Message that is wanted to be conveyed explaining what went wrong.
     */
    public BlockSizeException(String message) {
        super(message);
    }
}
