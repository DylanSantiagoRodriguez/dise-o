import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
//codigo maquina expendedora
public class app {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] productos = {"1. Agua - $1.00", "2. Refresco - $1.50", "3. Chocolate - $2.00"};
        double[] precios = {1.00, 1.50, 2.00};
        



        System.out.println("Bienvenido a la máquina expendedora");
        System.out.println("Seleccione un producto:");
        Map<Integer, String> productosMap = new HashMap<>();
        Map<Integer, Double> preciosMap = new HashMap<>();

        for (int i = 0; i < productos.length; i++) {
            productosMap.put(i + 1, productos[i]);
            preciosMap.put(i + 1, precios[i]);
        }

        for (Map.Entry<Integer, String> entry : productosMap.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue());
        }
        System.out.println("Ingrese el número del producto: ");
        int opcion = scanner.nextInt();

        if (opcion < 1 || opcion > productos.length) {
            System.out.println("Selección inválida. Intente de nuevo.");
            return;
        }

        double precio = precios[opcion - 1];
        System.out.printf("El precio del producto es: $%.2f\n", precio);
        System.out.println("Ingrese el dinero: $");
        double dineroIngresado = scanner.nextDouble();


        if (dineroIngresado < precio) {
            System.out.println("Dinero insuficiente. Operación cancelada.");
        } else {
            double cambio = dineroIngresado - precio;
            System.out.println("Producto dispensado. Gracias por su compra.");
            if (cambio > 0) {
                System.out.printf("Su cambio es: $%.2f\n", cambio);
            }
        }

        scanner.close();
    }
}