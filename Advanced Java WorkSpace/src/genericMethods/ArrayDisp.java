package genericMethods;

public class ArrayDisp {
	static <T> void Display(T[] arr){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] != null){
				System.out.print(arr[i] + "  ");
				
			}
		}
		
	}
	public static void main(String[] args) {
		String[] names = {"David","Cynthia","Raymond", 
				"Jennifer", "Bryan", "Clayton", "Terrill", "Danny"};
	
		 Display(names);
		 System.out.println();
		 Integer[] numbers = new Integer[]{1,2,3,4,5,6,7,8};
		 Display(numbers);
		 Pair<String, Integer> pair = new Pair<String, Integer>("Victor", 13);
		 
		 
	}
}
