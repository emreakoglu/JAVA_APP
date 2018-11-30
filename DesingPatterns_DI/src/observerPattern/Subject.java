package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {  // Duyurunun kendisi

	private List<Observer> observers = new ArrayList<Observer>(); // Observer bir mobil ugulamada olabilir, dolays�yla t�m herkese push notification gidecek 
	
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) { // yeni bir duyuru geldi, t�m observerlar uyar�lacaklar.
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) { // yeni bir ki�i uygulama y�klediyse observer olarak eklenmelidir.
		observers.add(observer);
	}

	public void notifyAllObservers() { // t�m observerlar uyar�l�yor
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
