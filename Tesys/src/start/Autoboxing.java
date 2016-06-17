package start;

import java.util.*;

public class Autoboxing {
	//Allows to treat primitives as objects.
	
	public static void main(String[] args) {
		//The Integer.valueOf returns an Integer
		//Generics can help us achieve this too.
		int i = Integer.valueOf("123");
		
		List list = new ArrayList();
		list.add(i);
		int j = (Integer) list.get(0);
	}

}
