/*
    Ya sabes que un Optional<T> representa:

    hay un valor
    o
    no hay un valor
*/

import java.util.Optional;

public class MainOptional1 {
    public static void main(String[] args) {

        // Ejemplos
        Optional<String> nombre = Optional.of("Nicolas");
        String resultado = nombre.orElse("Desconocido");
        System.out.println(resultado);

        Optional<String> nombre1 = Optional.empty();
        String resultado1 = nombre1.orElse("Desconocido");
        System.out.println(resultado1);

        String resultado2 = nombre1.orElseGet(() -> "Desconocido");
        System.out.println(resultado2);

        // Actividad

        //orElse()
        Optional<String> name = Optional.empty();
        System.out.println(name.orElse("Ejemplo con: orElse()"));

        //orElseGet()
        System.out.println(name.orElseGet(() -> "Ejemplo con: orElseGet()"));

        //orElseThrow()
        try {
            name.orElseThrow(() -> new Exception("Ejemplo con: orElseThrow()"));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}