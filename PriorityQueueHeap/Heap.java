//Priority Queue - folosind heap - O(1) extragere cel mai mare element
// O(log n) - inserare, stergere
//Heap - arbore binar complet(mai putin ultimul nivel), parintii au cheie mai mare decat fii
//Radacina- cel mai mare element / primul in array
//Sortare folosind heap -> heapsort O(n log n)- la fel ca si quicksort(la quicksort conteaza cum sunt  distribuite elementele in array)


import java.util.Scanner;
public class Heap {

	private Node[] array;
	private int maxSize;
	private int currentSize;
	
	public Heap(int s)
	{
		maxSize=s;
		currentSize=0;
		array=new Node[maxSize];
	}
	
	public boolean isEmpty()
	{
		return currentSize==0;
	}
	
	public boolean insert(int key)
	{
		if(currentSize==maxSize)
			return false;
		Node newNode=new Node(key);
		array[currentSize]=newNode;
		moveUp(currentSize++);
		return true;
	}
	
	public void moveUp(int index)
	{
		int parent=(index-1)/2;
		Node bottom=array[index];
		while(index>0 && array[parent].getKey()<bottom.getKey())
		{
			array[index]=array[parent];
			index=parent;
			parent=(parent-1)/2;
		}
		array[index]=bottom;
	}
	
	public Node remove()
	{
		Node root=array[0];
		array[0]=array[--currentSize];
		moveDown(0);
		return root;
	}
	
	public void moveDown(int index)
	{
		int largerChild;
		Node top=array[index];
		while(index<currentSize/2)
		{
			int leftChild=2*index+1;
			int rightChild=2*index+2;
			if(rightChild<currentSize && array[leftChild].getKey()<array[rightChild].getKey())
				largerChild=rightChild;
			else
				largerChild=leftChild;
			if(top.getKey()>=array[largerChild].getKey())
				break;
			array[index]=array[largerChild];
			index=largerChild;
		}
		array[index]=top;
	}
}
class TestApp
{
	public static void main(String []args)
	{
		Heap heap=new Heap(20);
		boolean inserted;
		Node r=null;
		heap.insert(10);
		heap.insert(99);
		heap.insert(22);
		heap.insert(14);
		heap.insert(25);
		heap.insert(4);
		heap.insert(43);
		
		//inserare
		Scanner sc=new Scanner(System.in);
		System.out.print("Insereaza element: ");
		int val=sc.nextInt();
		inserted=heap.insert(val);
		if(!inserted)
			System.out.println("Nu se poate insera");
		
		//stergere
		if(!heap.isEmpty())
			r=heap.remove();
		System.out.print("Elementul cu val. cea mai mare: "+r.getKey());
		
		sc.close();
		
	}
}
