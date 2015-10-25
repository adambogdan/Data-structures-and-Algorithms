//BubbleSort - very slow- O(n^2)
//pentru 10 elemente-> 45 comparatii, n*(n-1)/2
// cel mai rau caz sortat descrescator, necesar swap la fiecare comparatie


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
	
	public void bubbleSort()
	{
		int out,in;
		for(out=nElems-1;out>1;out--)
			for(in=0;in<out;in++)
				if(a[in]>a[in+1])
					swap(in,in+1);
	}
}
public class BubbleSort {

	public static void main(String []args)
	{
		int size=50;
		Array ar=new Array(size);
		ar.insert(60);
		ar.insert(0);
		ar.insert(6);
		ar.insert(22);
		ar.insert(14);
		ar.insert(4);
		ar.insert(25);
		ar.insert(15);
		
		ar.display();
		
		ar.bubbleSort();
		
		ar.display();
	}
	
}
