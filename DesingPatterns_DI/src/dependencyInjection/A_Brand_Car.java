package dependencyInjection;

public class A_Brand_Car implements ICarService {

	@Override
	public void createMotor() {
		// TODO Auto-generated method stub
		
		System.out.println("A_Brand_Car i�in motor �retildi");

	}

	@Override
	public void createKaporta() {
		// TODO Auto-generated method stub
		System.out.println("A_Brand_Car i�in kaporta �retildi");
	}

	@Override
	public void creeateDiferansiyel() {
		// TODO Auto-generated method stub
		System.out.println("A_Brand_Car i�in diferansiyel �retildi");
	}

}
