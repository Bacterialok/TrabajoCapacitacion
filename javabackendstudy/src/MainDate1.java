/*
    En Java moderno, para fechas y horas normalmente usamos el paquete: java.time

    LocalDate      -> solo fecha
    LocalTime      -> solo hora
    LocalDateTime  -> fecha + hora

    LocalDate es inmutable.

    LocalDateTime:

*/

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class MainDate1 {
    public static void main(String[] args) {
        // Ejemplo 1
        LocalDate hoy = LocalDate.now();
        System.out.println(hoy);

        LocalDate fecha = LocalDate.of(2026, 10, 24);
        System.out.println(fecha.getYear());
        System.out.println(fecha.getMonth());
        System.out.println(fecha.getDayOfMonth());

        LocalDate manana = hoy.plusDays(1);
        LocalDate haceUnaSemana = hoy.minusWeeks(1);
        System.out.println(manana);
        System.out.println(haceUnaSemana);

        // Ejemplo 2
        LocalDateTime ahora = LocalDateTime.now();
        System.out.println(ahora);

        // Ejemplo 3
        LocalDate fecha1 = LocalDate.of(2026, 10, 24);
        LocalDate fecha2 = LocalDate.of(2026, 12, 1);
 
        System.out.println(fecha1.isBefore(fecha2));
        System.out.println(fecha1.isAfter(fecha2));
        System.out.println(fecha1.isEqual(fecha2));

        Period diferencia = Period.between(fecha1, fecha2);
        System.out.println(diferencia.getMonths());
        System.out.println(diferencia.getDays());

        // Ejemplo 4
        // Dias totales
        System.out.println(ChronoUnit.DAYS.between(fecha1, fecha2));

        // Ejercicio 1
        System.out.println("- - - - - - - - - - - - ");
        LocalDate cumple = LocalDate.of(2027, 5, 10);

        System.out.println(hoy);
        System.out.println(cumple.getYear());
        System.out.println(cumple.getMonth());
        System.out.println(hoy.plusDays(1));
        System.out.println(ahora);

        // Ejercicio 2
        System.out.println("- - - - - - - - - - - - ");
        LocalDate inicio = LocalDate.of(2026, 10, 24);
        LocalDate fin = LocalDate.of(2027, 1, 10);

        System.out.println(inicio.isBefore(fin));
        System.out.println(fin.isAfter(inicio));

        Period periodo1 = Period.between(inicio, fin);
        System.out.println(periodo1.getYears());
        System.out.println(periodo1.getMonths());
        System.out.println(periodo1.getDays());
    }
}
