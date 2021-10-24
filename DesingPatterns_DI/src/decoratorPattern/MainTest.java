package decoratorPattern;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IComponent component = new Component();
		System.out.println("Basic Component " + component.operation());
		
		IComponent componentA = new DecoratorA(component);
		System.out.println("Decorator A " + componentA.operation());
		
		IComponent componentB = new DecoratorB(component);
		System.out.println("Decorator B " + componentB.operation());
		
		IComponent componentB_B = new DecoratorB(componentA);
		System.out.println("Decorator B - A " + componentB_B.operation());
		
		DecoratorB b = new DecoratorB(component);
		System.out.println("b.addedState " + b.addedBehavior());
	}

}
