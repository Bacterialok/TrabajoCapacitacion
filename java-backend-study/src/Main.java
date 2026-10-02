import java.util.Comparator;
import java.util.List;
import java.util.Optional;

class Product {
    private int id;
    private String name;
    private double price;
    private boolean active;

    public Product(int id, String name, double price, boolean active) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + "]";
    }

    
}

public class Main {
    public static void main(String[] args) {
        List<Product> productos = List.of(
            new Product(1, "Laptop", 15000, true),
            new Product(2, "Mouse", 500, true),
            new Product(3, "Cable", 80, true),
            new Product(4, "Monitor", 4500, false),
            new Product(5, "Teclado", 1200, true) 
        );

        for(Product producto : productos) {
            if (producto.getPrice() > 100 && producto.isActive()) {
                System.out.println(producto);
            }
        }

        System.out.println("- - - - - - - - - -");

        productos.stream()
            .filter(p -> p.isActive() && p.getPrice() > 100)
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        System.out.println("- - - - - - - - - ");

        List<String> nombres = productos.stream()
            .filter(p -> p.isActive())
            .map(p -> p.getName())
            .toList();

        System.out.println(nombres);

        System.out.println("- - - - - - - - - -");

        productos.stream()
            .filter(p -> p.isActive())
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));
        System.out.println("----------------");
        double total = productos.stream()
            .filter(p -> p.isActive())
            .mapToDouble(p -> p.getPrice())
            .sum();
        
        System.out.println("Total:    " + total);
        
        System.out.println("- - - - - - - - - -");

        Optional<Product> producto = productos.stream()
            .filter(p -> p.getPrice() > 1000 && p.isActive())
            .findFirst();
        
        
        if (producto.isPresent()) {
            System.out.println("El producto existe: " + producto.get());
        } else {
            System.out.println("El producto no existe");
        }

        producto.ifPresentOrElse(
            p -> System.out.println(p),
            () -> System.out.println("Producto no encontrado"));

        System.out.println("- - - - - - - - - -");

        int idBuscado = 4;

        Optional<Product> productoById = productos.stream()
            .filter(p -> p.getId() == idBuscado)
            .findFirst();
        
        Optional<String> productName = productoById.map(Product::getName);

        productName.ifPresentOrElse(
            p -> System.out.println("Esta presente el producto: " + p), 
            () -> System.out.println("No se encuentra el producto"));

        System.out.println("- - - - - - - - - -");

        boolean hayProductoCaro = productos.stream().anyMatch(p -> p.getPrice() > 10000);
        boolean todosActivos = productos.stream().allMatch(Product::isActive);
        boolean ningunoNegativo = productos.stream().noneMatch(p -> p.getPrice() < 0);

        System.out.println((hayProductoCaro) ? "Si hay productos mayores a 10000" : "No hay productos mayores a 10000");
        System.out.println((todosActivos) ? "Todos los productos estan activos" : "No todos los productos estan activos");
        System.out.println((ningunoNegativo) ? "Ningun producto tiene un precio menor a 0" : "Un producto tiene un precio menor a 0");

        System.out.println("- - - - - - - - - -");

        double totalReduce = productos.stream()
            .filter(Product::isActive)
            .map(Product::getPrice)
            .reduce(0.0, (a,b) -> a + b);
        
        System.out.println("El total es: " + totalReduce);
    }
}
