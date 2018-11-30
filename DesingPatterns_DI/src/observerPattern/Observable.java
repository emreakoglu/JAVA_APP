package observerPattern;

import java.util.List;

public interface Observable {
	
	public void triggerObserverForNotify(List<Observer> observerList);

}
