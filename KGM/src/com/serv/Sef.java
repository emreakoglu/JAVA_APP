package com.serv;

public class Sef {
	String adi_soyadi;
	int sef_id;
	int kullanici_id;
	public Sef(String adi_soyadi, int sef_id, int kullanici_id) {
		super();
		this.adi_soyadi = adi_soyadi;
		this.sef_id = sef_id;
		this.kullanici_id = kullanici_id;
	}
	public String getAdi_soyadi() {
		return adi_soyadi;
	}
	public void setAdi_soyadi(String adi_soyadi) {
		this.adi_soyadi = adi_soyadi;
	}
	public int getSef_id() {
		return sef_id;
	}
	public void setSef_id(int sef_id) {
		this.sef_id = sef_id;
	}
	public int getKullanici_id() {
		return kullanici_id;
	}
	public void setKullanici_id(int kullanici_id) {
		this.kullanici_id = kullanici_id;
	}

}
