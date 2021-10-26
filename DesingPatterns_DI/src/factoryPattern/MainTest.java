package factoryPattern;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Asus asus = (Asus) ComputerFactory.createComputer(Asus.class);
			asus.since(1234);
			asus.name();

			Mac mac = (Mac) ComputerFactory.createComputer(Mac.class);
			mac.name();
			System.out.println(mac.toString());
			
			Mac mac2 = (Mac) ComputerFactory.createComputer(Mac.class);
			
			System.out.println(mac2.toString());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
