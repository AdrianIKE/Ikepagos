package com.ikeasistencia.ikepagos.Servicios;

import com.ikeasistencia.ikepagos.Entidades.Pago;
import com.ikeasistencia.ikepagos.Entidades.Beneficiario;
import com.ikeasistencia.ikepagos.Repositorios.BeneficiarioRepository;
import com.ikeasistencia.ikepagos.Repositorios.PagoRepository;

import java.security.spec.KeySpec;
import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IkePagoServicio {
    

    private static final String key = "Ik34slst3ncl4Pnt0cOm2712";
    private static final String salt = "Ik34slst3ncl4Pnt0cOm0troLado9805";

    private SecretKey secretKeyTemp;

    @Autowired
    private PagoRepository pagoRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public IkePagoServicio(){
        SecretKeyFactory factory;
        KeySpec keySpec;
        try {
            factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            keySpec = new PBEKeySpec(key.toCharArray(), salt.getBytes(), 65536, 256);
            secretKeyTemp = factory.generateSecret(keySpec);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public Integer guardarDatos (HashMap<String,Object> datos){
    
        // Datos proporcionados por el comercio
        String url_retorno = datos.get("url_retorno").toString();
        String url_negocio = datos.get("url_negocio").toString();
        String id_pago = datos.get("id_pago").toString();

        //Datos traidos por parte de Ike
        Integer cuenta_ike = Integer.parseInt(datos.get("cuenta_ike").toString());

        //Datos del comprador
        Date validity_start = Date.valueOf(datos.get("validity_start").toString());
        Date validity_end = Date.valueOf(datos.get("validity_end").toString());

        //Datos de lo adquirido
        String lineItem_name = datos.get("lineitem_name").toString();
        String lineitem_price = datos.get("lineitem_price").toString();
        String billing_name = datos.get("billing_name").toString();
        
        //Datos de pago
        Date birth_date =  Date.valueOf(datos.get("birth_date").toString());;

        
        //Datos Beneficiario
        String nameB = datos.get("nameB").toString();;
        String appB = datos.get("appB").toString();
        String apmB = datos.get("apmB").toString();
        String emailB = datos.get("emailB").toString();
        String billing_phoneB = datos.get("billing_phoneB").toString();
        String sexoB = datos.get("sexoB").toString();
            
        //Url donde se construira el link de pago
        String url = datos.get("url").toString();

        //Definicion del pago nuevo

        
        Pago pago = new Pago(url_retorno,url_negocio,id_pago, cuenta_ike,validity_start,
        validity_end, lineItem_name, lineitem_price, billing_name, birth_date,url);

        Pago res = pagoRepository.save(pago);

        

        Integer id_t = res.getId();

        Beneficiario beneficiario = new Beneficiario(nameB, appB, apmB, emailB, billing_phoneB, sexoB,id_t);
        
        beneficiarioRepository.save(beneficiario);

        return id_t;

    }

    public String construccionLink(HashMap<String,Object> datos){
        String cuenta_ike = datos.get("cuenta_ike").toString();
        String id_pago = datos.get("id_pago").toString();
        String url = datos.get("url").toString();
        String preHash = cuenta_ike + id_pago;

        String encriptado = getAES(preHash);

        System.out.println("El dato encriptado es: " + encriptado);

        String desencriptado = getAESDecrypt(encriptado);

        System.out.println("El dato desencriptado es: " + desencriptado);

        String urlFinal = url + "checkout.php?rut="+encriptado;

        return urlFinal;

    }

    public String getAES(String data){
        byte[] iv = new byte[16];

        try {
            IvParameterSpec spec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, spec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(data.getBytes("UTF8")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String getAESDecrypt(String data){
        byte[] iv = new byte[16];
        try {
            IvParameterSpec spec = new IvParameterSpec(iv);
            SecretKeySpec secretKey = new SecretKeySpec(secretKeyTemp.getEncoded(),"AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, spec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(data)));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    

}
