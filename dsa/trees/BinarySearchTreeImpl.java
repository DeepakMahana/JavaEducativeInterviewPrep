package dsa.trees;

// Class for a binary tree Node
class Node {

    //Variables
    private int data;
    Node leftChild;
    Node rightChild;

    //Constructor  
    Node(int value) {
        this.data = value;
        leftChild = null;
        rightChild = null;
    }

    //Getter-Setter  
    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public int getData() {
        return data;
    }

    public void setData(int value) {
        this.data = value;
    }

    public void setLeftChild(Node left) {
        this.leftChild = left;
    }

    public void setRightChild(Node right) {
        this.rightChild = right;
    }
}

// BST Impl
class BinarySearchTree {

	private Node root;

	public Node getRoot() {
		return root;
    }
    
	public void setRoot(Node root) {
		this.root = root;
	}

	//Iterative Function to insert a value in BST
	public boolean add(int value) {

		//If Tree is empty then insert Root with the given value inside Tree   
		if (isEmpty()) {
			root = new Node(value);
			return true;
		}

		//Starting from root
		Node currentNode = root;

		//Traversing the tree untill valid position to insert the value
		while (currentNode != null) {

			Node leftChild = currentNode.getLeftChild();
			Node rightChild = currentNode.getRightChild();

			//If the value to insert is less than root value then move to left subtree
			//else move to right subtree of root
			//and before moving check if the subtree is null, if it's then insert the value.
			if (currentNode.getData() > value) {
				if (leftChild == null) {
					leftChild = new Node(value);
					currentNode.setLeftChild(leftChild);
					return true;
				}
				currentNode = leftChild;
			} else {
				if (rightChild == null) {
					rightChild = new Node(value);
					currentNode.setRightChild(rightChild);
					return true;
				}
				currentNode = rightChild;
			} //end of else
		} //end of while
		return false;
	}

	//Function to check if Tree is empty or not  
	public boolean isEmpty() 
    {
		return root == null; //if root is null then it means Tree is empty
	}

    //Recursive function to insert a value in BST 
	public Node recursive_insert(Node currentNode, int value) {

		//Base Case
		if (currentNode == null) {
			return new Node(value);
		}

		if (value < currentNode.getData()) {
			//Iterate left sub-tree
			currentNode.setLeftChild(recursive_insert(currentNode.getLeftChild(), value));
		} else if (value > currentNode.getData()) {
			//Iterate right sub-tree
			currentNode.setRightChild(recursive_insert(currentNode.getRightChild(), value));
		} else {
			// value already exists
			return currentNode;
		}

		return currentNode;

	}

    //Function to call recursive insert
	public boolean add_recursive(int value) {
		root = recursive_insert(this.root, value);
		return true;
	}

    //Searches value in BST
	//Either returns the Node with that value or return null
	public Node search(int value) {

		if (isEmpty()) return null; // if tree is empty simply return null

		Node currentNode = this.root;

		while (currentNode != null) {

			if (currentNode.getData() == value) return currentNode; // compare data from current node
			
			if (currentNode.getData() > value) //if data from current node is greater than value
				currentNode = currentNode.getLeftChild(); // then move towards left subtree
			else 
				currentNode = currentNode.getRightChild(); //else move towards right subtree
		}

		System.out.println(value + " Not found in the Tree!");
		return null;
	}

    //Wrapper function for recursive search
	public Node search_rec(int value) {

		if (isEmpty()) return null; // if tree is empty simply return null

		// return the output of the recursive search
		return searchRecursive(root, value);
	}

	//Recursive search function
	public Node searchRecursive(Node currentNode, int value){
		// if node is null or value is found then return node
		if (currentNode==null || currentNode.getData() == value) 
			return currentNode; 
		
		// if value is less than node's data then search left sub-tree 
		if (currentNode.getData() > value){
			return searchRecursive(currentNode.getLeftChild(), value);
		} 
		else{
		// if value is greater than node's data then search right sub-tree 
			return searchRecursive(currentNode.getRightChild(), value); 
		}
	}


	//3 conditions for delete
	//1.node is leaf node.
	//2.node has 1 child.
	//3.node has 2 children.
	boolean delete(int value, Node currentNode) {
       
        if (root == null) {
            return false;
        } 

        Node parent = null; //To Store parent of currentNode
        while(currentNode != null && (currentNode.getData() != value)) {
            parent = currentNode;
            if (currentNode.getData() > value)
                currentNode = currentNode.getLeftChild();
            else
                currentNode = currentNode.getRightChild();
            
        }
       
        if(currentNode == null) {
            return false;
        }
        else if(currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
            //1. Node is Leaf Node
            //if that leaf node is the root (a tree with just root)
            if(root.getData() == currentNode.getData()){
                setRoot(null);
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
				parent.setLeftChild(null);
                return true;
            }
            else{
                parent.setRightChild(null);
                return true;
            }
        } else if(currentNode.getRightChild() == null) {
            
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getLeftChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getLeftChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getLeftChild());
                return true;
            }

        }
        else if(currentNode.getLeftChild() == null) {
            
            if(root.getData() == currentNode.getData()){
                setRoot(currentNode.getRightChild());
                return true;
            }
            else if(currentNode.getData() < parent.getData()){
                parent.setLeftChild(currentNode.getRightChild());
                return true;
            }
            else{
                parent.setRightChild(currentNode.getRightChild());
                return true;
            }
        }
        else {
            //Find Least Value Node in right-subtree of current Node
            Node leastNode = findLeastNode(currentNode.getRightChild());
            //Set CurrentNode's Data to the least value in its right-subtree
            int temp = leastNode.getData();
            delete(temp, root);
            currentNode.setData(temp);
            //Delete the leafNode which had the least value
            return true;
        }

    }

	//Helper function to find least value node in right-subtree of currentNode
	private Node findLeastNode(Node currentNode) {

		Node temp = currentNode;

		while (temp.getLeftChild() != null) {
			temp = temp.getLeftChild();
		}

		return temp;

	}

	//Just for Testing purpose 
	public void printTree(Node current) 
    {
		if (current == null) return;

		System.out.print(current.getData() + ",");
		printTree(current.getLeftChild());
		printTree(current.getRightChild());

	}
}

public class BinarySearchTreeImpl {

	public static void main(String args[]) 
    {
		BinarySearchTree bsT = new BinarySearchTree();

		bsT.add(6);
		bsT.add(4);
		bsT.add(9);
		bsT.add(5);
		bsT.add(2);
		bsT.add(8);
		bsT.add(12);
		bsT.add(10);
		bsT.add(14);
    
		bsT.printTree(bsT.getRoot());

		System.out.print("\nDeleting Node 6: ");
		bsT.delete(6, bsT.getRoot());
		bsT.printTree(bsT.getRoot());

		System.out.print("\nDeleting Node 15: ");
		bsT.delete(15, bsT.getRoot());
		bsT.printTree(bsT.getRoot());

		System.out.print("\nDeleting Node 1: ");
		bsT.delete(1, bsT.getRoot());
		bsT.printTree(bsT.getRoot());
	}
}
