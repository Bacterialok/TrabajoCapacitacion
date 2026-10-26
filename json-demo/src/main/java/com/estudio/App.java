package com.estudio;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
    Ejercicio de serialización/deserialización.
*/
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        // Java -> JSON
        ProductResponse product1 = new ProductResponse(1, "Laptop", 15000, true);
        ObjectMapper mapper = new ObjectMapper();
        String json1 = mapper.writeValueAsString(product1);
        System.out.println(json1);

        System.out.println("- - - - - - - - - -");

        // JSON -> Java
        String json2 = """
            {
              "id": 2,
              "name": "Mouse",
              "price": 850.99,
              "active": true
            }
            """;
        
        ProductResponse product2 = mapper.readValue(json2, ProductResponse.class);

        System.out.println(product2);
        System.out.println(product2.name());
        System.out.println(product2.price());
        System.out.println(product2.active());
    }
}
