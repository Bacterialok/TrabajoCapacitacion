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
*/

public class MainExceptions1 {
    public static void main(String[] args) {
        int numero1 = 10;
        int numero2 = 0;

        try {
            System.out.println("Intentando...");
            System.out.println(numero1/numero2);
        } catch (ArithmeticException e) {
            System.out.println("No se puede dividir entre cero");
        } finally {
            System.out.println("Fin del proceso");
        }
    }
}
