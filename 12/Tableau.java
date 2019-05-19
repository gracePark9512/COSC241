package week12;
import java.util.Scanner;
import java.util.function.Function;

public class Tableau {

    private Cell smallest = null;

    public void addValue (Integer value){
        if(smallest == null){
            smallest = new Cell(value);
            return;
        }
        Integer check = addToRow(smallest, value);
        Cell root = smallest;
        if(check == null)
            return;
        else
            if(smallest.below == null){
                smallest.below = new Cell(check);
                smallest.below.above = root;
            }else{
                smallest =smallest.below;
                addValue(check);
            }
        smallest = root;
    }
            
        
       
    

    protected Integer addToRow (Cell root, int value){
        int bump =0;
        while(root.value < value && root.right != null){
            root = root.right;
        }
        if(root.value> value){
            bump = root.value;
            root.value = value;
            return bump;
        }
        if(root.right == null){
            root.right = new Cell(value);
            root.right.left = root;
        }
        if(root.above != null){
            root.right.above = root.above.right;
            root.above.right.below = root.right;
        }
        return null;
    }
        
       

        


    protected void print(Function<Cell,Integer> f) {
        for (Cell i = smallest; i != null; i = i.below) {
            for (Cell j = i; j != null; j = j.right) {
                System.out.printf("[%2d]", f.apply(j));
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        Tableau t = new Tableau();
        Scanner input = new Scanner(System.in);
        while (input.hasNext()) {
            if (input.hasNextInt()) {
                t.addValue(input.nextInt());
            } else {
                String command = input.next();
                if ("p".equals(command)) {
                    t.print(cell -> cell.value);
                } else if ("c".equals(command)) {
                    t.print(cell -> cell.neighbours());
                }                
            }
        }
    }

    protected static class Cell {
        int value;
        Cell above;
        Cell below;
        Cell left;
        Cell right;

        Cell(int value) {
            this.value = value;
        }

        int neighbours() {
            int count = left != null ? 1 : 0;
            count += right != null ? 1 : 0;
            count += above != null ? 1 : 0;
            count += below != null ? 1 : 0;
            return count;
        }
    } 
}
