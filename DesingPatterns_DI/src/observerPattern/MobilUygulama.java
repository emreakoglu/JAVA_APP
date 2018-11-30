package observerPattern;

public class MobilUygulama implements Observer {

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		System.out.println("Mobil Uygulamaya Bildirim Geldi " + message);
	}

}
