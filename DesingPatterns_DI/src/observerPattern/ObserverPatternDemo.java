package observerPattern;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Subject subject = new Subject(); // yeni bir duyuru geldi

		new HexaObserver(subject); // bu yeni duyuru ile observerlar oluþturuldu
		new OctalObserver(subject);
		new BinaryObserver(subject);

		System.out.println("First state change: 15");
		subject.setState(15); // observarler tek tek uyarýldý
		System.out.println("Second state change: 10");
		subject.setState(10);

	}

}
