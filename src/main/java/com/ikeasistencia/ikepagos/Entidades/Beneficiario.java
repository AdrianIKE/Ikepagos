package com.ikeasistencia.ikepagos.Entidades;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="beneficiario")
public class Beneficiario {
    
        //Datos Beneficiario
        @Id
        @GeneratedValue 
        private Integer id_beneficiario;
        private String nameB;
        private String appB;
        private String apmB;
        private String emailB;
        private String billing_phoneB;
        private String sexoB;
        private Integer id_tpago;


        public Beneficiario(String nameB, String appB, String apmB, String emailB, String billing_phoneB,
                String sexoB, Integer id_tpago) {
            this.nameB = nameB;
            this.appB = appB;
            this.apmB = apmB;
            this.emailB = emailB;
            this.billing_phoneB = billing_phoneB;
            this.sexoB = sexoB;
            this.id_tpago = id_tpago;
        }

        @Override
        public String toString() {
            return "Beneficiario [nameB=" + nameB + ", appB=" + appB + ", apmB=" + apmB + ", emailB=" + emailB
                    + ", billing_phoneB=" + billing_phoneB + ", sexoB=" + sexoB + "]";
        }
        
        public Integer getId_tpago() {
            return id_tpago;
        }

        public void setId_tpago(Integer id_tpago) {
            this.id_tpago = id_tpago;
        }
        
        public Integer getId_beneficiario() {
            return id_beneficiario;
        }

        public void setId_beneficiario(Integer id_beneficiario) {
            this.id_beneficiario = id_beneficiario;
        }

        public String getNameB() {
            return nameB;
        }
        public void setNameB(String nameB) {
            this.nameB = nameB;
        }
        
        public String getAppB() {
            return appB;
        }
        public void setAppB(String appB) {
            this.appB = appB;
        }
        
        public String getApmB() {
            return apmB;
        }
        public void setApmB(String apmB) {
            this.apmB = apmB;
        }
        
        public String getEmailB() {
            return emailB;
        }
        public void setEmailB(String emailB) {
            this.emailB = emailB;
        }
        
        public String getBilling_phoneB() {
            return billing_phoneB;
        }
        public void setBilling_phoneB(String billing_phoneB) {
            this.billing_phoneB = billing_phoneB;
        }
        
        public String getSexoB() {
            return sexoB;
        }
        public void setSexoB(String sexoB) {
            this.sexoB = sexoB;
        }

        
}
