package com.ikeasistencia.ikepagos.Entidades;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beneficiary_ikepagos")
public class Beneficiary {
    
        //Datos Beneficiario
        @Id
        @Column(name = "id_beneficiary")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id_beneficiary;
        private Integer ike_account;
        private String name;
        private String last_name_1;
        private String last_name_2;
        private String email;
        private String billing_phone;
        private Date birth_date;
        private String line_item_name;
        private Float line_item_price;
        private String key_value;
        private Integer active;
        private Timestamp registred_date;
        
        private Integer id_order;


        public Beneficiary(){}

        public Beneficiary(String name, String last_name_1, String last_name_2, String email, String billing_phone,
            Date birth_date,String line_item_name,Float line_item_price ,String key_value, Integer id_order,Integer ike_account) {
                this.name = name;
                this.last_name_1 = last_name_1;
                this.last_name_2 = last_name_2;
                this.email = email;
                this.billing_phone = billing_phone;
                this.birth_date = birth_date;
                this.line_item_name = line_item_name;
                this.line_item_price = line_item_price;
                this.key_value = key_value;
                this.active = 1;
                this.registred_date = new Timestamp(System.currentTimeMillis());
                this.id_order = id_order;
                this.ike_account = ike_account;
        }

        

        public Integer getIke_account() {
            return ike_account;
        }

        public void setIke_account(Integer ike_account) {
            this.ike_account = ike_account;
        }
        public Integer getId_beneficiary() {
            return id_beneficiary;
        }
        public void setId_beneficiary(Integer id_beneficiary) {
            this.id_beneficiary = id_beneficiary;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }


        public String getLast_name_1() {
            return last_name_1;
        }
        public void setLast_name_1(String last_name_1) {
            this.last_name_1 = last_name_1;
        }


        public String getLast_name_2() {
            return last_name_2;
        }
        public void setLast_name_2(String last_name_2) {
            this.last_name_2 = last_name_2;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }


        public String getBilling_phone() {
            return billing_phone;
        }
        public void setBilling_phone(String billing_phone) {
            this.billing_phone = billing_phone;
        }


        public Date getBirth_date() {
            return birth_date;
        }
        public void setBirth_date(Date birth_date) {
            this.birth_date = birth_date;
        }

        public String getLine_item_name() {
            return line_item_name;
        }
        public void setLine_item_name(String line_item_name) {
            this.line_item_name = line_item_name;
        }


        public Float getLine_item_price() {
            return line_item_price;
        }
        public void setLine_item_price(Float line_item_price) {
            this.line_item_price = line_item_price;
        }

        public String getKey_value() {
            return key_value;
        }
        public void setKey_value(String key_value) {
            this.key_value = key_value;
        }


        public Integer getActive() {
            return active;
        }
        public void setActive(Integer active) {
            this.active = active;
        }

        public Timestamp getRegistred_date() {
            return registred_date;
        }

        public void setRegistred_date(Timestamp registred_date) {
            this.registred_date = registred_date;
        }


        public Integer getId_order() {
            return id_order;
        }
        public void setId_order(Integer id_order) {
            this.id_order = id_order;
        }

        @Override
        public String toString() {
            return "Beneficiary [id_beneficiary=" + id_beneficiary + ", ike_account=" + ike_account + ", name=" + name
                    + ", last_name_1=" + last_name_1 + ", last_name_2=" + last_name_2 + ", email=" + email
                    + ", billing_phone=" + billing_phone + ", birth_date=" + birth_date + ", line_item_name="
                    + line_item_name + ", line_item_price=" + line_item_price + ", key_value=" + key_value + ", active="
                    + active + ", registred_date=" + registred_date + ", id_order=" + id_order + "]";
        }      
        
}
