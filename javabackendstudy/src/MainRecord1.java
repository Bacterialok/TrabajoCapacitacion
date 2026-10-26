/*
    Un record es una forma compacta de crear una clase pensada principalmente para guardar datos.

    record
    → principalmente transportar/representar datos

    class
    → objetos con estado, comportamiento y lógica
*/

record ProductResponse(
        int id,
        String name,
        double price) {
}

public class MainRecord1 {
    public static void main(String[] args) {
        ProductResponse product = new ProductResponse(1, "Laptop", 15000);

        System.out.println(
                        product.id() + "\n" +
                        product.name() + "\n" +
                        product.price());

        System.out.println(product.toString());
    }
}
