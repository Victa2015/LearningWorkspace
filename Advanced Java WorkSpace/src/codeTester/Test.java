package codeTester;

import java.util.*; // Import the java.util package

public class Test {

	public static void main(String[] args) {
		TreeSet<String> ts = new TreeSet<String>();
		
		ts.add("Victor");
		ts.add("Nabil");
		ts.add("Emma");
		ts.add("Timo");
		ts.add("Muha");
		
		System.out.println("tree set size = " + ts.size());
		// Use enhanced for loop to iterate over the collection
		for (Object o : ts) {
			System.out.println(o); // Print element
		}
		System.out.println();
		System.out.println("Name before Victor: " + ts.lower("Victor"));
		System.out.println("Name after Emma: " + ts.higher("Emma"));
		System.out.println("FirstElement: " + ts.first());
		System.out.println("LastElement: " + ts.last());
	}
}
