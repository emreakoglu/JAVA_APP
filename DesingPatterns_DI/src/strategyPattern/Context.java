package strategyPattern;

public class Context {
	
	private Strategy strategy;
	
	public Context(Strategy strategy) {
		// TODO Auto-generated constructor stub
		this.strategy = strategy;
	}
	
	int executeStrategy (int number1, int number2) {
		return strategy.doOperation(number1, number2);
	}

}
