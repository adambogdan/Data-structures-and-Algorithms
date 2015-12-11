// complexitate : O(n*log n)
//numarul de copii , pt 8 elemente 24 de copii necesare log 2 din 8 =3, 8*log2 din 8=24
public class ArrayMSort {

	private int[] array;
	private int nElems;
	
	public ArrayMSort(int size)
	{
		array=new int[size];
		nElems=0;
	}
	
	public void insert(int element)
	{
		array[nElems]=element;
		nElems++;
	}
	
	public void display()
	{
		for(int i=0;i<nElems;i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	
	public void interclasare(int[] result,int lowPtr,int highPtr,int last)
	{
		int i=0;
		int first=lowPtr;
		int mid=highPtr-1;
		int n=last-first+1;
		
		while(lowPtr<=mid && highPtr<=last)
			if(array[lowPtr]<array[highPtr])
				result[i++]=array[lowPtr++];
			else
				result[i++]=array[highPtr++];
			
		while(lowPtr<=mid)
			result[i++]=array[lowPtr++];
			
		while(highPtr<=last)
			result[i++]=array[highPtr++];
			
		for(i=0;i<n;i++)
			array[first+i]=result[i];
	}
	public void mergeSort(int []result,int first,int last)
	{
		if(first==last)
			return;
		else
		{
			int mid=(first+last)/2;
			mergeSort(result,first,mid);
			mergeSort(result,mid+1,last);
			interclasare(result,first,mid+1,last);
		}
	}
	public void callMergeSort()
	{
		int[] result=new int[nElems];
		mergeSort(result,0,nElems-1);
	}
}
class TestApp{
	public static void main(String []args)
	{
		int maxSize=100;
		ArrayMSort ar;
		ar=new ArrayMSort(maxSize);
		
		ar.insert(10);
		ar.insert(12);
		ar.insert(0);
		ar.insert(54);
		ar.insert(22);
		ar.insert(99);
		ar.insert(50);
		
		ar.display();
		
		ar.callMergeSort();
		
		ar.display();
	}
	
}