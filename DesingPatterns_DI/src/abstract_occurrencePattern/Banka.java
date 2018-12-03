package abstract_occurrencePattern;

import java.util.ArrayList;

public class Banka {
	
	String bankaAdi;
	int globalNo;
	String merkezAdres;
	
	ArrayList<Sube> subeListe = new ArrayList<Sube>();
	
	public Banka(String bankaAdi, int globalNo,String merkezAdres) {
		this.bankaAdi = bankaAdi;
		this.globalNo = globalNo;
		this.merkezAdres = merkezAdres;
	}
	
	public void subeEkle(Sube sube) {
		subeListe.add(sube);
	}

}
