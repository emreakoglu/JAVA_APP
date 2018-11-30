package dependencyInjection;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BMV bmv = new BMV();
		Mercebes mercebes = new Mercebes();
		OpeI opeI = new OpeI();
		HybridToyoto toyoto = new HybridToyoto();
		
//		Main main = new Main();
//		
//		main.createMotor(bmv);
//		main.createMotor(mercebes);
//		main.createMotor(opeI);
		
		List<ICarService> carServices = new ArrayList<ICarService>();
		
		carServices.add(bmv);carServices.add(opeI);carServices.add(mercebes);
		carServices.add(toyoto);
		
		CarCreate carCreate = new CarCreate();
		
		carCreate.carMotorCreating(carServices);
		carCreate.carKaportaCreating(carServices);
		carCreate.carDiferansiyelCreating(carServices);
	}
	
	
	public void createMotor(ICarService carService) {
		carService.createMotor();
	}

}
