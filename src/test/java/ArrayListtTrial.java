import java.util.*;
public class ArrayListtTrial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		    ArrayList<String> a = new ArrayList<String> ();
		    a.add("apple");
		    a.add("banana");
		    a.add("cherry");
		    a.add("mango");
		    a.add("apple");
		    System.out.println("Array is-"+a);
		    a.remove("apple");
		    System.out.println("Array is-"+a);
		    System.out.println("Does array contain orange - "+a.contains("orange"));
		    System.out.println("Size of Array"+a.size());
		    for(int i=0; i<a.size();i++) {
		    	System.out.println("array at index "+i+" --> "+a.get(i));
		    }
		    
	}

}
