package observerPattern;

public class WebSitesiUygulama implements Observer {

	@Override
	public void update(String message) {
		// TODO Auto-generated method stub
		System.out.println("Web Sitesi Uygulamasına Bildirim Geldi " + message);
	}

}
