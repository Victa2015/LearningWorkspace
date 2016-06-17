package intro;

import java.io.*;
import java.lang.*;
import java.util.*;

public class createFile {

	private Formatter formatter;
	//public createFile(){
		
	//}

	public void openFile() {
		try {
			formatter = new Formatter("China.txt");
		} catch (Exception e) {
			System.out.println("Random Error");
		}
	}

	public void addRecords() {
		formatter.format("%d %s %s", 20, "Victor", "Kironde");
	}
	public void closeFile(){
		formatter.close();
	}

}
