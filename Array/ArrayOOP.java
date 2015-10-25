
public class ArrayOOP {
	
	private long a[];
	private int nElems;
	
	public ArrayOOP(int max)
	{
		a=new long[max];
		nElems=0;
	}
	
	public boolean find(long searchEl)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(a[j]==searchEl)
				break;
		if(j==nElems)
			return false;
		else
			return true;
	}
	
	public void insert(long value)
	{
		a[nElems]=value;
		nElems++;
	}
	
	public boolean delete(long value)
	{
		int j;
		for(j=0;j<nElems;j++)
			if(value==a[j])
				break;
		if(j==nElems)
			return false;  // can't find element
		else
		{
			for(int k=j;k<nElems;k++)
				a[k]=a[k+1];
			nElems--;
			return true;
		}
	}
	
	public void display()
	{
		for(int j=0;j<nElems;j++)
			System.out.print(a[j]+" ");
		System.out.println();
	}

}

class ArrayOOPTest{
	public static void main(String []args)
	{
		ArrayOOP array=new ArrayOOP(100);
		array.insert(22);
		array.insert(55);
		array.insert(10);
		array.insert(5);
		array.insert(90);
		array.insert(71);
		array.insert(32);
		array.insert(65);
		array.display();
		
		int searchEl=65;
		if(array.find(searchEl))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		array.delete(71);
		array.delete(32);
		
		array.display();
	}
}
