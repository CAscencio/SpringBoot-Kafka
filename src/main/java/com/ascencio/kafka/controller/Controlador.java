package com.ascencio.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ascencio.kafka.services.ProductorKafka;

@RestController
@RequestMapping("Controlador")
public class Controlador {

    String respuesta;

    @Autowired
    private ProductorKafka productorKafka;

    @PostMapping("enviar/{mensaje}")
    public String enviarMensaje(@PathVariable String mensaje){
        try {
            productorKafka.send(mensaje);
            respuesta = "Proceso exitoso :D";
        }catch (Exception e){
            respuesta = "Error :'v";
        }
        return respuesta;
    }

    @GetMapping("/Demo")
    public String demo(){
        return "Funcionando :D";
    }

}
