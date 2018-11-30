package dependencyInjection;

public class HybridToyoto implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		System.out.println("Elektrikli Motor Totoyo için üretildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("Totoyo için kaporta üretildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("Totoyo için diferansiyel üretildi");
	}

}
