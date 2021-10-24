package decoratorPattern;

public class DecoratorA implements IComponent {
	
	IComponent iComponent;
	
	public DecoratorA(IComponent c) {
		this.iComponent = c;
	}

	@Override
	public String operation() {
		// TODO Auto-generated method stub
		String s = this.iComponent.operation();
		s +=" and sonraki islemler";
		
		return s;
	}

}
