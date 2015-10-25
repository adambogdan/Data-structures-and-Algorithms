
//Binary Search - O(log n)
// array sortat
public class BinarySearch {

	private long []a;
	private int nElems;
	
	public BinarySearch(int max)
	{
		a=new long[max];
		nElems=0;
	}
	
	public int size()
	{
		return nElems;
	}
	
	//inserare in array ordonat - O(n)
	public void insert(long value)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]>value)
				break;
		for(int k=nElems;k>j;k--)
			a[k]=a[k-1];
		a[j]=value;
		nElems++;
	}
	
	
	//O(log n)
	public int binarySearch(long searchEl)
	{
		int lowerBound=0;
		int upperBound=nElems-1;
		int curIndex;
		
		while(true)
		{
			curIndex=(lowerBound+upperBound)/2;
			if(a[curIndex]==searchEl)
				return curIndex;
			else if(lowerBound>upperBound)
					return nElems;
				else
				{
					if(a[curIndex]<searchEl)
						lowerBound=curIndex+1;
					else
						upperBound=curIndex-1;
				}
		}		
	}
	public void display()
	{
		for(int j=0;j<nElems;j++)
			System.out.print(a[j]+" ");
		System.out.println();
	}
}

class Test{
	public static void main(String []args)
	{
		BinarySearch arr=new BinarySearch(100);
		arr.insert(22);
		arr.insert(65);
		arr.insert(90);
		arr.insert(45);
		arr.insert(1);
		arr.insert(100);
		arr.insert(93);
		
		int searchEl=93;
		if(arr.binarySearch(searchEl)!=arr.size())
			System.out.println("Found "+searchEl);
		else
			System.out.println("Not found "+searchEl);
		
		arr.display();
	}
}
