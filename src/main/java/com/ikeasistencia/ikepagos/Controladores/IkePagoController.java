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


    @PostMapping("/api/pagoNuevo")
    public Map<String,String> pagoNuevo (@RequestBody String body) throws Exception {
        
        //Definimos la respuesta vacia.
        HashMap<String,String> response = new HashMap<String,String>();
        
        //Obtencion de los datos Json en la variable datosCorreo
        Gson request = new Gson();
        JsonReader reader = new JsonReader(new StringReader(body));
        reader.setLenient(true);
        HashMap<String,Object> datosCorreo = request.fromJson(reader, HashMap.class);

        //Inicializar el Servicio con sus datos correspondientes y guardarlos 
        Integer id_transaccion = ikePagoServicio.guardarDatos(datosCorreo);

        // Construccion de json para el Front

        response.put("id_transaccion",String.valueOf(id_transaccion));

        response.put("url_pago", ikePagoServicio.construccionLink(datosCorreo));

        response.put("url_retorno", datosCorreo.get("url_retorno").toString());

        response.put("url_notificacion", datosCorreo.get("url_negocio").toString());

        return response; 
    }
}
