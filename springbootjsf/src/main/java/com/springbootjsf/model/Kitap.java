package com.springbootjsf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "adaGoreKitaplar", query ="SELECT b FROM Kitap b WHERE b.adi = 'Katre-i Matem'")
public class Kitap {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String adi;
	
	private String yazari;
	
	
	@Column(length = 1500)
	private String aciklama;
	
	private String isbn;
	
	private float fiyat;
	
	private int sayfa;
	
	
	public Kitap() {
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAdi() {
		return adi;
	}


	public void setAdi(String adi) {
		this.adi = adi;
	}


	public String getYazari() {
		return yazari;
	}


	public void setYazari(String yazari) {
		this.yazari = yazari;
	}


	public String getAciklama() {
		return aciklama;
	}


	public void setAciklama(String aciklama) {
		this.aciklama = aciklama;
	}


	public String getIsbn() {
		return isbn;
	}


	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}


	public float getFiyat() {
		return fiyat;
	}


	public void setFiyat(float fiyat) {
		this.fiyat = fiyat;
	}


	public int getSayfa() {
		return sayfa;
	}


	public void setSayfa(int sayfa) {
		this.sayfa = sayfa;
	}


	public Kitap(Long id, String adi, String yazari, String aciklama, String isbn, float fiyat, int sayfa) {
		super();
		this.id = id;
		this.adi = adi;
		this.yazari = yazari;
		this.aciklama = aciklama;
		this.isbn = isbn;
		this.fiyat = fiyat;
		this.sayfa = sayfa;
	}
	
	

}
