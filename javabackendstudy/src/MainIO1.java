/*
    Path
    Files
    readString()
    writeString()
    readAllLines()
    IOException
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainIO1 {
    public static void main(String[] args) {
        Path producto = Path.of("producto.txt");
        
        try {
            //Escribir
            Files.writeString(producto, 
                """
                Laptop,15000,ACTIVE
                Mouse,500,ACTIVE
                Monitor,4500,INACTIVE    
                """);

            //Leer
            String contenido = Files.readString(producto);
            System.out.println(contenido);

            System.out.println("- - - - - - - - - - -");

            List<String> lineas = Files.readAllLines(producto);
            lineas.forEach(System.out::println);

            System.out.println("- - - - - - - - - - -");
            
            lineas.forEach(linea -> {
                String[] datos = linea.split(",");

                System.out.println("Producto: " + datos[0]);
                System.out.println("Precio: " + datos[1]);
                System.out.println("Estado: " + datos[2]);
                System.out.println(" - - - - - ");
            }); 
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

