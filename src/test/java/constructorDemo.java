
public class constructorDemo {


	public constructorDemo() {

	} 
	public constructorDemo(String string) {
		System.out.println("I am in string constructor");
	}


	public static void main(String[] Args) {

		// constructorDemo cstring = new constructorDemo("Hello");
		constructorDemo cstring = new constructorDemo();
	}
}
