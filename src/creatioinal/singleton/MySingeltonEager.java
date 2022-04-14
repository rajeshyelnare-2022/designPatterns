package creatioinal.singleton;

public class MySingeltonEager {	
		private static MySingeltonEager single_instance = null;
		public String s;
    	private MySingeltonEager()
		{
    		System.out.println("Private constructor");
			s = "Hello I am a string part of MySingeltonEager class";
		}
		public static MySingeltonEager getInstance()
		{
			System.out.println("1");
			if (single_instance == null)
				single_instance = new MySingeltonEager();

			return single_instance;
		}
	}


	class GFG {
		// Main driver method
		public static void main(String args[])
		{
			System.out.println("2");
			MySingeltonEager x = MySingeltonEager.getInstance();

			MySingeltonEager y = MySingeltonEager.getInstance();

			MySingeltonEager z = MySingeltonEager.getInstance();

			System.out.println("Hashcode of x is "
							+ x.hashCode());
			System.out.println("Hashcode of y is "
							+ y.hashCode());
			System.out.println("Hashcode of z is "
							+ z.hashCode());

			if (x == y && y == z) {			
				System.out.println(
					"Three objects point to the same memory location on the heap i.e, to the same object");
			}
			else {
				System.out.println(
					"Three objects DO NOT point to the same memory location on the heap");
			}
		}
	

}
