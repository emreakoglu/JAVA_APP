package general_hierarchyPattern;

public class General_hierarchyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Manager manager = new Manager("Manager", 0001);
		
		Employe employe_1 = new Employe("First Employe", 0002);
		Employe employe_2 = new Employe("Second Employe", 0003);
		
		manager.addEmploye(employe_1);
		manager.addEmploye(employe_2);
		
		System.out.println("Manager of Employe_1 " + employe_1.getManager().getName());
		System.out.println("Manager of Employe_2 " + employe_2.getManager().getName());
		
		System.out.print("Employe List under Manager => ");
		
		manager.getEmployeList().forEach(employe->System.out.print(employe.getName()+ ", "));
		
		
		
	}

}
