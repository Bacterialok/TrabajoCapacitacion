
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Streams1 {
    public static void main(String[] args) {
        List<Product> productos = List.of(
            new Product(1, "Laptop", 15000, true, "ELECTRONICS"),
            new Product(2, "Mouse", 500, true, "ELECTRONICS"),
            new Product(3, "Cable", 80, true, "ACCESSORIES"),
            new Product(4, "Monitor", 4500, false, "ELECTRONICS"),
            new Product(5, "Teclado", 1200, true, "ACCESSORIES")
        );

        System.out.println("- - - Filtrar productos activos con precio mayor a 100 usando FOR - - -");

        for (Product producto : productos) {
            if (producto.getPrice() > 100 && producto.isActive()) {
                System.out.println(producto);
            }
        }

        System.out.println("- - - Filtrar productos activos mayores a 100 y ordenar por precio - - -");

        productos.stream()
            .filter(p -> p.isActive() && p.getPrice() > 100)
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        System.out.println("- - - Obtener nombres de productos activos usando MAP - - -");

        List<String> nombres = productos.stream()
            .filter(p -> p.isActive())
            .map(p -> p.getName())
            .toList();

        System.out.println(nombres);

        System.out.println("- - - Ordenar productos activos por precio de menor a mayor - - -");

        productos.stream()
            .filter(p -> p.isActive())
            .sorted(Comparator.comparingDouble(Product::getPrice))
            .forEach(p -> System.out.println(p.getName() + " " + p.getPrice()));

        System.out.println("- - - Sumar precios de productos activos usando SUM - - -");

        double total = productos.stream()
            .filter(p -> p.isActive())
            .mapToDouble(p -> p.getPrice())
            .sum();

        System.out.println("Total:    " + total);

        System.out.println("- - - Buscar el primer producto activo con precio mayor a 1000 usando OPTIONAL - - -");

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

        System.out.println("- - - Buscar producto por ID y obtener su nombre usando OPTIONAL MAP - - -");

        int idBuscado = 4;

        Optional<Product> productoById = productos.stream()
            .filter(p -> p.getId() == idBuscado)
            .findFirst();

        Optional<String> productName = productoById.map(Product::getName);

        productName.ifPresentOrElse(
            p -> System.out.println("Esta presente el producto: " + p),
            () -> System.out.println("No se encuentra el producto"));

        System.out.println("- - - Verificar condiciones usando ANYMATCH ALLMATCH y NONEMATCH - - -");

        boolean hayProductoCaro = productos.stream()
            .anyMatch(p -> p.getPrice() > 10000);

        boolean todosActivos = productos.stream()
            .allMatch(Product::isActive);

        boolean ningunoNegativo = productos.stream()
            .noneMatch(p -> p.getPrice() < 0);

        System.out.println((hayProductoCaro) ? "Si hay productos mayores a 10000" : "No hay productos mayores a 10000");
        System.out.println((todosActivos) ? "Todos los productos estan activos" : "No todos los productos estan activos");
        System.out.println((ningunoNegativo) ? "Ningun producto tiene un precio menor a 0" : "Un producto tiene un precio menor a 0");

        System.out.println("- - - Sumar precios de productos activos usando REDUCE - - -");

        double totalReduce = productos.stream()
            .filter(Product::isActive)
            .map(Product::getPrice)
            .reduce(0.0, (a, b) -> a + b);

        System.out.println("El total es: " + totalReduce);

        System.out.println("- - - Separar productos activos e inactivos usando PARTITIONINGBY - - -");

        Map<Boolean, List<Product>> productosPorEstado = productos.stream()
            .collect(Collectors.partitioningBy(Product::isActive));

        System.out.println(productosPorEstado);

        System.out.println("- - - Agrupar productos por categoria usando GROUPINGBY - - -");

        Map<String, List<Product>> productosPorCategoria = productos.stream()
            .collect(Collectors.groupingBy(Product::getCategory));

        System.out.println(productosPorCategoria);

        System.out.println("- - - Contar productos por categoria usando GROUPINGBY y COUNTING - - -");

        Map<String, Long> cantidadPorCategoria = productos.stream()
            .collect(
                Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.counting()));

        System.out.println(cantidadPorCategoria);

        System.out.println("- - - Sumar precios por categoria usando GROUPINGBY y SUMMINGDOUBLE - - -");

        Map<String, Double> totalPorCategoria = productos.stream()
            .collect(
                Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.summingDouble(Product::getPrice)));

        System.out.println(totalPorCategoria);

        System.out.println("- - - Sumar precios por categoria solo de productos activos - - -");

        Map<String, Double> totalPorCategoriaYActivos = productos.stream()
            .filter(Product::isActive)
            .collect(
                Collectors.groupingBy(
                    Product::getCategory,
                    Collectors.summingDouble(Product::getPrice)));

        System.out.println(totalPorCategoriaYActivos);

        System.out.println("- - - FIN DE EJERCICIOS DE JAVA STREAMS - - -");
    }
}
