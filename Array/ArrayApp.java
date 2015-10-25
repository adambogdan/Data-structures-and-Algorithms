
public class ArrayApp {

	public static void main(String [] args)
	{
		long [] arr;
		arr=new long[100];
		int nElems=0;
		int j;
		long searchEl;
		arr[0]=56;
		arr[1]=16;
		arr[2]=22;
		arr[3]=14;
		arr[4]=4;
		arr[5]=25;
		arr[6]=49;
		arr[7]=59;
		nElems=8;
		
		//show items O(n)
		for(j=0;j<nElems;j++)
			System.out.print(arr[j]+" ");
		System.out.println();
		
		//search for an element O(n)
		searchEl=22;
		for(j=0;j<nElems;j++)
			if(arr[j]==searchEl)
				break;
		if(j==nElems)
			System.out.println("Not found "+searchEl);
		else
			System.out.println("Found "+searchEl);
		
		// deletion of an element O(n)
		searchEl=59;
		for(j=0;j<nElems;j++)
			if(arr[j]==searchEl)
				break;
		for(int k=j;k<nElems;k++)
			arr[k]=arr[k+1];
		nElems--;
		
		for(j=0;j<nElems;j++)
			System.out.print(arr[j]+" ");
		System.out.println();		
	}
}
