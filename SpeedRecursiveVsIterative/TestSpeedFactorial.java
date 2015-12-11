// comparare viteza metoda iterativa-recursiva
// metoda iterativa este mult mai rapida
// m. recursiva=valorile intermediare si valorile de return stocate pe stiva sistemului
//              pentru valori foarte mari => stack overflow!!
import java.util.Scanner;

public class TestSpeedFactorial {
	int numar;
	
	TestSpeedFactorial(int n)
	{
		numar=n;
	}
	public int recursivfactorial(int n)
	{
		if(n==0)
			return 1;
		else
			return n*recursivfactorial(n-1);
	}
	public int factorial(int n)
	{
		int i;
		int fact=1;
		for(i=1;i<=n;i++)
			fact*=i;
		return fact;
	}
}
class TestApp{
	public static void main(String[]args)
	{
		Scanner sc=new Scanner(System.in);
		int numar;
		System.out.println("Introdu numar: ");
		numar=sc.nextInt();
		int output;
		int output_recursiv;
		TestSpeedFactorial fact=new TestSpeedFactorial(numar);
		
		final long startTimeR = System.nanoTime();
		output_recursiv=fact.recursivfactorial(numar);
		System.out.println("Rezultat M.recursiva: "+output_recursiv);
		final long endTimeR = System.nanoTime();
	    System.out.println("Metoda recursiva timp: " + (endTimeR - startTimeR));
		
	    System.out.println();
	    
		final long startTimeI = System.nanoTime();
		output=fact.factorial(numar);
		System.out.println("Rezultat M.iterativa: "+output);
		final long endTimeI = System.nanoTime();
	    System.out.println("Metoda iterativa timp : " + (endTimeI - startTimeI));
		
		sc.close();
	}
}

