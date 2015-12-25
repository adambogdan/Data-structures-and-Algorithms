// complexitate : O(n*log n) 
//in majoritatea situatiilor este cel mai rapid
//dupa partitionare pivotul(aici ultimul element) va fi introdus intre cele doua subarray

public class ArrayQuickS {
	private int[] array;
	private int nElems;
	
	public ArrayQuickS(int nrElem)
	{
		array=new int[nrElem];
		nElems=0;
	}
	
	public void insert(int element)
	{
		array[nElems]=element;
		nElems++;
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
		int rightPtr=right;
		while(true)
		{
			while(leftPtr<right && array[++leftPtr]<pivot);
			while(rightPtr>left && array[--rightPtr]>pivot);
		
			if(leftPtr>=rightPtr)
				break;
			else
				swap(leftPtr,rightPtr);
		}
		swap(leftPtr,right);
		return leftPtr;
	}
	public void swap(int poz1,int poz2)
	{
		int aux;
		aux=array[poz1];
		array[poz1]=array[poz2];
		array[poz2]=aux;
	}
	public void recQuickSort(int left,int right)
	{
		if(right-left<0)
			return;
		else
		{
			int pivot=array[right];//alegere pivot ultimul element
			
			int part=partition(left,right,pivot);
			recQuickSort(left,part-1);//sortare partea stanga
			recQuickSort(part+1,right);//sortare partea dreapta
		}
	}
	public void quickSort()
	{
		recQuickSort(0,nElems-1);
	}
}
class QuickSortApp
{
	public static void main(String[] args)
	{
		int nrEl=15;
		ArrayQuickS arr;
		arr=new ArrayQuickS(nrEl);
		for(int i=0;i<nrEl;i++)
		{
			int element=(int)(Math.random()*100);
			arr.insert(element);
		}
		
		arr.display();
		arr.quickSort();
		arr.display();
	}
}