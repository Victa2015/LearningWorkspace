package codeTester;
import java.io.*;
import java.util.*;
public class FileRead {
public static void main(String[] args) {
	PriorityQueue<String> men = new PriorityQueue<String>();
	PriorityQueue<String> women = new PriorityQueue<String>();
	String line = null;
	String file = "dance.txt";
	String sex = "";
	BufferedReader input;
	try {
		input = new BufferedReader(new FileReader(file));
		
		while((line= input.readLine()) != null){
			sex  = line.substring(0, 1);
			if(sex.equals("M")){
				men.add(line.substring(2));
			}else{
				women.add(line.substring(2));
			}
			input.close();
		}
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Error Opening File");
	}
	while (!men.isEmpty() && !women.isEmpty()) {
		System.out.println("The Dance partners will be: ");
		System.out.println(men.poll() + "and" + women.poll());
		
	}
	if (men.isEmpty()) {
		System.out.print("There are "+ women.size());
		System.out.print(" women waiting to dance.");
		System.out.println(women.peek() + "is the next woman dancer");
		
	}
	if (men.isEmpty()) {
		System.out.print("There are "+ men.size());
		System.out.print(" women waiting to dance.");
		System.out.println(men.peek() + "is the next man dancer");
		
	}
}
}
