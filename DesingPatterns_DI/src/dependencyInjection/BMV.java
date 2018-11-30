package dependencyInjection;

public class BMV implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		
		System.out.println("BMV için motor üretildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("BMV için kaporta üretildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("BMV için diferansiyel üretildi");
	}

}
