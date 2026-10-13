import java.util.List;

public class GenericsCollectios1 {
    public static <T> T obtenerUltimo(List<T> lista) {
        int getSize = lista.size();
        return lista.get(getSize-1);
    }

    public static <T> void imprimirLista(List<T> lista) {
        lista.stream().forEach(System.out::println);
    }

    public static void main(String[] args) {
        System.out.println("- - - - - Obtener ultimo indice - - - - -");
        List<String> nombres = List.of("Ana", "Luis", "Pedro");
        String ultimoNombre = obtenerUltimo(nombres);
        System.out.println(ultimoNombre);

        List<Integer> numeros = List.of(10, 20, 30, 40);
        Integer ultimoNumero = obtenerUltimo(numeros);
        System.out.println(ultimoNumero);

        System.out.println("- - - - - Imprimir lista - - - - -");
        imprimirLista(nombres);
        imprimirLista(numeros);
    }
}

