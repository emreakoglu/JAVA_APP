package dependencyInjection;

public class Hybrid_Brand_Car implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		System.out.println("Elektrikli Motor Hybrid_Brand_Car i�in �retildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid_Brand_Car i�in kaporta �retildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid_Brand_Car i�in diferansiyel �retildi");
	}

}
