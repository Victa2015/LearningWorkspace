package codeTester;
import java.net.*;
import java.io.*;
public class socketIntro{
	
	public static void main(String[] args) throws Exception {
		Socket sock = new Socket("whois.internic.com", 43);
		InputStream input = sock.getInputStream();
		OutputStream output =  sock.getOutputStream();
		String strng =  "google.com\n";
		byte buffer[] = strng.getBytes();
		output.write(buffer);
		int ch;
		while ((ch = input.read()) != -1){
			System.out.print((char) ch);
		}
		sock.close();
		
	}

}
