package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class ObserverPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MobilUygulama mobilUygulama = new MobilUygulama();
		
		WebSitesiUygulama sitesiUygulama = new WebSitesiUygulama();
		
		PushNotificationFromServer pushNotificationFromServer = new PushNotificationFromServer();
		
		List<Observer> observerList = new ArrayList<Observer>();
		observerList.add(mobilUygulama);
		observerList.add(sitesiUygulama);
		
		pushNotificationFromServer.triggerObserverForNotify(observerList);

	}

}
