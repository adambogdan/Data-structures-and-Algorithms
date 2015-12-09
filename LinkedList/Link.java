// 
public class Link {
	public int data;
	public Link next; //reference to another link, not an object
	
	public Link(int _data)
	{
		data=_data;
	}
	public void displayLink()
	{
		System.out.println("Valoarea: "+data);
	}
}


