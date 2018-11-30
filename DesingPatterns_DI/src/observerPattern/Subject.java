package observerPattern;

import java.util.ArrayList;
import java.util.List;

public class Subject {  // Duyurunun kendisi

	private List<Observer> observers = new ArrayList<Observer>(); // Observer bir mobil ugulamada olabilir, dolaysýyla tüm herkese push notification gidecek 
	
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) { // yeni bir duyuru geldi, tüm observerlar uyarýlacaklar.
		this.state = state;
		notifyAllObservers();
	}

	public void attach(Observer observer) { // yeni bir kiþi uygulama yüklediyse observer olarak eklenmelidir.
		observers.add(observer);
	}

	public void notifyAllObservers() { // tüm observerlar uyarýlýyor
		for (Observer observer : observers) {
			observer.update();
		}
	}

}
