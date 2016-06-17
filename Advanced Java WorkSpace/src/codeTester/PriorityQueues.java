package codeTester;

import java.util.*;

public class PriorityQueues {
	public static void main(String[] args) {
		PriorityQueue<String> line = new PriorityQueue<String>();
		line.add("Victor");
		line.add("Emma");
		line.add("Nabil");
		line.add("Timo");
		line.add("Muha");

		System.out.println("The Line: ");
		for (String name : line) {
			System.out.println(name);
		}
		System.out.println();
		line.poll();
		
		System.out.println("The Line: after poll()");

		for (String name : line) {
			System.out.println(name);
		}
		System.out.println();
		line.remove();
		System.out.println("The Line: after remove()");
		for (String name : line) {
			System.out.println(name);
		}
		System.out.println();
		System.out.println("The head: " + line.peek());
	}
}
