package dependencyInjection;

public class A_Brand_Car implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		
		System.out.println("A_Brand_Car için motor üretildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("A_Brand_Car için kaporta üretildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("A_Brand_Car için diferansiyel üretildi");
	}

}
