package dependencyInjection;

public class BMV implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		
		System.out.println("BMV i�in motor �retildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("BMV i�in kaporta �retildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("BMV i�in diferansiyel �retildi");
	}

}
