package com.example.helloworld.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.domain.Producto;

@RestController
public class ApiController {

    @GetMapping("/")
    public String saludar(){
        String saludo="";
        for (int i=0;i<5;i++){
            saludo+=i+"\n";
        }
        return saludo;
    }
    @GetMapping("/j")
    public String getMethodName() {
        return "Hola, Jhonatan";
    }
    


    @GetMapping("/search")
    public Map<String, String> buscar(
        @RequestParam(name = "name", defaultValue = "") String name) {
        Map<String, String> cities = new HashMap<>();
        cities.put("BUC", "Bucaramanga");
        cities.put("NYC", "New York");
        cities.put("BOG", "Bogota");
        cities.put("NVA", "Neiva");
        cities.put("LET", "Leticia");
        cities.put("PER", "Pereira");

        if (cities.containsKey(name)) {
            return Map.of(name,cities.get(name));
        } else {
            return cities;
        }
    }

    @GetMapping("/tax")
    public Map<String, Object> calcular(
        @RequestParam(defaultValue = "0") double impuestos) {
        List<Producto> productos = new ArrayList<>(
            List.of(new Producto(1, "Pan", 2000))
        );
        productos.add(new Producto(2, "Gaseosa", 3500));
        productos.add(new Producto(3, "Salchichon Zenu", 1500));

        productos.stream().reduce(0, (productoA ,productoB) -> new Producto (0,"",productoA.getPrice() + productoB.getPrice()));
    
        return Map.of("productos", productos, "total", 0, "valor_neto", 0);
    }

    

   

}