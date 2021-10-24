package proxyPattern;

public class ProxyPerson implements PersonExObject {
	
	private PersonExObject personExObject = new RealPerson();
	

	@Override
	public void retiredStatus(int age) {
		// TODO Auto-generated method stub
		
		personExObject.retiredStatus(age);

	}
	
	@Override
	public void personHoliday(Person person) {
		// TODO Auto-generated method stub
		
		personExObject.personHoliday(person);
	}

}
