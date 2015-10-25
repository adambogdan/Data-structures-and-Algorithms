
// O(1) , First-In-First-Out
public class Queue {
	
	private int maxSize;
	private long []qArray;
	private int front;
	private int tail;
	private int nItems;
	
	public Queue(int s)
	{
		maxSize=s;
		qArray=new long[maxSize];
		front=0;
		tail=-1;
		nItems=0;
	}
	
	public void insert(long el)
	{
		if(tail==maxSize-1)
			tail=-1;
		qArray[++tail]=el;  // increment apoi insert
		nItems++;
	}
	
	public long remove()
	{
		long temp=qArray[front++]; //iau val apoi increment
		if(front==maxSize)
			front=0;
		nItems--;
		return temp;
	}
	
	public long top()
	{
		return qArray[front];
	}
	
	public boolean isEmpty()
	{
		return (nItems==0);
	}
	
	public boolean isFull()  // true daca e plina
	{
		return (nItems==maxSize);
	}
	
	public int size()
	{
		return nItems;
	}
}

class QueueApp
{
	public static void main(String []args)
	{
		Queue q=new Queue(10);
		
		q.insert(1);
		q.insert(2);
		q.insert(3);
		q.insert(4);
		q.insert(5);
		
		q.remove();
		q.remove();
		
		q.insert(6);
		
		while(!q.isEmpty())
		{
			long el=q.remove();
			System.out.print(el+" ");
			
		}
	}
}

