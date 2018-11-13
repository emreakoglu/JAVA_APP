package com.serv;

public class Taraf {
	String adi;
	String soyadi;
	String baba_adi;
	String dogum_yeri; 
	String ikametkah;
	String tel_no;
	public Taraf(String adi, String soyadi, String baba_adi, String dogum_yeri,
			String ikametkah, String tel_no) {
		super();
		this.adi = adi;
		this.soyadi = soyadi;
		this.baba_adi = baba_adi;
		this.dogum_yeri = dogum_yeri;
		this.ikametkah = ikametkah;
		this.tel_no = tel_no;
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
	public String getBaba_adi() {
		return baba_adi;
	}
	public void setBaba_adi(String baba_adi) {
		this.baba_adi = baba_adi;
	}
	public String getDogum_yeri() {
		return dogum_yeri;
	}
	public void setDogum_yeri(String dogum_yeri) {
		this.dogum_yeri = dogum_yeri;
	}
	public String getIkametkah() {
		return ikametkah;
	}
	public void setIkametkah(String ikametkah) {
		this.ikametkah = ikametkah;
	}
	public String getTel_no() {
		return tel_no;
	}
	public void setTel_no(String tel_no) {
		this.tel_no = tel_no;
	}
	

}
