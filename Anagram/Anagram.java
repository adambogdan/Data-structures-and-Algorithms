import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//anagrama-daca string-urile contin aceleasi litere

public class Anagram {

	public static boolean isAnagram(String s1,String s2)
	{
		if(s1.length()!=s2.length())
			return false;
		char [] c1=s1.toCharArray();
		char [] c2=s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		String ss1=new String(c1);
		String ss2=new String(c2);
		return ss1.equals(ss2);
	}
	public static void main(String args[]) throws IOException
	{
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		
		System.out.print("First String:");
		String s1=br.readLine();
		System.out.print("Second String:");
		String s2=br.readLine();
		
		boolean check=isAnagram(s1,s2);
		System.out.print(check);
	}
}
