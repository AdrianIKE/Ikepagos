package com.ikeasistencia.ikepagos.Controladores;

import com.ikeasistencia.ikepagos.Servicios.IkePagoServicio;

import org.springframework.web.bind.annotation.RestController;

import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

@RestController
public class IkePagoController {

    @Autowired 
    private IkePagoServicio ikePagoServicio;


    @PostMapping("/api/inicioPago")
    public Map<String,String> inicioPago (@RequestBody String body) throws Exception {
        
        //Definimos la respuesta vacia.
        HashMap<String,String> response = new HashMap<String,String>();
        
        //Obtencion de los datos Json en la variable datosCorreo
        Gson request = new Gson();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
        HashMap<String,Object> datosPago = request.fromJson(reader, HashMap.class);

        //Inicializar el Servicio con sus datos correspondientes y guardarlos 
        Integer id_transaccion = ikePagoServicio.saveOrder(body);

        // Construccion de json para el Front

        response.put("transaction_id",String.valueOf(id_transaccion));

        response.put("payament_url", ikePagoServicio.construccionLink(datosPago));

        response.put("return_url", datosPago.get("return_url").toString());

        return response; 
    }
}
