package week12;
import java.util.*;

public class Tree<T> {
    private T rootValue;
    private List<Tree<T>> children;

    public Tree(T rootValue, List<Tree<T>> children) {
        this.rootValue = rootValue;
        this.children = children;
    }
    
    public Tree(T rootValue) {
        this(rootValue, new ArrayList<Tree<T>>());
    }

    public int size(){
        int size = 0;
        if(rootValue == null)
            return size;
        for(Tree<T> child: children)
            size += child.size();
        return 1+size;
    }
       
      
            

    public int maxDegree(){
        int max = children.size();
        for(Tree<T> child : children)
            if(max < child.maxDegree())
                max = child.maxDegree();
        return max;
    }
       
       
      

    public void add(Tree<T> child) {
        children.add(child);
    }

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

    public List<T> postOrder() {
        ArrayList<T> postOrd = new ArrayList<T>();
        for(Tree<T> child : children)
            postOrd.addAll(child.postOrder());
        postOrd.add(rootValue);
        return postOrd;
    }
        
        
     

    public String toString() {
        if (children.isEmpty()) {
            return rootValue.toString();
        }
        return rootValue.toString() + ' ' + children.toString();
    }

       
   
        
    public String toIndentedString(){
        String result = new String();
        return recursiveIndent(result);
       
    }

    private String recursiveIndent(String str){
        String indentedList = new String();
        indentedList = str + rootValue.toString()+"\n";
        for(Tree<T> child : children)
            indentedList += child.recursiveIndent("  "+str);
        return indentedList;
    }
        
        
   

    private static void addChildren(String target, String children) {
        Tree<String> parent = tree.find(target);
        if (parent != null) {
            for (String child : children.split(" ")) {
                parent.add(new Tree<>(child));
            }
        }
    }

    private static Tree<String> tree;

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
