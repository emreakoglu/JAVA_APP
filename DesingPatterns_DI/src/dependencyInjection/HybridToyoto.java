package dependencyInjection;

public class HybridToyoto implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		System.out.println("Elektrikli Motor Totoyo i�in �retildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("Totoyo i�in kaporta �retildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("Totoyo i�in diferansiyel �retildi");
	}

}
