//impartirea elementelor in doua grupuri (mai mici, mai mari decat o anumita valoare-pivot)
//O(n) -complexitate
// Algoritmul nu este stabil->elementele nu-si pastreaza pozitia
public class ArrayPart {
	private int[] array;
	private int nElems;
	
	public ArrayPart(int n)
	{
		array=new int[n];
		nElems=0;
	}
	public void insert(int element)
	{
		array[nElems]=element;
		nElems++;
	}
	public int size()
	{
		return nElems;
	}
	public void display()
	{
		int i;
		for(i=0;i<nElems;i++)
			System.out.print(" "+array[i]);
		System.out.println();
	}
	public int partition(int left,int right,int pivot)
	{
		int leftPtr=left-1;
		int rightPtr=right+1;
		while(true)
		{
			while(leftPtr<right && array[++leftPtr]<pivot);//gaseste elementele mai mari, cat timp nu am ajuns la final
			while(rightPtr>left && array[--rightPtr]>pivot);
			if(leftPtr>=rightPtr)
				break;       //partitionarea s-a terminat
			else
				swap(leftPtr,rightPtr);
		}
		return leftPtr;
	}
	
	public void swap(int poz1,int poz2)
	{
		int aux;
		aux=array[poz1];
		array[poz1]=array[poz2];
		array[poz2]=aux;
	}
}
class TestApp{
	public static void main(String []args)
	{
		int nrEl=20;
		ArrayPart arr;
		arr=new ArrayPart(nrEl);
		
		for(int i=0;i<nrEl;i++)
		{
			int n=(int)(Math.random()*100);
			arr.insert(n);
		}
		arr.display();
		
		int pivot=22;
		System.out.print("Pivotul este "+pivot);
		int size=arr.size();
		
		//pana la partPoz elemente mai mici decat pivot, dupa elemente mai mari
		int partPoz=arr.partition(0, size-1, pivot);
		System.out.println(" , partitionare la pozitia "+partPoz);
		arr.display();
	}
}
