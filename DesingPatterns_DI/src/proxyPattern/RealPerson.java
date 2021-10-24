package proxyPattern;

public class RealPerson implements PersonExObject {

	@Override
	public void retiredStatus(int age) {
		// TODO Auto-generated method stub
		
		if (age > 50) {
			System.out.println("Person is retired");
		}else {
			System.out.println("Person is not retired");
		}
		
	}
	
	@Override
	public void personHoliday(Person person)  {
		// TODO Auto-generated method stub
		
		if (person.getGender().equals("female") && person.getAge() > 25) {
			System.out.println("Kadın ve 25 yaşından büyük olduğu için iyi bir tatile ihtiyaci var");
		}
		
		if (person.getGender().equals("male")) {
			System.out.println("Erkek olduğu için herhagi bir tatile ihitacı var");
		}
		
	}

}
