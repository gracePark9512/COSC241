package week10;

import java.util.*;

/**
 * Skeleton of the recursive implementation of a general tree.
 * 
 * @author Michael Albert
 * @param <T> The type of values stored in the tree.
 */
public class Tree<T> {

    /** The top value.*/
    private T rootValue;
    /** The child value of top value.*/
    private List<Tree<T>> children;

    /** Set the top value and children value of the tree.
        @param rootValue = top value
        @param children = child value
    */  
    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }

    /** Sets the rootValue of the tree.
        @param rootValue = root value of the tree
    */
    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    /** Return number of nodes in the tree.
        @return number of nodes
    */
    public int size() {
        int count =0;
        if(rootValue ==null){
            return 0;
        }
        count++;
        for(Tree<T> child : children){
            count += child.size();
        }
               
        return count;
    }

    /** returns max child the root value has in the tree.
        @return max number of child
    */
    public int maxDegree() {
        int max = children.size();
        int count = 0;
        for(Tree<T> child : children){
            if(max < child.maxDegree()){
                max = child.maxDegree();
            }
        }
        return max;
    }
        
    /** Add the child of the tree as subtree.
        @param child tree that has been added
    */
    public void add(Tree<T> child) {
        children.add(child);
    }

    /** return null if they find the matching value.
        @return whether they are matching
        @param value of the tree
    */
    public Tree<T> find(T value) {
        if (rootValue.equals(value)) {
            return this;
        }
        for (Tree<T> child : children) {
            Tree<T> match = child.find(value);
            if (match != null) {
                return match;
            }
        }
        return null;
    }

    /** returns array list which gives the content of nodes.
        @return all the elemnents of the list in post order
    */
    public List<T> postOrder() {
        ArrayList<T> postOrderArray = new ArrayList<T>();
        for(Tree<T> child : children){
            postOrderArray.addAll(child.postOrder());
        }
        postOrderArray.add(rootValue);
        return postOrderArray;
    }

    /** returns the result of the indented elements of the tree.
        @return elements in  indented form
        @param indent added to all the elements 
    */
    private String toIndentedString(String indent){
        String output = indent + rootValue.toString() + '\n';
        for (Tree<T> child : children){
            output += child.toIndentedString(indent+"  ");
        }
        return output;
    }
    
    /** returns string of all the indented elements of the tree.
        @return list of indented elements of the tree in string
    */
    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

    /** add indentation to the elements.
        @return indent that has been added to all the elements
    */
    public String toIndentedString() {
        String ind = "";
        return toIndentedString(ind);
    }

    /** A helper method for testing (used by main).  Searches tree for
     *  the given target and adds white space separated children to
     *  the tree matching target if there is one.
     *
     * @param target the root value to seach for.
     * @param children a white space separated list of children to add
     * to the tree whose value matches target.
     */
    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    /** A tree instance used for testing. */
    private static Tree<String> tree;

    /**
     * Entry point of the program (used for testing).
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args) {
        System.out.println("Creating tree\n-------------");
        tree = new Tree<>("food");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding children\n----------------");
        addChildren("food", "meat fruit vegetable");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nAdding deeper children\n----------------------");
        addChildren("meat", "chicken beef fish");
        addChildren("fish", "salmon cod tuna shark");
        addChildren("vegetable", "cabbage");
        System.out.print(tree + "\nsize: " + tree.size());
        System.out.println(", max degree: " + tree.maxDegree());
        System.out.println("\nPostorder\n---------");
        System.out.println(tree.postOrder());
        System.out.println("\nIndented string\n---------------");
        System.out.print(tree.toIndentedString());
    }

}
