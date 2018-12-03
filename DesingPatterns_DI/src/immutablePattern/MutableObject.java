package immutablePattern;

public class MutableObject implements Immutable_Variable {
	
	private String accesableVariable_1;
	private String accesableVariable_2;
	
	public String getAccesableVariable_1() {
		return accesableVariable_1;
	}
	public void setAccesableVariable_1(String accesableVariable_1) {
		this.accesableVariable_1 = accesableVariable_1;
	}
	public String getAccesableVariable_2() {
		return accesableVariable_2;
	}
	public void setAccesableVariable_2(String accesableVariable_2) {
		this.accesableVariable_2 = accesableVariable_2;
	}
	@Override
	public String getImmutableVariable() {
		// TODO Auto-generated method stub
		return getAccesableVariable_1() + " ve " + getAccesableVariable_2();
	}
	
	

}
