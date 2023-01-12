package com.ikeasistencia.ikepagos.Servicios;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.ikeasistencia.ikepagos.Entidades.Order;
import com.ikeasistencia.ikepagos.Entidades.Beneficiary;
import com.ikeasistencia.ikepagos.Repositorios.BeneficiaryRepository;
import com.ikeasistencia.ikepagos.Repositorios.OrderRepository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
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
    
    //Llaves en encripatcion
    private static final String key = "Ik34slst3ncl4Pnt0cOm2712";
    private static final String salt = "Ik34slst3ncl4Pnt0cOm0troLado9805";
    private final String url = "https://sitio-respaldat360.dev-pruebas.com/";
    private SecretKey secretKeyTemp;
    

    //Conexion hacia la tabla pago
    @Autowired
    private OrderRepository orderRepository;

    //Conexcion hacia la tabla beneficiario
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;

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
    
    public Integer saveOrder (String body){
        
        //Conversion del cuerpo de peticion
        Gson json = new Gson();
        JsonObject datos = json.fromJson(body,JsonObject.class);
        JsonElement val_start = datos.get("validity_start");
        JsonElement val_end = datos.get("validity_end");
        
        // Datos generales para el pago
        String id_pay = datos.get("id_pay").getAsString();
        String return_url = datos.get("return_url").getAsString();
        Float total = Float.valueOf(datos.get("total").getAsString());
        Date validity_start = Date.valueOf(val_start.getAsString());
        Date validity_end = Date.valueOf(val_end.getAsString());
        Integer validador = 0;
        Integer recurrence = Integer.valueOf(datos.get("recurrence").getAsString());
        
        Order pago = new Order(return_url, id_pay , validity_start,validity_end,total,recurrence);
        try{
            Order validation = orderRepository.findByIdPay(id_pay);
            validador = validation.getActive();
        }catch (Exception e){
            validador = 0;
        }
        
        if(validador == 1){
            return 0;
        }
        Order res = orderRepository.save(pago);
        Integer id_order = res.getId_order();
        

        
        //Configuracion array de  beneficiarios
        JsonElement beneficiariesAux = datos.get("beneficiaries");
        JsonArray beneficiaries = json.fromJson(beneficiariesAux, JsonArray.class);
        guardarDatosBeneficiario(beneficiaries,id_order);
        
        

        return id_order;

    }

    public Integer guardarDatosBeneficiario (JsonArray beneficiaries, Integer id_order){
        
        Gson json = new Gson();
        for (JsonElement beneficiary : beneficiaries) {
            JsonObject aux = json.fromJson(beneficiary,JsonObject.class);
            JsonElement birth_date = aux.get("birth_date");
            Integer ike_account =  Integer.valueOf(aux.get("ike_account").getAsString());
            String key_value = getKeyValue(ike_account);
            Beneficiary b = new Beneficiary(
                aux.get("name").getAsString(), 
                aux.get("last_name_1").getAsString(), 
                aux.get("last_name_2").getAsString(), 
                aux.get("email").getAsString(), 
                aux.get("billing_phone").getAsString(), 
                Date.valueOf(birth_date.getAsString()), 
                aux.get("line_item_name").getAsString(), 
                Float.valueOf(aux.get("line_item_price").toString()), 
                key_value, 
                id_order,
                ike_account
            );
            beneficiaryRepository.save(b);
        }
        return 1;
    }


    public String getKeyValue(Integer ike_account){
        Integer last_id =  beneficiaryRepository.findLast().getId_beneficiary();
        String folio = "";
        if(ike_account == 2458){
            folio = "HBLHF"+last_id;
            return folio;
        } else if(ike_account == 2459){
            folio = "HBLHI"+last_id;
            return folio;
        } else if(ike_account == 2514){
            folio = "HBLDB"+last_id;
            return folio;
        } else if(ike_account == 2515){
            folio = "HBLDP"+last_id;
            return folio;
        } else if(ike_account == 2570){
            folio = "HBRAP"+last_id;
            return folio;
        } else if(ike_account == 2571){
            folio = "HBRGE"+last_id;
            return folio;
        } else if(ike_account == 2572){
            folio = "HBRD"+last_id;
            return folio;
        } else if(ike_account == 2573 || ike_account ==2574 || ike_account ==2575 || ike_account ==2576){
            folio = "HBRGF"+last_id;
            return folio;
        }
        return folio;

    }


    public String construccionLink(HashMap<String,Object> datos) throws UnsupportedEncodingException{
        String id_pay = datos.get("id_pay").toString();
        String validity_start = datos.get("validity_start").toString();
        String preHash = validity_start + id_pay;
        String encriptado = getAES(preHash);
        String urlFinal = this.url + "checkout?rut="+URLEncoder.encode(encriptado, "UTF-8");
        return urlFinal;
    }

    public String getAES(String data){
        byte[] iv = new byte[16];
        iv = "ikeasistencia222".getBytes(Charset.defaultCharset());
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
        iv = "ikeasistencia222".getBytes(Charset.defaultCharset());
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
