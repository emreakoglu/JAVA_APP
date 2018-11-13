package com.serv;

public class TutanakExample {
	private int tutanak_id;
	private int kategori_id;
	private String adres;
	private String aciklama;
	private boolean onay;
	private String kullanici;
	private int resim_tablosu_id;
	private String tarih;
	private String kategori;
	public String getKategori(){
		return kategori;
	}
	public void setKategori(String kategori){
		this.kategori=kategori;
	}
	public int getTutanak_id() {
		return tutanak_id;
	}
	public void setTutanak_id(int tutanak_id) {
		this.tutanak_id = tutanak_id;
	}
	public int getKategori_id() {
		return kategori_id;
	}
	public void setKategori_id(int kategori_id) {
		this.kategori_id = kategori_id;
	}
	public String getAdres() {
		return adres;
	}
	public void setAdres(String adres) {
		this.adres = adres;
	}
	public String getAciklama() {
		return aciklama;
	}
	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}
	public boolean isOnay() {
		return onay;
	}
	public void setOnay(boolean onay) {
		this.onay = onay;
	}
	public String getKullanici() {
		return kullanici;
	}
	public void setKullanici(String kullanici) {
		this.kullanici = kullanici;
	}
	public int getResim_tablosu_id() {
		return resim_tablosu_id;
	}
	public void setResim_tablosu_id(int resim_tablosu_id) {
		this.resim_tablosu_id = resim_tablosu_id;
	}
	public String getTarih() {
		return tarih;
	}
	public void setTarih(String tarih) {
		this.tarih = tarih;
	}
	public TutanakExample(int tutanak_id, int kategori_id, String adres,
			String aciklama, boolean onay, String kullanici,
			int resim_tablosu_id, String tarih,String kategori) {
		super();
		this.tutanak_id = tutanak_id;
		this.kategori_id = kategori_id;
		this.adres = adres;
		this.aciklama = aciklama;
		this.onay = onay;
		this.kullanici = kullanici;
		this.resim_tablosu_id = resim_tablosu_id;
		this.tarih = tarih;
		this.kategori=kategori;
	}

}
