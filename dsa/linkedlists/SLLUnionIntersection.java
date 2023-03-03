package dsa.linkedlists;

import java.util.HashSet;

class SinglyLinkedList<T> {
    //Node inner class for SLL
    public class Node {
        public T data;
        public Node nextNode;

    }

    //head node of the linked list
    private Node headNode;
    private int size;

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

    //constructor
    public SinglyLinkedList() {
        headNode = null;
        size = 0;
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
    
    public void removeDuplicatesWithHashing() {
        Node current = this.headNode;
        Node prevNode = this.headNode;
        //will store all the elements that we observe once
        HashSet<T> visitedNodes = new HashSet<T>();

        if (!isEmpty() && current.nextNode != null) {
            while (current != null) {
                //check if already visited then delete this node
                if (visitedNodes.contains(current.data)) {
                    //deleting the node by undating the pointer of previous node
                    prevNode.nextNode = current.nextNode;
                    current = current.nextNode;
                } else {
                    //if node was not already visited then add it to the visited set
                    visitedNodes.add(current.data);
                    //moving on to next element in the list
                    prevNode = current;
                    current = current.nextNode;
                }
            }
        }
    }
}


public class SLLUnionIntersection {

    public static <T> SinglyLinkedList<T> union(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
 
         //if one of the list is empty then return the other list
         if (list1.isEmpty())
             return list2;
         if (list2.isEmpty())
             return list1;
 
         //take the head of the first list
         SinglyLinkedList<T>.Node last = list1.getHeadNode();
         //traverse it to the last element
         while (last.nextNode != null) {
             last = last.nextNode;
         }
         //attach the last element of list1 to head of list2
         last.nextNode = list2.getHeadNode();
         //remove duplicates that might have been added now
         list1.removeDuplicatesWithHashing(); //complexity of this function is O(n)
 
         return list1;
     }
 
     public static <T> boolean contains(SinglyLinkedList<T> list, T data) {
         SinglyLinkedList<T>.Node current = list.getHeadNode();
         while (current != null) {
             if (current.data.equals(data))
                 return true;
             current = current.nextNode;
         }
         return false;
     }
 
     public static <T> SinglyLinkedList<T> intersection(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
         SinglyLinkedList<T> result = new SinglyLinkedList<T>();
         if (list1.isEmpty())
             return result;
         if (list2.isEmpty())
             return result;
         SinglyLinkedList<T>.Node current = list1.getHeadNode();
 
         while (current != null) {
             if (contains(list2, current.data)) {
                 result.insertAtHead(current.data);
             }
             current = current.nextNode;
         }
 
         return result;
     }
 
     public static void main( String args[] ) {
         SinglyLinkedList<Integer> list1 = new SinglyLinkedList<Integer>();
         for(int i=7; i>3; i--){
             list1.insertAtHead(i);
         }
         System.out.print("1st ");
         list1.printList();
         SinglyLinkedList<Integer> list2 = new SinglyLinkedList<Integer>();
         for(int i=0; i<5; i++){
             list2.insertAtHead(i);
         }
         System.out.print("2nd ");
         list2.printList();
         System.out.print("After Intersection ");
         intersection(list1, list2).printList();
         System.out.print("After Union ");
         union(list1, list2).printList();
     }
 }