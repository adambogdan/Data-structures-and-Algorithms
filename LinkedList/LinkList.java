
public class LinkList {
	private Link first;
	
	public LinkList()
	{
		first=null;
	}
	public boolean isEmpty()
	{
		return (first==null);
	}
	public void insertFirst(int _data)
	{
		Link newLink=new Link(_data);
		newLink.next=first;
		first=newLink;
	}
	public Link deleteFirst()
	{
		Link temp=first;
		first=first.next;
		return temp;
	}
	public void displayList()
	{
		System.out.println("Primul -> Ultimul");
		Link current=first;
		while(current!=null)
		{
			current.displayLink();
			current=current.next;
		}
		System.out.println();
	}
	public Link find(int element)
	{
		Link current=first;
		while(current.data!=element)
		{
			if(current.next==null)
				return null;
			else
				current=current.next;
		}
		return current;
	}
	public Link delete(int element)
	{
		Link current=first;
		Link previous=first;
		while(current.data!=element)
		{
			if(current.next==null)
				return null;
			else
			{
				previous=current;
				current=current.next;
			}
		} 
		if(current==first)  // el. de sters era primul,mut capul
			first=first.next;
		else
			previous.next=current.next; // legatura intre vecinii elementului sters
		return current;
	}
}
class LinkListTest
{
	public static void main(String []args)
	{
		LinkList list=new LinkList();
		
		list.insertFirst(4);
		list.insertFirst(22);
		list.insertFirst(19);
		list.insertFirst(55);
		list.insertFirst(40);
		
		//list.displayList();
		
		list.deleteFirst();
		list.displayList();
		list.delete(4);
		
		list.displayList();
		
	}
}
