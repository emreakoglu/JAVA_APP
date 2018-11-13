package com.serv;

public class Ogrenci {
	String adi;
	String soyadi;
	String bolum;
	String fakulte;
	public String getAdi() {
		return adi;
	}
	public void setAdi(String adi) {
		this.adi = adi;
	}
	public String getSoyadi() {
		return soyadi;
	}
	public void setSoyadi(String soyadi) {
		this.soyadi = soyadi;
	}
	public String getBolum() {
		return bolum;
	}
	public void setBolum(String bolum) {
		this.bolum = bolum;
	}
	public String getFakulte() {
		return fakulte;
	}
	public void setFakulte(String fakulte) {
		this.fakulte = fakulte;
	}
	public Ogrenci(String adi, String soyadi, String bolum, String fakulte) {
		super();
		this.adi = adi;
		this.soyadi = soyadi;
		this.bolum = bolum;
		this.fakulte = fakulte;
	}
	

}
