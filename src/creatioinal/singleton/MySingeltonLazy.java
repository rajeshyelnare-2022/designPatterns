package creatioinal.singleton;


class MySingeltonLazy {
	// Static variable single_instance of type MySingeltonLazy
	private static MySingeltonLazy single_instance = null;

	// Declaring a variable of type String
	public String s;

	// Constructor of this class
	// Here private constructor is used to
	// restricted to this class itself
	private MySingeltonLazy()
	{
		System.out.println("Private Constructor");
		s = "Hello I am a string part of MySingeltonLazy class";
	}


	public static MySingeltonLazy MySingeltonLazy()
	{
		// To ensure only one instance is created
		System.out.println("1");
		if (single_instance == null) {
			System.out.println("2");
			single_instance = new MySingeltonLazy();
		}
		return single_instance;
	}
}


class GFG1 {
	// Main driver method
	public static void main(String args[])
	{
		System.out.println("3");
		MySingeltonLazy x = MySingeltonLazy.MySingeltonLazy();

		// Instantiating MySingeltonLazy class with variable y
		MySingeltonLazy y = MySingeltonLazy.MySingeltonLazy();

		// instantiating MySingeltonLazy class with variable z
		MySingeltonLazy z = MySingeltonLazy.MySingeltonLazy();

		// Now changing variable of instance x
		// via toUpperCase() method
		x.s = (x.s).toUpperCase();

		// Print and display commands
		System.out.println("String from x is " + x.s);
		System.out.println("String from y is " + y.s);
		System.out.println("String from z is " + z.s);
		System.out.println("\n");

		// Now again changing variable of instance x
		z.s = (z.s).toLowerCase();

		System.out.println("String from x is " + x.s);
		System.out.println("String from y is " + y.s);
		System.out.println("String from z is " + z.s);
	}
}
