import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Deposito {

    static class Ubicacion {
        int fila;     // 0 a 8
        int columna;  // 0 a 3
        int nivel;    // 0 a 2

        public Ubicacion(int fila, int columna, int nivel) {
            this.fila = fila;
            this.columna = columna;
            this.nivel = nivel;
        }

        @Override
        public String toString() {
            return "Fila: " + (fila + 1) + ", Columna: " + (columna + 1) + ", Nivel: " + (nivel + 1);
        }
    }

    public static void main(String[] args) {

        Map<String, Ubicacion> mapaTambores = new HashMap<>();

        int codigoActual = 1;

        // Recorrer todo el depósito: 9 filas, 4 columnas, 3 niveles
        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 4; columna++) {
                for (int nivel = 0; nivel < 3; nivel++) {
                    // Cada pallet tiene 4 tambores
                    for (int i = 0; i < 4; i++) {
                        String codigo = String.format("T%03d", codigoActual++);
                        mapaTambores.put(codigo, new Ubicacion(fila, columna, nivel));
                    }
                }
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Sistema de búsqueda de tambores ===");
        while (true) {
            System.out.print("Ingrese código de tambor (ej: T012) o 'salir': ");
            String codigo = scanner.nextLine().trim().toUpperCase();

            if (codigo.equals("SALIR")) {
                System.out.println("Saliendo del sistema.");
                break;
            }

            Ubicacion ubicacion = mapaTambores.get(codigo);
            if (ubicacion != null) {
                System.out.println("✅ Tambor " + codigo + " ubicado en: " + ubicacion);
            } else {
                System.out.println("❌ Tambor no encontrado.");
            }
        }

        scanner.close();
    }
}
