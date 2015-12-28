//Complexitate : Insert, Find, Delete - O(log n)
//N-nr. noduri, L-nr. nivele -> N=2^L-1
// intr-un BST cu 1000 elemente sunt necesare aproximativ 10 comparatii 2^10=1024
//Cel mai rau caz O(n) atunci cand elementele de inserat sunt in ordine crescatoare/descrescatoare-e o lista inlantuita
//BST poate fi reprezentat prin array -> leftChild=2*index+1  , rightChild=2*index+2, parent=(index-1)/2
//Repr. prin array nu e eficienta->nodurile sterse ocupa memorie in array
//
//Daca valorile de inserat sunt partial sortate arborele devine unbalanced.
//Red-Black Trees !!!!
//La inserare respectate regulile:
// 1. fiecare nod este rosu sau negru
// 2. radacina este tot timpul neagra
// 3. daca un nod e rosu atunci copii acestuia au culoarea neagra
// 4. fiecare cale de la radacina la frunze trebuie sa contina acelasi numar de noduri negre. 
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Node{
	public int data;
	public Node leftChild;
	public Node rightChild;
	
	public void displayNode()
	{
		System.out.print("("+data+");");
	}
}

public class Tree {
	
	private Node root;
	
	public Tree()
	{
		root=null;
	}
	public Node returnRoot()
	{
		return root;
	}
	public Node find(int key)
	{
		Node current=root;
		while(current.data!=key)
		{
			if(key<current.data)
				current=current.leftChild;
			else
				current=current.rightChild;
			if(current==null)
				return null;
		}
		return current;
	}

	public void insert(int element) {
		Node newNode = new Node();
		newNode.data = element;
		if (root == null)
			root = newNode;
		else {
			Node current = root;
			Node parent;
			while (true) {
				parent = current;
				if (element < current.data) {
					current = current.leftChild;
					if (current == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					current = current.rightChild;
					if (current == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	private void preOrder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preOrder(root.leftChild);
			preOrder(root.rightChild);
		}
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.leftChild);
			System.out.print(root.data + " ");
			inOrder(root.rightChild);
		}
	}

	private void postOrder(Node root) {
		if (root != null) {
			postOrder(root.leftChild);
			postOrder(root.rightChild);
			System.out.print(root.data + " ");
		}
	}

	public void traverse(int choice) {
		switch (choice) {
		case 1:
			System.out.println("PreOrder ");
			preOrder(root);
			break;
		case 2:
			System.out.println("InOrder ");
			inOrder(root);
			break;
		case 3:
			System.out.println("PostOrder ");
			postOrder(root);
			break;
		}
	}

	public void printTree(Node root) {

        Queue<Node> currentLevel = new LinkedList<Node>();
        Queue<Node> nextLevel = new LinkedList<Node>();

        currentLevel.add(root);

        while (!currentLevel.isEmpty()) {
            Iterator<Node> iter = currentLevel.iterator();
            while (iter.hasNext()) {
                Node currentNode = iter.next();
                if (currentNode.leftChild != null) {
                    nextLevel.add(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    nextLevel.add(currentNode.rightChild);
                }
                System.out.print(currentNode.data + " ");
            }
            System.out.println();
            currentLevel = nextLevel;
            nextLevel = new LinkedList<Node>();

        }

    }
	
	public void printLeafs(Node root)
	{
		if(root!=null)
		{
			printLeafs(root.leftChild);
			printLeafs(root.rightChild);
			if(root.leftChild==null && root.rightChild==null)
				System.out.print(root.data+" ");
		}
	}
	
	public int minimum()
	{
		if(root!=null)
		{
			Node currentNode=root;
			while(currentNode.leftChild!=null)
				currentNode=currentNode.leftChild;
			return currentNode.data;
		}
		else
			return 0;
	}
	
	public int maximum()
	{
		if(root!=null)
		{
			Node currentNode=root;
			while(currentNode.rightChild!=null)
				currentNode=currentNode.rightChild;
			return currentNode.data;
		}
		else
			return 0;
	}
}

class TestTree{
	public static void main(String []args)
	{
		int value;
		Tree tree=new Tree();
		
		//insert
		tree.insert(10);
		tree.insert(7);
		tree.insert(33);
		tree.insert(1);
		tree.insert(89);
		tree.insert(54);
		tree.insert(98);
		tree.insert(2);
		tree.insert(22);
		
		//print tree
		tree.printTree(tree.returnRoot());
		
		//traverse type
		System.out.print("1 - PreOrder\n2 - InOrder\n3 - PostOrder\nEnter choice:\n");
		Scanner sc=new Scanner(System.in);
		value=sc.nextInt();
		tree.traverse(value);
		
		//print leafs
		System.out.println();
		System.out.print("\nLeafs are:");
		tree.printLeafs(tree.returnRoot());
		System.out.println();
		
		//print minimum
		System.out.println();
		System.out.print("Minimul :"+tree.minimum());
		
		//print maximum
		System.out.println();
		System.out.print("Maximul :"+tree.maximum());
		sc.close();
	}
}
