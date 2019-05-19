package week12;

import java.util.Scanner;

import static week12.LinkedBST.Direction.*;

public class LinkedBST<T extends Comparable<T>> {

    private T root;

    private LinkedBST<T> left;

    private LinkedBST<T> right;

    public LinkedBST(T value) {
        root = value;
        left = null;
        right = null;
    }
   
    public LinkedBST() {
        this(null);
    }

    public void add(T element) {
        if(root== null){
            root = element;
        }
        int compare = root.compareTo(element);
        if(compare > 0){
            if(left == null)
                left = new LinkedBST<T>(element);
            else
                left.add(element);
        }else if(compare < 0){
            if(right == null)
                right = new LinkedBST<T>(element);
            else
                right.add(element);
        }
    }
        
        
        
        
       
      

    public int height() {
        if(root == null)
            return 0;
        int leftH = 0;
        int rightH = 0;
        if (left != null)
            leftH +=1+ left.height();
        if (right != null)
            rightH += 1+ right.height();
        return Math.max(leftH, rightH);
    }
    
        
        
     

    public boolean search(T target) {
        if(root != null){
            int compare = root.compareTo(target);
            if(compare == 0)
                return true;
            if(left != null && compare > 0)
                return left.search(target);
            if(right != null && compare <0)
                return right.search(target);
        }
        return false;
    }
        
       
   
    public int size() {
        int size = 0;
        if(root == null)
            return size;
        if(left != null)
            size += left.size();
        if(right != null)
            size += right.size();
        return size +1;
    }
        
    
        

    public int sizeAbove(T low) {
        int count = 0;
        if(root != null){
            int compare = root.compareTo(low);
            if(compare == 0 || compare >0)
                count ++;
            if(left != null)
                count += left.sizeAbove(low);
            if(right != null)
                count += right.sizeAbove(low);
        }
        return count;
    }
        

    public int sizeBelow(T high) {
        int count =0;
        if(root != null){
            int compare = root.compareTo(high);
            if(compare <0)
                count ++;
            if(left != null)
                count += left.sizeBelow(high);
            if(right != null)
                count += right.sizeBelow(high);
        }
        return count;
    }
        
    
    public int sizeBetween(T low, T high) {
        int count = 0;
        if(root != null){
        if(root.compareTo(low)>0 && root.compareTo(high)<0)
            count ++;
        if(left != null)
            count += left.sizeBetween(low, high);
        if(right != null)
            count += right.sizeBetween(low, high);
        }
        return count;
    }
        

    public void remove(T element) {
        // implement this method from the lectures if you
        // want to do the extension exercises
    }

    enum Direction {LEFT, RIGHT, NO};
    
    public StringBuilder str(String curr, Direction dir, StringBuilder result) {
        if(right != null) {
            right.str(curr + (dir == LEFT ? "│  " : "   "), RIGHT, result);
        }
        if (root != null) {
            result.append(curr + (dir == RIGHT ? "┌─ " :
                                  dir == LEFT ? "└─ " : "  ") + root + "\n");
        }
        if(left != null) {
            left.str(curr +  (dir == RIGHT ? "│  " : "   "), LEFT, result);
        }
        return result;
    }

    public String toString() {
        return str("", NO, new StringBuilder()).toString();
    }

    public static void main(String[] args) {
        LinkedBST<String> tree = new LinkedBST<>();
        Scanner input = new Scanner(System.in);
        while (input.hasNextLine()) {
            Scanner line = new Scanner(input.nextLine());
            if (line.hasNext()) {
                String command = line.next();
                switch (command) {
                    case "a": case "add":
                        while (line.hasNext()) {
                            tree.add(line.next());
                        }
                        break;
                    case "f": case "find":
                        if (line.hasNext()) {
                            System.out.println(tree.search(line.next()));
                        }
                        break;
                    case "p": case "print":
                        System.out.print(tree);
                        break;
                    case "h": case "height":
                        System.out.println(tree.height());
                        break;
                    case "s": case "size":
                        System.out.println(tree.size());
                        break;
                    case "sa": case "sizeabove":
                        if (line.hasNext()) {
                            String low = line.next();
                            System.out.println(tree.sizeAbove(low));
                        }
                        break;
                    case "sb": case "sizebelow":
                        if (line.hasNext()) {
                            System.out.println(tree.sizeBelow(line.next()));
                        }
                        break;
                    case "si": case "sizeinbetween":
                        if (line.hasNext()) {
                            String low = line.next();
                            if (line.hasNext()) {
                                System.out.println(tree.sizeBetween
                                                   (low, line.next()));
                            }
                        }
                        break;
                    default:
                        System.err.println("Unknown command: " + command);
                }
            }
        }
    }

}
