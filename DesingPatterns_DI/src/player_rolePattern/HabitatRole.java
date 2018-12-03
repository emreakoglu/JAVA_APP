package player_rolePattern;

public abstract class HabitatRole {
	
	int yas;
	
	public HabitatRole(int yas) {
		this.yas = yas;
	}
	
	public abstract void doSolunum();
	
	public void doEnerjiUretim () {
		System.out.println("Her canlý enerji üretir.");
	}

}
