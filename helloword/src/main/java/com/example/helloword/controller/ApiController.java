package com.example.helloword.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloword.domain.Producto;

@RestController
public class ApiController {

    @GetMapping("/") // Ruta
    public String home(){
        return "Home campers";
    }

    @GetMapping("/saludo") // saludo ? nombre= Camilo
    public String saludo(
        @RequestParam(name= "nombre", required= true) String name,
        @RequestParam(name="apellido", required = false, defaultValue= "Apellido comun") String lastName
    ){
        return "hello "+ name+ " "+ lastName;
    }

    @GetMapping("/search") // saludo ? nombre= Camilo
    public Map<String, String> buscar(
        @RequestParam(name="name", defaultValue= "Apellido comun") String name

    ){
        Map< String, String> cities= new HashMap<>();
        cities.put("BUC","Bucaramanga");
        cities.put("NYC","New York");
        cities.put("BOG","Bogota");
        cities.put("NVA","Neiva");
        cities.put("LET","Leticia");
        cities.put("PER","Pereira");

        if (cities.containsKey(name)){
            return Map.of(name, cities.get(name));

        }else{
            return cities;
        }
    }

    /* 
    @GetMapping("/search") // saludo ? nombre= Camilo
    public List<Producto> calc(
        @RequestParam( defaultValue= "0") double price

    ){
        List<Producto> productos= new ArrayList<>(List.of(new Producto(1, "Pan", 2000)));
        productos.add(new Producto(2, "Gaseosa", 3500));
        productos.add(new Producto(3, "Salchichon Zenu", 1500));

        return productos;
    }
        */



    @GetMapping("/tax") // saludo ? nombre= Camilo
    public Map<String, Object> calcular(
        @RequestParam( name= "impuestos",defaultValue= "0") double impuestos

    ){
        List<Producto> productos= new ArrayList<>(List.of(new Producto(1, "Pan", 2000)));
        productos.add(new Producto(2, "Gaseosa", 3500));
        productos.add(new Producto(3, "Salchichon Zenu", 1500));
        double total=0;
        double valorIva=0;
        for (Producto p: productos){
            total+= p.getPrice();
            
        }
        double valorN= impuestos/ 100;
        valorIva= total+total * valorN;
        return Map.of("productos", productos, "total", valorIva, "valor_neto", total);
    }
    
    /* 
    @GetMapping("/tax")
    public Map<String, Object>calcular(
        @RequestParam(defaultValue = "0") double impuestos
        ) {
            List<Producto> productos = new ArrayList<>(
                List.of(new Producto(1, "Pan", 2000))
                );
            productos.add(new Producto(2, "Gaseosa", 3500));
            productos.add(new Producto(3, "Salchichon Zenu", 1500));
            double precios = productos.stream().map(producto -> producto.getPrice()).reduce(0.0, (precioA, precioB) -> precioA + precioB);
            return Map.of("productos", productos,"total", (precios + (precios * (impuestos / 100))), "valor_neto", precios, "IVA",  impuestos+"%");
    }
            */

}
