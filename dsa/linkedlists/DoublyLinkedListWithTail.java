package dsa.linkedlists;

public class DoublyLinkedListWithTail<T> {
    
    //Node inner class for DLL
    public class Node {
        public T data;
        public Node nextNode;
        public Node prevNode;
    }

    //member variables
    public Node headNode;
    public Node tailNode;
    public int size;

    //constructor
    public DoublyLinkedListWithTail() {
        this.headNode = null;
        this.tailNode = null; //null initially
        this.size = 0;
    }

    //returns true if list is empty
    public boolean isEmpty() {
        if (headNode == null && tailNode == null) //checking tailNode to make sure
            return true;
        return false;
    }

    //getter for headNode
    public Node getHeadNode() {
        return headNode;
    }

    //getter for tailNode
    public Node getTailNode() {
        return tailNode;
    }

    //getter for size
    public int getSize() {
        return size;
    }

     //insert at start of the list
     public void insertAtHead(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = this.headNode; //Linking newNode to head's nextNode
        newNode.prevNode = null; //it will be inserted at start so prevNode will be null
        if (!isEmpty())
            headNode.prevNode = newNode;
        else
            tailNode = newNode;
        this.headNode = newNode;
        size++;
    }

    //insert at end of the list
    public void insertAtEnd(T data) {
        if (isEmpty()) { //if list is empty then insert at head
            insertAtHead(data);
            return;
        }
        //make a new node and assign it the value to be inserted
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextNode = null; //it will be inserted at end so nextNode will be null
        newNode.prevNode = tailNode; //newNode comes after tailNode so its prevNode will be tailNode
        tailNode.nextNode = newNode; //make newNode the nextNode of tailNode
        tailNode = newNode; //update tailNode to be the newNode
        size++;
    }

    //delete at head of the list
    public void deleteAtHead() {
        if (isEmpty())
            return;

        headNode = headNode.nextNode;
        if(headNode == null)
            tailNode = null;
        else
            headNode.prevNode = null;
        size--;
    }

    // delete at the end of the list
    public void deleteAtTail() {
        if (isEmpty())
            return;
        tailNode = tailNode.prevNode;
        if (tailNode == null)
            headNode = null;
        else
            tailNode.nextNode = null;
        size--;
    }

    //print list function
    public void printList() {
        if (isEmpty()) {
            System.out.println("List is Empty!");
            return;
        }

        Node temp = headNode;
        System.out.print("List : null <- ");

        while (temp.nextNode != null) {
            System.out.print(temp.data.toString() + " <-> ");
            temp = temp.nextNode;
        }

        System.out.println(temp.data.toString() + " -> null");
    }

    public static void main( String args[] ) {
        DoublyLinkedListWithTail<Integer> list = new DoublyLinkedListWithTail<Integer> ();
        for (int i = 0; i <= 3; i++) {
            list.insertAtHead(i); //inserting 0 to 3 at start
        }
        System.out.println("After inserting 0 to 3 at start :");
        list.printList();
         for (int i = 5; i <= 10; i++) {
            list.insertAtEnd(i); //inserting 5 to 10 at end
        }
        System.out.println("\n After inserting 5 to 10 at end :");
        list.printList();
    }
}
