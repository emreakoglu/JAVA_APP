package abstract_occurrencePattern;

public class Abstract_occurrencePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banka esBank = new Banka("Es Bank",00001,"Uskudar Istanbul");
		
		esBank.subeEkle(new Sube(00011, "Maslak B�y�kdere Caddsesi", "Maslak Sube"));
		
		esBank.subeEkle(new Sube(00012, "�mraniye Alemda� Caddesi","�akmak �ube"));
		
		System.out.println("");

	}

}
