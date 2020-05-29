package staticFinal;

public class FinalMethodExtended extends FinalMethod {

	@Override
	void isOverridable() {
		// TODO Auto-generated method stub
		
		super.isOverridable();
		super.a = ""; // burada deðiþken final olarak tanýmlandýðý için hata verecektir.
		System.out.println(super.a);
	}
	
	

}
