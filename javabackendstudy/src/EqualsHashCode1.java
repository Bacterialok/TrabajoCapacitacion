import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class EqualsHashCode1 {
    public static void main(String[] args) {
        HashSet<Product> productos = new HashSet<>();
        Product p1 = new Product(1, "Laptop", 1000, true, "Computo");
        Product p2 = new Product(1, "PC", 10000, true, "Computo");
        productos.add(p1);
        productos.add(p2);

        for (Product product : productos) {
            System.out.println(product.hashCode());
        }

        System.out.println("Tamaño: " + productos.size());
        System.out.println("Son iguales: " + p1.equals(p2));
        System.out.println("Hash p1: " + p1.hashCode());
        System.out.println("Hash p2: " + p2.hashCode());

        System.out.println(productos);

        System.out.println();

        Map<Product, String> ubicaciones = new HashMap<>();

        ubicaciones.put(p1, "Almacen A");
        ubicaciones.put(p2, "Almacen B");

        System.out.println(ubicaciones.size());
        System.out.println(ubicaciones.get(p1));
        System.out.println(ubicaciones.get(p2));

        System.out.println();

        productos = new HashSet<>();

        productos.add(p1);

        System.out.println("Antes de cambiar id:");
        System.out.println(productos.contains(p1));

        p1.setId(99);

        System.out.println("Después de cambiar id:");
        System.out.println(productos.contains(p1));

        System.out.println();

        System.out.println(productos.size());

        for (Product p : productos) {
            System.out.println(p);
        }

        System.out.println();

        System.out.println("Size: " + productos.size());
        System.out.println("Contains: " + productos.contains(p1));

        for (Product p : productos) {
            System.out.println(p);
        }

        System.out.println("Remove: " + productos.remove(p1));
        System.out.println("Size final: " + productos.size());
    }
}
