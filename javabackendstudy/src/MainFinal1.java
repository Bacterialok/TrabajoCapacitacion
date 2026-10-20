/*
    static -> existe una sola copia asociada a la clase
    final  -> ese valor no puede cambiar después de asignarse 
*/

class RetryConfig {
    public static final int MAX_RETRIES = 3;
}

//CLASE INMUTABLE
class Product1 {
    private final int id;
    private final String name;

    public Product1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /* COMENTADO PORQUE SE QUIERE REPRESENTAR A UNA CLASE INMUTABLE
    public void setName(String name) {
        this.name = name;
    }
    */
}

public class MainFinal1 {
    public static void main(String[] args) {
        System.out.println(RetryConfig.MAX_RETRIES);

        final Product1 product = new Product1(1, "Lupita");
        //ERROR product = new Product1(2, "Ondina");

        //CORRECTO
        //product.setName("Otro nombre");
    }
}
