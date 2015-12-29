// Tabele de dispersie- inserare, cautare - O(1)
//coliziuni- pentru mai multe elemente fct de mapare indica aceeasi poz. in array
// Solutie : 
//1.open addressing - se cauta in array urmatoarea pozitie libera
//2. separate chaining !!!!-folosind liste , cand are loc o coliziune noul element este inserat in lista de la indexul respectiv
import java.util.Random;
import java.util.Scanner;

public class HashTable {

	private List[] array;
	private int arraySize;
	
	public HashTable(int size)
	{
		arraySize=size;
		array=new List[arraySize];
		for(int i=0;i<arraySize;i++)
			array[i]=new List();
	}
	
	public void displayTable()
	{
		for(int i=0; i<arraySize;i++)
		{
			System.out.print(i+". ");
			array[i].DisplayList();
		}
	}
	
	public int hash(int key)
	{
		return key%arraySize;
	}
	
	public void insert(Link link)
	{
		int key=link.getKey();
		int hashVal=hash(key);
		array[hashVal].insert(link);
	}
	
	public void delete(int key)
	{
		int hashVal=hash(key);
		array[hashVal].delete(key);
	}
	
	public Link find(int key)
	{
		int hashVal=hash(key);
		Link link=array[hashVal].find(key);
		return link;
	}
}

class HashTableApp
{
	public static void main(String [] args)
	{
		Link element;
		int size,nrEl;
		Scanner sc=new Scanner(System.in);
		System.out.print("Introduceti dimensiunea tabelei: ");
		size=sc.nextInt();
		System.out.print("Introduceti numarul de elemente: ");
		nrEl=sc.nextInt();
		
		HashTable htb=new HashTable(size);
		
		//inserare
		for(int i=0;i<nrEl;i++)
		{
			//generare random elemente intre 1 si 100
			Random rand=new Random();
			int key=rand.nextInt((100 - 1) + 1) + 1;
			element=new Link(key);
			htb.insert(element);
		}
		
		htb.displayTable();
		
		//inserare element
		System.out.print("Insereaza un element: ");
		int elIns=sc.nextInt();
		element=new Link(elIns);
		htb.insert(element);
		htb.displayTable();
		
		//stergere element
		System.out.print("Sterge un element: ");
		int elDeSters=sc.nextInt();
		htb.delete(elDeSters);
		htb.displayTable();
		
		System.out.print("Cauta un element: ");
		int elCautat=sc.nextInt();
		element=htb.find(elCautat);
		if(element!=null)
			System.out.println("A fost gasit "+elCautat);
		else
			System.out.println("Nu a fost gasit "+elCautat);
		
		sc.close();
	}
}