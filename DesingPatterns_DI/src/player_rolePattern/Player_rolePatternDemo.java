package player_rolePattern;

public class Player_rolePatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Canli kedi = new Etcil_Canli(); // DownCasting

		Canli timsah = new Etcil_Canli();
		
		Canli otYiyenSurungen = new Otcul_Canli();
		
		
		kedi.habitatRole = new KaradaYasayan_HabitatRole(4); // Canlinin Habitat Rolü Tanýmlandý
		kedi.canli_Turu_Role = new Memeli_Canli_Turu_Role(); // Canlinin Tür Rolü Tanýmlandý
		
		timsah.habitatRole = new SudaYasayan_HabitatRole(3);
		timsah.canli_Turu_Role = new Surungen_Canli_Turu_Role();
		
		otYiyenSurungen.habitatRole = new SudaYasayan_HabitatRole(5);
		otYiyenSurungen.canli_Turu_Role = new Surungen_Canli_Turu_Role();
		
		toStringAllMethod(kedi);
		toStringAllMethod(timsah);
		toStringAllMethod(otYiyenSurungen);
		
	}
	
	public static void toStringAllMethod(Canli canli) {
		canli.toStringBeslenmeCesidi();
		canli.habitatRole.doEnerjiUretim();
		canli.habitatRole.doSolunum();
		canli.canli_Turu_Role.beslenme();
	}

}
