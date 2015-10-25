// elementele sunt ordonate dupa cheie-valoare, elementul cel mai mic e primul, sau invers.
// cand inserez trebuie sa se mentina ordinea
// pt un numar mic de elemente este de preferat o coada de prioritati
// nr mare de elemente- Heap

public class PriorityQueue {

	private int maxSize;
	private long[] qArray;
	private int nItems;
	
	public PriorityQueue(int s)
	{
		maxSize=s;
		qArray=new long[maxSize];
		nItems=0;
	}
	
	public void insert(long el)
	{
		int j;
		
		if(nItems==0)            // daca nu am elemente pun pe 0
			qArray[nItems++]=el;  
		else
		{
			for(j=nItems-1;j>=0;j--)
			{
				if(el>qArray[j])
					qArray[j+1]=qArray[j];
				else
					break;                    //ma opresc la elementul mai mic, fol. j
			}
			//System.out.println("j:"+j);
			qArray[j+1]=el;
			nItems++;
		}
	}
				
	public long remove()
	{
		return qArray[--nItems];
	}
	
	public boolean isEmpty()
	{
		return (nItems==0);
	}
	
	public boolean isFull()
	{
		return (maxSize==nItems);
	}
}

class TestPriorityQueue
{
	public static void main(String []args) 
	{
		PriorityQueue pq=new PriorityQueue(10);
		pq.insert(3);
		pq.insert(5);
		pq.insert(2);
		
		while(!pq.isEmpty())
		{
			long item=pq.remove();
			System.out.print(item+" ");
		}
	}
}
