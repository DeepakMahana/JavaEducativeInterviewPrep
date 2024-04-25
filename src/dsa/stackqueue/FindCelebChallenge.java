package dsa.stackqueue;

// Solve a Celebrity Problem Using a Stack

class Stack<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Comment out the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int max_size) {
        this.maxSize = max_size;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[max_size];//type casting Object[] to V[]
        this.currentSize = 0;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    //returns the maximum size capacity
    public int getMaxSize() {
        return maxSize;
    }

    //returns true if Stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    //returns true if Stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //returns the value at top of Stack
    public V top() {
        if (isEmpty())
            return null;
        return array[top];
    }

    //inserts a value to the top of Stack
    public void push(V value) {
        if (isFull()) {
            System.err.println("Stack is Full!");
            return;
        }
        array[++top] = value; //increments the top and adds value to updated top
        currentSize++;
    }

    //removes a value from top of Stack and returns
    public V pop() {
        if (isEmpty())
            return null;
        currentSize--;
        return array[top--]; //returns value and top and decrements the top
    }

}


public class FindCelebChallenge {
    
    //returns true if x knows y else returns false
     private static boolean aqStatus(int[][] party, int x, int y) {
         if (party[x][y] == 1) return true;
         return false;
     }
 
     public static int findCelebrity(int[][] party, int numPeople) {
         Stack<Integer> stack = new Stack<>(numPeople);
         int celebrity = -1;
 
         //Push all people in stack
         for (int i = 0; i < numPeople; i++) {
             stack.push(i);
         }
 
         while (!stack.isEmpty()) {
 
             //Take two people out of stack and check if they know each other
             //One who doesn't know the other, push it back in stack.
             int x = stack.pop();
 
             if (stack.isEmpty()) {
                 celebrity = x;
                 break;
             }
 
             int y = stack.pop();
 
             if (aqStatus(party, x, y)) {
                 //x knows y , discard x and push y in stack
                 stack.push(y);
             } else stack.push(x);
 
         } //end of while
 
         //At this point we will have last element of stack as celebrity
         //Check it to make sure it's the right celebrity
         for (int j = 0; j < numPeople; j++) {
 
             //Celebrity knows no one while everyone knows celebrity
             if (celebrity != j && (aqStatus(party, celebrity, j) || !(aqStatus(party, j, celebrity)))) return -1;
         }
         return celebrity;
     }//end of findCelebrity()
 
     public static void main(String args[]) {
         
         int [][] party1 = {
           {0,1,1,0},
           {1,0,1,1},
           {0,0,0,0},
           {0,1,1,0},   
         };
 
         int [][] party2 = {
           {0,1,1,0},
           {1,0,1,1},
           {0,0,0,1},
           {0,1,1,0},   
         };
 
         int [][] party3 = {
           {0,0,0,0},
           {1,0,0,1},
           {1,0,0,1},
           {1,1,1,0},   
         };
         
         System.out.println(findCelebrity(party1,4));
         System.out.println(findCelebrity(party2,4));
         System.out.println(findCelebrity(party3,4));
     }
 }