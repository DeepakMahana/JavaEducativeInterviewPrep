package dsa.linkedlists;

class SinglyLinkedList<T> {

    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    //head node of the linked list
    private Node headNode;
    private int size;

    //constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
    }

    public Node getHeadNode() {
        return headNode;
    }

    public void setHeadNode(Node headNode) {
        this.headNode = headNode;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isEmpty() {
        if (headNode == null) return true;
        return false;
    }

    //Inserts new data at the start of the linked list
    public void insertAtHead(T data) {
        //Creating a new node and assigning it the new data value
        Node newNode = new Node();
        newNode.data = data;
        //Linking head to the newNode's nextNode
        newNode.nextNode = headNode;
        headNode = newNode;
        size++;
    }

    //Inserts new data at the end of the linked list
    public void insertAtEnd(T data) {
        //if the list is empty then call insertATHead()
        if (isEmpty()) {
            insertAtHead(data);
            return;
        }
        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null;

        Node last = headNode;
        //iterate to the last element
        while (last.nextNode != null) {
            last = last.nextNode;
        }
        //make newNode the next element of the last node
        last.nextNode = newNode;
        size++;
    }

    //inserts data after the given prev data node
    public void insertAfter(T data, T previous) {

        //Creating a new Node with value data
        Node newNode = new Node();
        newNode.data = data;
        //Start from head node
        Node currentNode = this.headNode;
        //traverse the list until node having data equal to previous is found
        while (currentNode != null && currentNode.data != previous) {
            currentNode = currentNode.nextNode;
        }
        //if such a node was found
        //then point our newNode to currentNode's nextElement
        if (currentNode != null) {
            newNode.nextNode = currentNode.nextNode;
            currentNode.nextNode = newNode;
            size++;
        }
    }

    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " -> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    //Searches a value in the given list.
    public boolean searchNode(T data) {
        //Start from first element
        Node currentNode = this.headNode;

        //Traverse the list till you reach end
        while (currentNode != null) {
            if (currentNode.data.equals(data))
                return true; //value found

            currentNode = currentNode.nextNode;
        }
        return false; //value not found
    }

    public void deleteAtHead() {
        if (isEmpty())
            return;
        headNode = headNode.nextNode;
        size--;
    }

    public void deleteAtEnd() {
        if (isEmpty())
            return;
        Node prevNode = this.headNode;
        Node currentNode = prevNode.nextNode;
        while (currentNode.nextNode != null) {
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
        prevNode.nextNode = null;
        size--;
    }

    public void deleteByValue(T data) {
        //if empty then simply return
        if (isEmpty())
            return;

        //Start from head node
        Node currentNode = this.headNode;
        Node prevNode = null; //previous node starts from null

        if (currentNode.data.equals(data)) {
            //data is at head so delete from head
            deleteAtHead();
            return;
        }
        //traverse the list searching for the data to delete
        while (currentNode != null) {
            //node to delete is found
            if (data.equals(currentNode.data)) {
                prevNode.nextNode = currentNode.nextNode;
                size--;
                return;
            }
            prevNode = currentNode;
            currentNode = currentNode.nextNode;
        }
    }
}



public class NthNodeFromEnd {

    public static <T> Object nthElementFromEnd(SinglyLinkedList<T> list, int n) {
        int size = list.getSize();
        n = size - n + 1; //we can use the size variable to calculate distance from start
        if (size == 0 || n > size) {
            return null; //returns null if list is empty or n is greater than size
        }
        SinglyLinkedList<T>.Node current = list.getHeadNode();
        int count = 1;
        //traverse until count is not equal to n
        while (current != null) {
            if (count == n)
                return current.data;
            count++;
            current = current.nextNode;
        }
        return null;
    }
    public static void main( String args[] ) {
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<Integer>();
        sll.printList(); //list is empty
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return null
        for(int i=0; i<15; i+=2){
            sll.insertAtHead(i);
        }
        sll.printList(); // List is 14 -> 12 -> 10 -> 8 -> 6 -> 4 -> 2 -> 0 -> null
        System.out.println("3rd element from end : " + nthElementFromEnd(sll, 3)); //will return 4
        System.out.println("10th element from end : " + nthElementFromEnd(sll, 10));//will return null
    }
    
}
