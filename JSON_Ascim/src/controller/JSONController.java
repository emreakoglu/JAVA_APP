package controller;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import model.DBConnection;
import model.Tarif;


@Controller
public class JSONController {
	
	
	@RequestMapping(value="/getTarifler/{liste}/{limit}",method=RequestMethod.GET)
	@ResponseBody
	public List<Tarif> getTarifler (@PathVariable String liste,@PathVariable String limit) {
		//int limit = Integer.parseInt(gelenlimit);  // 0 - 10 - 20 - 30
		System.out.println(liste);
		String malzemeler [] = liste.split("[,]");         // select sorgusu ilike bağlacı
		System.out.println(malzemeler.toString());
		String komut = "SELECT * FROM tarifler WHERE ";
		String ek= "";
		for (int i=0;i<malzemeler.length;i++) {
			
			ek = ek +"malzemesi ILIKE '%"+malzemeler[i].trim()+"%'"+" AND ";
		}
		komut = komut + ek.substring(0,ek.length()-5);
		komut = komut + " LIMIT 10 OFFSET "+limit;
		System.out.println(komut);
		List <Tarif> tarifler = new ArrayList<Tarif>();
		
		Connection myConnec;
		PreparedStatement preStat;
		ResultSet result;
		DBConnection mybag = new DBConnection();
		myConnec = mybag.setConnection();
		
		try {
			preStat = myConnec.prepareStatement(komut);
			result = preStat.executeQuery();
			while (result.next()) {
				int id = result.getInt("id");
				String adi = result.getString("adi");
				String tarifi = result.getString("tarifi");
				String malzemesi = result.getString("malzemesi");
				Tarif a = new Tarif(id,adi,tarifi,malzemesi);
				tarifler.add(a);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if (tarifler.size() <= 0) {
			Tarif a = new Tarif (-1,null,null,null);
			tarifler.add(a);
		}
		System.out.println(tarifler.toString());
		return tarifler;
	}
	
	@RequestMapping(value="/random",method=RequestMethod.GET)
	@ResponseBody
	public Tarif random() {
		String komut = "SELECT * FROM tarifler ORDER BY RANDOM() LIMIT 1";
		
		Tarif tarif = null;
		Connection connection;
		PreparedStatement preStat;
		ResultSet resultSet;
		DBConnection mybag = new DBConnection();
		connection = mybag.setConnection();
		
		try {
			preStat = connection.prepareStatement(komut);
			resultSet = preStat.executeQuery();
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String adi = resultSet.getString("adi");
				String tarifi = resultSet.getString("tarifi");
				String malzemesi = resultSet.getString("malzemesi");
				tarif = new Tarif(id,adi,tarifi,malzemesi);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tarif;
	}
	
	@RequestMapping(value="/test",method = RequestMethod.GET)
	@ResponseBody
	public Tarif test() {
		Tarif testTarifi = new Tarif(143,"Deneme Tarifi","Tarif Yapilisi","Tarif Malzemesi");
		return testTarifi;
	}

}
