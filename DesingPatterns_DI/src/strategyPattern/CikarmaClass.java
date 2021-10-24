package strategyPattern;

public class CikarmaClass implements Strategy {

	@Override
	public int doOperation(int number1, int number2) {
		// TODO Auto-generated method stub
		return number1 - number2;
	}

}
