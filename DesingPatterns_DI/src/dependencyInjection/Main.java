package dependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		A_Brand_Car a_brand_car = new A_Brand_Car();
		B_Brand_Car b_brand_car = new B_Brand_Car();
		C_Brand_Car c_brand_car = new C_Brand_Car();
		Hybrid_Brand_Car hybrid_brand_car = new Hybrid_Brand_Car();
		
//		Main main = new Main();
//		
//		main.createMotor(bmv);
//		main.createMotor(mercebes);
//		main.createMotor(opeI);
		
		List<ICarService> carServices = new ArrayList<ICarService>();
		
		carServices.add(a_brand_car);carServices.add(c_brand_car);carServices.add(b_brand_car);
		carServices.add(hybrid_brand_car);
		
		CarCreate carCreate = new CarCreate();
		
		carCreate.carMotorCreating(carServices);
		carCreate.carKaportaCreating(carServices);
		carCreate.carDiferansiyelCreating(carServices);
	}
	
	
	public void createMotor(ICarService carService) {
		carService.createMotor();
	}

}
