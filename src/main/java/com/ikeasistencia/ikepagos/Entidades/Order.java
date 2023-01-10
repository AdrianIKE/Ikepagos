package com.ikeasistencia.ikepagos.Entidades;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders_ikepagos")
public class Order {

    @Id 
    @Column(name = "id_order")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id_order;
    @Column(name = "id_pay")
    private String idPay;
    private String return_url;
    private Date validity_start;
    private Date validity_end;
    private Float total;
    private Integer active;
    private Date registred_date;


    public Order(){}
    
    public Order(String return_url, String id_pay , Date validity_start,Date validity_end, 
                Float total) {
                    
        this.return_url = return_url;
        this.idPay = id_pay;
        this.validity_start = validity_start;
        this.validity_end = validity_end;
        this.total = total;
        this.active = 1;
        this.registred_date = new Date(System.currentTimeMillis());
    }

    public int getId_order() {
        return id_order;
    }

    public void setId_order(int id_order) {
        this.id_order = id_order;
    }

    public String getIdPay() {
        return idPay;
    }

    public void setIdPay(String idPay) {
        this.idPay = idPay;
    }
    
    public Date getRegistred_date() {
        return registred_date;
    }

    public void setRegistred_date(Date registred_date) {
        this.registred_date = registred_date;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
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
    
    
    
    public Float getTotal() {
        return total;
    }
    
    public void setTotal(Float total) {
        this.total = total;
    }
    
    
    public String getReturn_url() {
        return return_url;
    }

    public void setReturn_url(String return_url) {
        this.return_url = return_url;
    }

    @Override
    public String toString() {
        return "Order [id_order=" + id_order + ", id_pay=" + idPay + ", return_url=" + return_url + ", validity_start="
                + validity_start + ", validity_end=" + validity_end + ", total=" + total + ", active=" + active
                + ", registred_date=" + registred_date + "]";
    }

}
