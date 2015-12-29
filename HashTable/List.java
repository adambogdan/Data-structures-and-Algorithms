
public class List {
	
	private Link first;
	
	public void List()
	{
		first=null;
	}
	//inserare in ordine
	public void insert(Link el)
	{
		int key=el.getKey();
		Link previous=null;
		Link current=first;
		
		while(current!=null && key>current.getKey())
		{
			previous=current;
			current=current.next;
		}
		
		if(previous==null)
			first=el;
		else
			previous.next=el;
		el.next=current;
	}
	
	public void delete(int key)
	{
		Link previous=null;
		Link current=first;
		
		while(current!=null && key!=current.getKey())
		{
			previous=current;
			current=current.next;
		}
		if(previous==null)
			first=first.next;
		else
			previous.next=current.next;
	}
	
	public Link find(int key)
	{
		Link current=first;
		
		while(current!=null && current.getKey()<=key)
		{
			if(current.getKey()==key)
				return current;
			current=current.next;
		}
		return null;
	}
	
	public void DisplayList()
	{
		Link current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
		System.out.println();
	}
}
