import java.util.ArrayList;
import java.util.Scanner;

public class quad {
	
	 int input;
	    static int factorNumber = 1;
	   
	    
    public static void main(String[] args) {
    	 Scanner scanner;
    	scanner = new Scanner(System.in);
        int number;
         System.out.println("Enter a number: ");
         
           number = scanner.nextInt();
           ArrayList<Integer> factors = new ArrayList<Integer>();
        while(factorNumber <= number){
            if(number % factorNumber == 0){
            	factors.add(factorNumber);
                System.out.println(factorNumber + " is a factor of " + number);
            }
            
            factorNumber ++;
            
        }
        System.out.println(factors.size());
    }
}  
