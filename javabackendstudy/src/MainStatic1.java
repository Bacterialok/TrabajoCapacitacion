
/*
    static
    -> pertenece a la clase
    -> se comparte entre objetos

    sin static
    -> pertenece a una instancia concreta
    -> cada objeto tiene su propio valor
*/

class User1 {
    static int totalUser = 0;

    String name;

    public User1(String name) {
        this.name = name;
        totalUser++;
    }
}

class Calculator1 {
    public static int sum(int a, int b) {
        return a + b;
    }
}

public class MainStatic1 {
    public static void main(String[] args) {
        User1 u1 = new User1("Ana");
        User1 u2 = new User1("Luis");
        User1 u3 = new User1("Pedro");

        System.out.println("Uso de variables estaticas: ");
        System.out.println(User1.totalUser);

        System.out.println("Uso de metodos estaticos");
        System.out.println(Calculator1.sum(3, 7));
    }
}