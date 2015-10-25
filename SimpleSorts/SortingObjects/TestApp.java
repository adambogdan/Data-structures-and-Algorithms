//a sort is stable if the order of elements with the same key is retained.
//the algorithm sort only what needs to be sorted,
//and leave everything else in its original order 


public class TestApp {

	public static void main(String []args)
	{
		int size=100;
		ArrayOfObjects arr=new ArrayOfObjects(size);
		arr.insert("Adam", "Bogdan", 22);
		arr.insert("Adam", "Marius", 17);
		arr.insert("Adam", "Jack", 33);
		arr.insert("Willis", "Bruce", 52);
		arr.insert("Travolta", "John", 49);
		
		System.out.println("Before sorting: ");
		arr.display();
		
		arr.insertionSort();
		
		System.out.println("After sorting: ");
		arr.display();
	}
}
