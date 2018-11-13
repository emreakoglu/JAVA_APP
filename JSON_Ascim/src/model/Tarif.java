package model;

public class Tarif {
	
	  private int id;
	  private String adi;
	  private String tarifi;
	  private String malzemesi;
	  
	  public Tarif(int id, String adi, String tarifi, String malzemesi) {
			super();
			this.id = id;
			this.adi = adi;
			this.tarifi = tarifi;
			this.malzemesi = malzemesi;
		}
		  
	  
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getTarifi() {
		return tarifi;
	}
	public void setTarifi(String tarifi) {
		this.tarifi = tarifi;
	}
	public String getMalzemesi() {
		return malzemesi;
	}
	public void setMalzemesi(String malzemesi) {
		this.malzemesi = malzemesi;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.adi+ " " + this.malzemesi+ " " + this.tarifi + " " + this.id;
	}
	
	

}
