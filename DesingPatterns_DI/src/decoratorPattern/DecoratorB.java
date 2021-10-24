package decoratorPattern;

public class DecoratorB implements IComponent {
	
	IComponent iComponent;
	public String addedState = "past the coffe shop ";
	
	
	public DecoratorB(IComponent c) {
		this.iComponent = c;
	}

	@Override
	public String operation() {
		// TODO Auto-generated method stub
		String s= this.iComponent.operation();
		s += " to School";
		
		return s;
	}
	
	public String addedBehavior() {
		return " and I bought a cappicuno";
	}

}
