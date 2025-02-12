//expedir boletos de tren
import java.util.HashMap;
import java.util.Scanner;  
import java.util.Map;

public class bloletosMachine{
    private static Map<Integer, String> destinos = new HashMap<>();
    private static Map<Long, Integer> tarjetas = new HashMap<>();

    static{
        destinos.put(1, "Mexico");
        destinos.put(2, "Guadalajara");
        destinos.put(3, "Monterrey");
        destinos.put(4, "Puebla");
        destinos.put(5, "Merida");
    
        tarjetas.put(1234567890123456L, 1234);
        tarjetas.put(2345678901234567L, 2345);
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Expedicion de boletos de tren");
        System.out.println("Seleccione el destino deseado");
        for (Map.Entry<Integer, String> entry : destinos.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("numero de destino: ");
        int destinoSeleccionado = scanner.nextInt();
        scanner.nextLine();

        if (!destinos.containsKey(destinoSeleccionado)){
            System.out.println("Destino no valido");
            return;
        }

        System.out.println("has seleccionado: " + destinos.get(destinoSeleccionado));
        System.out.println("Ingrese el numero de tarjeta: ");
        String numeroTarjeta = scanner.nextLine();

        System.out.println("Ingrese el numero de pin: ");
        int pin = scanner.nextInt();

        

        if (validoTarjeta(numeroTarjeta, pin)){
            System.out.println("Boleto expedido");
            System.out.println("Boleto a: " + destinos.get(destinoSeleccionado));
        }else{
            System.out.println("Tarjeta invalida");
        }
        scanner.close();
    }
    private static boolean validoTarjeta(String numeroTarjeta, int pin) {
            return tarjetas.containsKey(numeroTarjeta) && tarjetas.get(numeroTarjeta).equals(pin);
    }
}