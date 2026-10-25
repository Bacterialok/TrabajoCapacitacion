/*
    Dinero -> BigDecimal, no double

    add()       -> sumar
    subtract()  -> restar
    multiply()  -> multiplicar
    divide()    -> dividir
    compareTo() -> comparar

    BigDecimal es inmutable

    Y preferentemente:
    new BigDecimal("199.99")

    en lugar de:
    new BigDecimal(199.99)
*/

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MainBigDecimal1 {
    public static void main(String[] args) {
        BigDecimal precio = new BigDecimal("1250.50");
        BigDecimal descuento = new BigDecimal("150.25");
        BigDecimal impuesto = new BigDecimal("176.04");
        BigDecimal subtotal = precio.subtract(descuento);
        BigDecimal total = subtotal.add(impuesto);

        System.out.println(precio);
        System.out.println(descuento);
        System.out.println(subtotal);
        System.out.println(impuesto);
        System.out.println(total);

        BigDecimal cantidad = new BigDecimal("3");
        BigDecimal precioUnitario = new BigDecimal("199.99");
        BigDecimal totalCompra = cantidad.multiply(precioUnitario);
        System.out.println(totalCompra);

        BigDecimal limite = new BigDecimal("500.00");
        System.out.println((totalCompra.compareTo(limite) > 0 ? "Supera el limite" : "No supera el limite"));
        //System.out.println(totalCompra.compareTo(limite));

        BigDecimal totalCuenta = new BigDecimal("1000");
        BigDecimal personas = new BigDecimal("3");
        /* 
            personas              -> divisor
            2                     -> cantidad de decimales
            RoundingMode.HALF_UP  -> regla de redondeo    
        */
        System.out.println(totalCuenta.divide(personas,2,RoundingMode.HALF_UP));
    }
}
