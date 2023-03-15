
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
    public Stack(int maxSize) {
        this.maxSize = maxSize;
        this.top = -1; //initially when stack is empty
        array = (V[]) new Object[maxSize];//type casting Object[] to V[]
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


public class CheckBalanceParenthesis {
    public static boolean isBalanced(String exp) {

        //Iterate through the string exp.
        //For each opening parentheses, push it into stack
        //For every closing parenthesis check for its opening parentheses in stack
        //If you can't find the opening parentheses for any closing one then returns false.
        //and after complete traversal of string exp, if there's any opening parentheses left
        //in stack then also return false.
        //At the end return true if you haven't encountered any of the above false conditions.
        Stack<Character> stack = new Stack<>(exp.length());

        for (int i = 0; i < exp.length(); i++) {

            char character = exp.charAt(i);

            if (character == '}' || character == ')' || character == ']') {

                if (stack.isEmpty()) return false;

                if ((character == '}' && stack.pop() != '{') || (character == ')' && stack.pop() != '(') || (character == ']' && stack.pop() != '[')) return false;

            }
            else stack.push(character);

        } //end of for
        if (!stack.isEmpty()) return false;

        return true;
    }

    public static void main(String args[]) {

        System.out.println(isBalanced("{[()]}"));
        System.out.println(isBalanced("[{(}]"));

    }
}

