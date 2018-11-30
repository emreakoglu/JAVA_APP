package dependencyInjection;

import java.util.List;

public class CarCreate {	
	
	public void carMotorCreating(List<ICarService> carServices) {
		for (ICarService iCarService : carServices) {
			iCarService.createMotor();
		}
	}
	
	public void carKaportaCreating(List<ICarService> carServices) {
		for (ICarService iCarService : carServices) {
			iCarService.createKaporta();
		}
	}
	
	public void carDiferansiyelCreating(List<ICarService> carServices) {
		for (ICarService iCarService : carServices) {
			iCarService.creeateDiferansiyel();
		}
		
	}
}
