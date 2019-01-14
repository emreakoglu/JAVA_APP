/**
 * DetailsType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.thomas_bayer.blz;

public class DetailsType  implements java.io.Serializable {
    private java.lang.String bezeichnung;

    private java.lang.String bic;

    private java.lang.String ort;

    private java.lang.String plz;

    public DetailsType() {
    }

    public DetailsType(
           java.lang.String bezeichnung,
           java.lang.String bic,
           java.lang.String ort,
           java.lang.String plz) {
           this.bezeichnung = bezeichnung;
           this.bic = bic;
           this.ort = ort;
           this.plz = plz;
    }


    /**
     * Gets the bezeichnung value for this DetailsType.
     * 
     * @return bezeichnung
     */
    public java.lang.String getBezeichnung() {
        return bezeichnung;
    }


    /**
     * Sets the bezeichnung value for this DetailsType.
     * 
     * @param bezeichnung
     */
    public void setBezeichnung(java.lang.String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }


    /**
     * Gets the bic value for this DetailsType.
     * 
     * @return bic
     */
    public java.lang.String getBic() {
        return bic;
    }


    /**
     * Sets the bic value for this DetailsType.
     * 
     * @param bic
     */
    public void setBic(java.lang.String bic) {
        this.bic = bic;
    }


    /**
     * Gets the ort value for this DetailsType.
     * 
     * @return ort
     */
    public java.lang.String getOrt() {
        return ort;
    }


    /**
     * Sets the ort value for this DetailsType.
     * 
     * @param ort
     */
    public void setOrt(java.lang.String ort) {
        this.ort = ort;
    }


    /**
     * Gets the plz value for this DetailsType.
     * 
     * @return plz
     */
    public java.lang.String getPlz() {
        return plz;
    }


    /**
     * Sets the plz value for this DetailsType.
     * 
     * @param plz
     */
    public void setPlz(java.lang.String plz) {
        this.plz = plz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DetailsType)) return false;
        DetailsType other = (DetailsType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bezeichnung==null && other.getBezeichnung()==null) || 
             (this.bezeichnung!=null &&
              this.bezeichnung.equals(other.getBezeichnung()))) &&
            ((this.bic==null && other.getBic()==null) || 
             (this.bic!=null &&
              this.bic.equals(other.getBic()))) &&
            ((this.ort==null && other.getOrt()==null) || 
             (this.ort!=null &&
              this.ort.equals(other.getOrt()))) &&
            ((this.plz==null && other.getPlz()==null) || 
             (this.plz!=null &&
              this.plz.equals(other.getPlz())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBezeichnung() != null) {
            _hashCode += getBezeichnung().hashCode();
        }
        if (getBic() != null) {
            _hashCode += getBic().hashCode();
        }
        if (getOrt() != null) {
            _hashCode += getOrt().hashCode();
        }
        if (getPlz() != null) {
            _hashCode += getPlz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DetailsType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://thomas-bayer.com/blz/", "detailsType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bezeichnung");
        elemField.setXmlName(new javax.xml.namespace.QName("http://thomas-bayer.com/blz/", "bezeichnung"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bic");
        elemField.setXmlName(new javax.xml.namespace.QName("http://thomas-bayer.com/blz/", "bic"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ort");
        elemField.setXmlName(new javax.xml.namespace.QName("http://thomas-bayer.com/blz/", "ort"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plz");
        elemField.setXmlName(new javax.xml.namespace.QName("http://thomas-bayer.com/blz/", "plz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
