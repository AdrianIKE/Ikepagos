package com.ikeasistencia.ikepagos.Entidades;

import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pago")
public class Pago {
    // ?
    @Id
    @GeneratedValue 
    private int id;

    // Datos proporcionados por el comercio
    private String url_retorno;
    private String url_negocio;
    private String id_pago;

    //Datos traidos por parte de Ike
    private Integer cuenta_ike;

    //Datos del comprador
    private String titular;
    private Date validity_start;
    private Date validity_end;
    private String emailT;
    private String billing_Phone;
    private Date paid_at;
    private Float total;

    //Datos de lo adquirido
    private String lineItem_name;
    private String lineitem_price;
    private String billing_name;
    
    //Datos de pago
    private String payment_method;
    private String payment_reference;
    private String codigo_autorizacion;
    private String ordera;
    private String detalle_pago;
    private String card;
    private Date expiration_date;
    private Date birth_date;
    private String renovacion;



    // ?
    private String empresa;
    private String id_operacion;
    private String producto;
    private String cod_producto;
    private String tipo_tdc;
    private String canal_venta;
    private String tipo_cobro;
    private String seguro;

    //Url donde se construira el link de pago
    private String url;
    

    public Pago(){}
    
    public Pago(String url_retorno, String url_negocio, String id_pago, Integer cuenta_ike, Date validity_start,
            Date validity_end, String lineItem_name, String lineitem_price, String billing_name, Date birth_date, String url) {

        this.url_retorno = url_retorno;
        this.url_negocio = url_negocio;
        this.id_pago = id_pago;
        this.cuenta_ike = cuenta_ike;
        this.validity_start = validity_start;
        this.validity_end = validity_end;
        this.lineItem_name = lineItem_name;
        this.lineitem_price = lineitem_price;
        this.billing_name = billing_name;
        this.birth_date = birth_date;
        this.url = url;

    }

    @Override
    public String toString() {
        return "Pago [id=" + id + ", url_retorno=" + url_retorno + ", url_negocio=" + url_negocio + ", id_pago="
                + id_pago + ", cuenta_ike=" + cuenta_ike + ", titular=" + titular + ", validity_start=" + validity_start
                + ", validity_end=" + validity_end + ", emailT=" + emailT + ", billing_Phone=" + billing_Phone
                + ", paid_at=" + paid_at + ", total=" + total + ", lineItem_name=" + lineItem_name + ", lineitem_price="
                + lineitem_price + ", billing_name=" + billing_name + ", payment_method=" + payment_method
                + ", paymenth_reference=" + payment_reference + ", codigo_autorizacion=" + codigo_autorizacion
                + ", order=" + ordera + ", detalle_pago=" + detalle_pago + ", card=" + card + ", expiration_date="
                + expiration_date + ", birth_date=" + birth_date + ", renovacion=" + renovacion + ", empresa=" + empresa
                + ", id_operacion=" + id_operacion + ", producto=" + producto + ", cod_producto=" + cod_producto
                + ", tipo_tdc=" + tipo_tdc + ", canal_venta=" + canal_venta + ", tipo_cobro=" + tipo_cobro + ", seguro="
                + seguro + ", url=" + url + "]";
    }

   

    

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLineItem_name() {
        return lineItem_name;
    }
    
    public void setLineItem_name(String lineItem_name) {
        this.lineItem_name = lineItem_name;
    }
    
    public String getLineitem_price() {
        return lineitem_price;
    }
    
    public void setLineitem_price(String lineitem_price) {
        this.lineitem_price = lineitem_price;
    }
    
    public String getBilling_name() {
        return billing_name;
    }
    
    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    
    public String getId_pago() {
        return id_pago;
    }
    
    public void setId_pago(String id_pago) {
        this.id_pago = id_pago;
    }
    
    public Integer getCuenta_ike() {
        return cuenta_ike;
    }
    
    public void setCuenta_ike(Integer cuenta_ike) {
        this.cuenta_ike = cuenta_ike;
    }
    
    public String getTitular() {
        return titular;
    }
    
    public void setTitular(String titular) {
        this.titular = titular;
    }
    
    public Date getValidity_start() {
        return validity_start;
    }
    
    public void setValidity_start(Date validity_start) {
        this.validity_start = validity_start;
    }
    
    public Date getValidity_end() {
        return validity_end;
    }
    
    public void setValidity_end(Date validity_end) {
        this.validity_end = validity_end;
    }
    
    public String getEmailT() {
        return emailT;
    }
    
    public void setEmailT(String emailT) {
        this.emailT = emailT;
    }
    
    public String getBilling_Phone() {
        return billing_Phone;
    }
    
    public void setBilling_Phone(String billing_Phone) {
        this.billing_Phone = billing_Phone;
    }
    
    public Date getPaid_at() {
        return paid_at;
    }
    
    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }
    
    public Float getTotal() {
        return total;
    }
    
    public void setTotal(Float total) {
        this.total = total;
    }
    
    public String getPayment_method() {
        return payment_method;
    }
    
    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }
    
    
    public String getPayment_reference() {
        return payment_reference;
    }

    public void setPayment_reference(String payment_reference) {
        this.payment_reference = payment_reference;
    }
    
    public String getCodigo_autorizacion() {
        return codigo_autorizacion;
    }

    public void setCodigo_autorizacion(String codigo_autorizacion) {
        this.codigo_autorizacion = codigo_autorizacion;
    }
    
    
    public String getOrder() {
        return ordera;
    }
    
    public void setOrder(String order) {
        this.ordera = order;
    }
    
    
    public String getDetalle_pago() {
        return detalle_pago;
    }
    
    public void setDetalle_pago(String detalle_pago) {
        this.detalle_pago = detalle_pago;
    }

    
    public String getCard() {
        return card;
    }
    
    public void setCard(String card) {
        this.card = card;
    }
    
    
    public Date getExpiration_date() {
        return expiration_date;
    }
    
    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }
    
    
    public Date getBirth_date() {
        return birth_date;
    }
    
    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    
    
    public String getRenovacion() {
        return renovacion;
    }
    
    public void setRenovacion(String renovacion) {
        this.renovacion = renovacion;
    }   
    
    public String getEmpresa() {
        return empresa;
    }
    
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    
    
    public String getId_operacion() {
        return id_operacion;
    }
    
    public void setId_operacion(String id_operacion) {
        this.id_operacion = id_operacion;
    }
    
    
    public String getProducto() {
        return producto;
    }
    
    public void setProducto(String producto) {
        this.producto = producto;
    }
       
    public String getTipo_tdc() {
        return tipo_tdc;
    }
    
    public void setTipo_tdc(String tipo_tdc) {
        this.tipo_tdc = tipo_tdc;
    }
           
    public String getSeguro() {
        return seguro;
    }
    
    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getUrl_retorno() {
        return url_retorno;
    }

    public void setUrl_retorno(String url_retorno) {
        this.url_retorno = url_retorno;
    }

    public String getUrl_negocio() {
        return url_negocio;
    }

    public void setUrl_negocio(String url_negocio) {
        this.url_negocio = url_negocio;
    }
    
    public String getCod_producto() {
        return cod_producto;
    }

    public void setCod_producto(String cod_producto) {
        this.cod_producto = cod_producto;
    }

    public String getCanal_venta() {
        return canal_venta;
    }

    public void setCanal_venta(String canal_venta) {
        this.canal_venta = canal_venta;
    }
    
    public String getTipo_cobro() {
        return tipo_cobro;
    }

    public void setTipo_cobro(String tipo_cobro) {
        this.tipo_cobro = tipo_cobro;
    }





    

    
}
