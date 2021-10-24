package strategyPattern;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Context context = new Context(new ToplamaClass());
		System.out.println("10 + 5 = " + context.executeStrategy(10, 5));
		
		context = new Context(new CikarmaClass());
		System.out.println("10 - 5 = " + context.executeStrategy(10, 5));
		
		context = new Context(new CarpmaClass());
		System.out.println("10 * 5 = " + context.executeStrategy(10, 5));

	}

}
