package com.serv;

public class Kullanici {
	private int kullanici_id;
	private String adi;
	private String soyadi;
	private String unvan;
	private String yetki;
	private String username;
	private String password;
	public int getKullanici_id() {
		return kullanici_id;
	}
	public void setKullanici_id(int kullanici_id) {
		this.kullanici_id = kullanici_id;
	}
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
	public String getUnvan() {
		return unvan;
	}
	public void setUnvan(String unvan) {
		this.unvan = unvan;
	}
	public String getYetki() {
		return yetki;
	}
	public void setYetki(String yetki) {
		this.yetki = yetki;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Kullanici(int kullanici_id, String adi, String soyadi, String unvan,
			String yetki, String username, String password) {
		this.kullanici_id = kullanici_id;
		this.adi = adi;
		this.soyadi = soyadi;
		this.unvan = unvan;
		this.yetki = yetki;
		this.username = username;
		this.password = password;
	}
}
