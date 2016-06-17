package runn;
import net.webservicex.*;
public class Run {
	public static void main(String[] args) {
		
			String code;
			Country ug = new Country();
			CountrySoap sa = ug.getCountrySoap();
			String country = sa.getCountries();
			System.out.println(country);
		
	}

}
