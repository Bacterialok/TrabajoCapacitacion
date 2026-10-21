package javabackendpoo.src;

/*
    "is-a"  -> herencia
    "has-a" -> composición

    Carro has-a Motor
*/
class Motor {
    public void encender() {
        System.out.println("Motor encendido");
    }
}

class Carro {
    private final Motor motor;

    public Carro(Motor motor) {
        this.motor = motor;
    }

    public void arrancar() {
        motor.encender();
        System.out.println("Carro arrancando");
    }
}

public class MainComposicion1 {
    public static void main(String[] args) {

    }
}
