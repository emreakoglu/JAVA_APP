package casting;

public class Student extends Person {
	
	private int studentID;
	
	public Student(String name, int i) {
		// TODO Auto-generated constructor stub
		this.studentID = i;
		super.name = name;
	}

	public int getStudentID() {
		return studentID;
	}

	@Override
	public String toString() {
		return "Student [studentID=" + studentID + "]";
	}
	
}
