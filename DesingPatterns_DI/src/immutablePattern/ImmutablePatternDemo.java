package immutablePattern;

import javax.print.attribute.standard.PrinterIsAcceptingJobs;

public class ImmutablePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MutableObject mutableObject = new MutableObject();
		
		mutableObject.setAccesableVariable_1("Deðiþken 1");
		mutableObject.setAccesableVariable_2("Deðiþken 2");
		
		
		printAccessableVariable(mutableObject);

	}
	
	
	public static void printAccessableVariable(Immutable_Variable object) {
		System.out.println(object.getImmutableVariable());
	}

}
