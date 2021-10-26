package factoryPattern;

public class Mac implements Computer {

	@Override
	public void name() {
		// TODO Auto-generated method stub
		System.out.println("Bilgisayarın Markası Mac");
	}

	@Override
	public void since(int year) {
		// TODO Auto-generated method stub
		System.out.println(year + " senesinde alınmış.");
	}

}
