package codeTester;

public class EchoClient {
	public static void main(String[] args) {
		EchoClient ec = new EchoClient();
		
//		one(ec.two("orb"));
//		one(ec.five(3.4));
//		one(ec.four("n"));
		one(34);
		one(3.4);
		one("What's up");
		one('c');
		one(ec);
		one('c');
		
	}

	public static void one(Object t) {
		//System.out.println(t.getClass());
		if(t instanceof Integer){
			System.out.println("This is an integer");
		}if(t instanceof EchoClient){
			System.out.println("This is from " + t.hashCode());
			t.hashCode();
		}
	}

}
