package staticFinal;

public class FinalMethodExtended extends FinalMethod {

	@Override
	void isOverridable() {
		// TODO Auto-generated method stub
		
		super.isOverridable();
		super.a = ""; // burada de�i�ken final olarak tan�mland��� i�in hata verecektir.
		System.out.println(super.a);
	}
	
	

}
