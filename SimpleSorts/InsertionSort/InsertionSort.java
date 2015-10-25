// O(n^2)
// for data almost sorted, the insertion sort runs in O(n)
// twice as fast as the bubble sort
class Array{
	private long []a;
	private int nElems;
	
	public Array(int max)
	{
		a=new long[max];
		nElems=0;
	}
	
	public void insert(long value)
	{
		a[nElems]=value;
		nElems++;
	}
	
	public void display()
	{
		for(int j=0;j<nElems;j++)
			System.out.print(a[j]+" ");
		System.out.println();
	}
	public void insertionSort()
	{
		int in,out;
		for(out=1;out<nElems;out++)
		{
			long temp=a[out];
			in=out;
			while(in>0 && a[in-1]>=temp)
			{
				a[in]=a[in-1];
				--in;
			}
			a[in]=temp;
		}
	}
}

public class InsertionSort {
	public static void main(String []args)
	{
		int size=50;
		Array ar=new Array(size);
		ar.insert(81);
		ar.insert(1);
		ar.insert(6);
		ar.insert(2);
		ar.insert(145);
		ar.insert(4);
		ar.insert(2);
		ar.insert(15);
		
		ar.display();
		
		ar.insertionSort();
		
		ar.display();
	}
	

}
