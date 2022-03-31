package casting;

public class MainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person s1 = new Student("Hasan", 1111);
		System.out.println(s1.toString());
		
		Person s2 = new Student("Hasan", 1234);
		int a = ((Student) s2).getStudentID(); // casting
		System.out.println(a);
	}

}
