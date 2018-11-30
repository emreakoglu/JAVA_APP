package dependencyInjection;

public class Hybrid_Brand_Car implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		System.out.println("Elektrikli Motor Hybrid_Brand_Car için üretildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid_Brand_Car için kaporta üretildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("Hybrid_Brand_Car için diferansiyel üretildi");
	}

}
