package com.ikeasistencia.ikepagos.Entidades;

import java.sql.Timestamp;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "order_pay")
public class Order_Pay {

    @Id
    private Integer id_order_pay;
    private String billing_name;
    private String billing_phone;
    private String billing_mail;
    private Date birth_date;
    private String payment_method;
    private String payment_reference;
    private String auth_code;
    private String order_id;
    private String pay_detail;

    @Lob
    @Column(name = "card", columnDefinition="BLOB")
    public byte[] card;

    public String expiration_date;
    public Integer renovation;
    public String card_type;
    public String charge_type;
    public Integer active;
    public Timestamp registred_date;
    

    public Integer id_order;
    
    public String getCharge_type() {
        return charge_type;
    }

    public Timestamp getRegistred_date() {
        return registred_date;
    }

    public void setRegistred_date(Timestamp registred_date) {
        this.registred_date = registred_date;
    }

    public void setCharge_type(String charge_type) {
        this.charge_type = charge_type;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }


    public Integer getId_order() {
        return id_order;
    }

    public void setId_order(Integer id_order) {
        this.id_order = id_order;
    }

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public Integer getRenovation() {
        return renovation;
    }

    public void setRenovation(Integer renovation) {
        this.renovation = renovation;
    }

    public String getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(String expiration_date) {
        this.expiration_date = expiration_date;
    }

    public byte[] getCard() {
        return card;
    }

    public void setCard(byte[] card) {
        this.card = card;
    }

    public String getPay_detail() {
        return pay_detail;
    }

    public void setPay_detail(String pay_detail) {
        this.pay_detail = pay_detail;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getAuth_code() {
        return auth_code;
    }

    public void setAuth_code(String auth_code) {
        this.auth_code = auth_code;
    }

    public String getPayment_reference() {
        return payment_reference;
    }

    public void setPayment_reference(String payment_reference) {
        this.payment_reference = payment_reference;
    }

    public String getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(String payment_method) {
        this.payment_method = payment_method;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getBilling_mail() {
        return billing_mail;
    }

    public void setBilling_mail(String billing_mail) {
        this.billing_mail = billing_mail;
    }

    public String getBilling_phone() {
        return billing_phone;
    }

    public void setBilling_phone(String billing_phone) {
        this.billing_phone = billing_phone;
    }

    public String getBilling_name() {
        return billing_name;
    }

    public void setBilling_name(String billing_name) {
        this.billing_name = billing_name;
    }

    public Integer getId_order_pay() {
        return id_order_pay;
    }

    public void setId_order_pay(Integer id_order_pay) {
        this.id_order_pay = id_order_pay;
    }


}
