package dsa.stackqueue;

class Stack<V> {
    private int maxSize;
    private int top;
    private V[] array;
    private int currentSize;

    /*
    Java does not allow generic type arrays. So we have used an
    array of Object type and type-casted it to the generic type V.
    This type-casting is unsafe and produces a warning.
    Un-comment the line below and execute again to see the warning.
    */
    @SuppressWarnings("unchecked")
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = (V[]) new Object[maxSize];//type casting Object[] to V[]
        this.currentSize = 0;
		this.top = -1;
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


class QueueWithStack<V> {
	//We can use 2 stacks for this purpose, stack1 to store original values
	//and stack2 which will help in dequeue operation.
    Stack<V> stack1;
    Stack<V> stack2;

    public QueueWithStack(int maxSize){
        stack1 = new Stack<>(maxSize);
        stack2 = new Stack<>(maxSize);
    }
    public boolean isEmpty(){
      return (stack1.isEmpty() && stack2.isEmpty());
    }
    public void enqueue(V value){
        stack1.push(value);
    }
    public V dequeue(){
        //return null if both the stacks are empty 
        if (isEmpty()){
          return null;
        }
        else if (stack2.isEmpty()){ 
          //if stack2 is empty, we pop all the elements
			    //from stack1 and push them to the stack2
          while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
          }
          //finally, we return the top of stack2
          return stack2.pop();
        }
        else{ 
          //if none of the above conditions are true
          //we will simply return the top of stack2
          return stack2.pop();
        }
    }

}

public class CheckQueueWithStack {

    public static void main(String args[]) {
      
      QueueWithStack<Integer> queue = new QueueWithStack<Integer>(5);
      
      queue.enqueue(1);
      queue.enqueue(2);
      queue.enqueue(3);
      queue.enqueue(4);
      queue.enqueue(5);
    
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue());
      System.out.println(queue.dequeue()); //this will output null because queue will be empty
    }
    
  }