package generics;

public class ListDriver {
	public static void main(String[] args) {
		List<String> glist = new List<String> (10);
		glist.add("One");
		glist.add("two");
		glist.add("Three");
		System.out.println(glist.toString());
		
		List<Integer> numbers  = new List<Integer>(10);
		numbers.add(5);
		numbers.add(4);
		System.out.println(numbers.toString());
		
	}
	
	
}
