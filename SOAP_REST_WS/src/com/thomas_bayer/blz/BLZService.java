/**
 * BLZService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomas_bayer.blz;

public interface BLZService extends javax.xml.rpc.Service {
    public java.lang.String getBLZServiceSOAP11port_httpAddress();

    public com.thomas_bayer.blz.BLZServicePortType getBLZServiceSOAP11port_http() throws javax.xml.rpc.ServiceException;

    public com.thomas_bayer.blz.BLZServicePortType getBLZServiceSOAP11port_http(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
