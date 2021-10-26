package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MobilUygulama mobilUygulama = new MobilUygulama();
		
		WebSitesiUygulama sitesiUygulama = new WebSitesiUygulama();
		
		List<Observer> observerList = new ArrayList<Observer>();
		observerList.add(mobilUygulama);
		observerList.add(sitesiUygulama);
		
		PushNotificationFromServer pushNotificationFromServer = new PushNotificationFromServer();
		pushNotificationFromServer.triggerObserverForNotify(observerList);

	}

}
