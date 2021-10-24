package proxyPattern;

import java.util.List;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PersonExObject personExObject = new ProxyPerson();
		
		List<Person> persons = PersonUtil.mockPersons();
		

		System.out.println("****************************************************************");
		
		
		for (Person person : persons) {
			personExObject.retiredStatus(person.getAge());
			
			personExObject.personHoliday(person);
		}
		
	}

}
