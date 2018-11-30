package observerPattern;

import java.util.List;

import javax.xml.ws.handler.MessageContext;

import java.util.ArrayList;

public class PushNotificationFromServer implements Observable {
	
	String message = "Notification";

	@Override
	public void triggerObserverForNotify(List<Observer> observerList) {
		// TODO Auto-generated method stub
		for (Observer observer : observerList) {
			observer.update(message);
		}
	}

}
