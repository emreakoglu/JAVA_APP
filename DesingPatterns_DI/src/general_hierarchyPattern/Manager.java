package general_hierarchyPattern;

import java.util.ArrayList;

public class Manager extends Employe{
	
	ArrayList<Employe> employeList = new ArrayList<Employe>();

	public Manager(String name, int sgkNo) {
		super(name, sgkNo);
	}
	
	public void addEmploye(Employe employe) {
		employeList.add(employe);
		employe.setManager(this);
	}
	
	public ArrayList<Employe> getEmployeList() {
		return employeList;
	}

}
