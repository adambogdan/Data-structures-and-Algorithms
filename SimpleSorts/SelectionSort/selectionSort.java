//selection sort- O(n^2)
// n(n-1)/2 comparatii, dar mai putine swap-uri fata de bubble sort
//

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
	
	public void swap(int x,int y)
	{
		long temp=a[x];
		a[x]=a[y];
		a[y]=temp;
	}
	
	public void selectionSort()
	{
		int min,out,in;
		for(out=0;out<nElems-1;out++)
		{
			min=out;
			for(in=out+1;in<nElems;in++)
				if(a[in]<a[min])
					min=in;
			swap(out,min);
		}
	}
}
public class selectionSort {
	public static void main(String []args)
	{
		int size=50;
		Array ar=new Array(size);
		ar.insert(61);
		ar.insert(1);
		ar.insert(6);
		ar.insert(22);
		ar.insert(14);
		ar.insert(4);
		ar.insert(25);
		ar.insert(15);
		
		ar.display();
		
		ar.selectionSort();
		
		ar.display();
	}

}
