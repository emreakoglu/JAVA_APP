package com.serv;

public class Incele {
	String tur;
	String aciklama;
	String tarih;
	int tutanak_id;
	public Incele(String tarih) {
		super();
		this.tarih = tarih;
	}
	public int getTutanak_id() {
		return tutanak_id;
	}
	public void setTutanak_id(int tutanak_id) {
		this.tutanak_id = tutanak_id;
	}
	public Incele(int tutanak_id) {
		super();
		this.tutanak_id = tutanak_id;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public String getTur() {
		return tur;
	}
	public void setTur(String tur) {
		this.tur = tur;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public Incele(String tur, String aciklama,String tarih,int tutanak_id) {
		super();
		this.tur = tur;
		this.aciklama = aciklama;
		this.tarih = tarih;
		this.tutanak_id = tutanak_id;
	}
	

}
