package general_hierarchyPattern;

public class Employe {
	
	String name;
	int sgkNo;
	
	Manager manager;

	public Employe(String name, int sgkNo) {
		super();
		this.name = name;
		this.sgkNo = sgkNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSgkNo() {
		return sgkNo;
	}

	public void setSgkNo(int sgkNo) {
		this.sgkNo = sgkNo;
	}

	public Employe getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	

}
