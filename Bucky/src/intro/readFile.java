package intro;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

public class readFile {
	private Formatter formatter = new Formatter();

	private Scanner scanner;

	public void openFile(){
		try {
			scanner = new Scanner (new File("China.dat"));
			
		} catch (Exception e) {
			System.out.println("Could not find File");}
		}

	public  void read() {
		while (scanner.hasNext()) {
			String a = scanner.next();
			String b = scanner.next();
			String c = scanner.next();
			System.out.printf("%s %s %s\n", a ,b ,c);
		}
		scanner.close();
		

	}

}
