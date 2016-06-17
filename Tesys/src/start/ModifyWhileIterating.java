package start;
import java.util.*;

public class ModifyWhileIterating {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("one");
		list.add("two");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String s = iter.next();
			
			if(s.equals("one")){
				list.add(0, "start");
				//ConcurrentModificationException Error
			}
		}
		
	}

}
