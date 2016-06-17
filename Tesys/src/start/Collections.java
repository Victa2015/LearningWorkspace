package start;
import java.util.*;

public class Collections {
	public static void print(Collection c){
		Iterator iter  = c.iterator();
		while(iter.hasNext()){
			Object o = iter.next();
			System.out.println(o);
			
		}
	}
	
	public static void main(String []args){
		Collection c = new ArrayList();
		c.add("One");
		c.add("two");
		c.add("Three");
		print(c);
		System.out.println("");
		
		Set set = new HashSet(c);
		set.add("two");
		set.add("Five");
		print(set);
	}

}
