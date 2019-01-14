package com.service.client;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Iterator;

import javax.xml.messaging.Endpoint;
import javax.xml.namespace.QName;
import javax.xml.rpc.Call;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.rpc.encoding.TypeMappingRegistry;
import javax.xml.rpc.handler.HandlerRegistry;

import org.apache.axis.AxisFault;

import com.thomas_bayer.blz.BLZServiceLocator;
import com.thomas_bayer.blz.BLZServiceSOAP11BindingStub;
import com.thomas_bayer.blz.DetailsType;

public class Tho_Bay_Client {
	
	public static void main(String[] args) throws AxisFault, MalformedURLException, ServiceException{
		
		BLZServiceLocator blzServiceLocator = new BLZServiceLocator();
		java.net.URL url = new URL(blzServiceLocator.getBLZServiceSOAP11port_httpAddress());
		
		BLZServiceSOAP11BindingStub bindingStub = new BLZServiceSOAP11BindingStub(url, blzServiceLocator);
		try {
			
			DetailsType bankDetail = bindingStub.getBank("10000000");
			System.out.println(bankDetail.getBezeichnung());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
