/*
Una checked exception es una excepción que el compilador sabe que puede ocurrir 
y te obliga a hacer una de dos cosas: manejarla con try/catch o declararla con throws.

Checked
-> el compilador te obliga a manejar o declarar
-> suelen representar fallos externos o recuperables

Ejemplos:
    IOException
    SQLException

Una unchecked exception normalmente hereda de RuntimeException, y el compilador no te obliga a capturarla.

Unchecked
-> el compilador no te obliga
-> suelen representar errores de programación o reglas inválidas

Ejemplos:
    ArithmeticException
    NullPointerException
    IllegalArgumentException
    IndexOutOfBoundsException

throw
-> lanza una excepción concreta
-> va dentro del código

throws
-> declara que un método puede lanzar una excepción
-> va en la firma del método

*/

import java.io.IOException;

class InvalidAgeException extends RuntimeException {

    public InvalidAgeException(String message) {
        super(message);
    }
}

public class MainExceptions1 {
    public static void validarEdadThrow(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("La edad no puede ser negativa");
        }
    }

    public static void validarEdadPersonalizada(int edad) {
        if (edad < 0) {
            throw new InvalidAgeException("La edad no puede ser negativa");
        }
    }

    public static void leerArchivo() throws IOException {
        throw new IOException("No se puede leer el archivo");
    }

    public static void procesarArchivo() throws IOException {
        leerArchivo();
    }

    public static void procesar(int opcion) {
        if (opcion == 1) {
            throw new ArithmeticException("Error matematico");            
        } else if (opcion == 2) {
            throw new IllegalArgumentException("Error de argumentos");
        } else if (opcion == 3) {
            throw new RuntimeException("Error de runtime");
        }
    }

    public static void main(String[] args) {
        try {
            leerArchivo();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            procesarArchivo();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        int numero1 = 10;
        int numero2 = 0;

        // Ejemplo try/catch/finally
        try {
            System.out.println("Intentando...");
            System.out.println(numero1 / numero2);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre cero");
        } finally {
            System.out.println("Fin del proceso");
        }

        // Ejemplo throw
        try {
            validarEdadThrow(-1);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ejemplo throws
        try {
            validarEdadPersonalizada(-1);
        } catch (InvalidAgeException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Ejemplo con múltiples catch y jerarquía de excepciones.
        try {
            procesar(2);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e);
        } catch (RuntimeException e) {
            System.out.println("Error: " + e);
        }
    }
}
