package factoryPattern;

public class ComputerFactory {
	
	public static Computer createComputer (Class computerBrand) throws IllegalAccessException, InstantiationException {
		return (Computer) computerBrand.newInstance();
	}

}
