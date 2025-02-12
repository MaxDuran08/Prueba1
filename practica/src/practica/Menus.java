package practica;

import java.util.Scanner;

public class Menus {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creación del objeto scanner para leer entradas
        int opcion; // Variable para almacenar la opción seleccionada en los menús

        // Configuración de UTF-8 para mostrar caracteres especiales en consola
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            System.out.println("Error al establecer codificación UTF-8."); // Si ocurre un error, se muestra un mensaje
        }

        // Bucle principal del programa, que se repite hasta que se seleccione la opción 3 para salir
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║      MENÚ PRINCIPAL      ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Nueva Partida         ║");
            System.out.println("║ 2. Mostrar Información   ║");
            System.out.println("║ 3. Salir del Juego       ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: "); // Muestra el menú y solicita una opción
            opcion = scanner.nextInt(); // Lee la opción seleccionada por el usuario
            scanner.nextLine(); // Limpia el buffer de entrada

            // Realiza las acciones basadas en la opción seleccionada
            switch (opcion) {
                case 1:
                    nuevaPartidaMenu(scanner); // Muestra el menú de nueva partida
                    break;
                case 2:
                    mostrarInformacionEstudiante(); // Muestra la información del estudiante
                    break;
                case 3:
                    System.out.println("Saliendo del programa..."); // Mensaje al salir
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente."); // Mensaje de error si la opción es incorrecta
            }

            // Espera que el usuario presione una tecla para continuar
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();

        } while (opcion != 3); // El bucle sigue hasta que el usuario seleccione la opción 3
    }

    // Método para el menú de nueva partida
    private static void nuevaPartidaMenu(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║      NUEVA PARTIDA       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Menú de palabras      ║");
            System.out.println("║ 2. Jugar                 ║");
            System.out.println("║ 3. Terminar partida      ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: "); // Muestra el menú de la nueva partida
            opcion = scanner.nextInt(); // Lee la opción seleccionada
            scanner.nextLine(); // Limpia el buffer de entrada

            // Ejecuta las acciones dependiendo de la opción seleccionada
            switch (opcion) {
                case 1:
                    menuPalabras(scanner); // Muestra el menú de palabras
                    break;
                case 2:
                    System.out.println("Iniciando el juego..."); // Acción de jugar
                    break;
                case 3:
                    System.out.println("Terminando partida..."); // Mensaje al terminar la partida
                    return; // Sale del método y termina la partida
                default:
                    System.out.println("Opción inválida."); // Si la opción es inválida, muestra un mensaje
            }

            // Espera que el usuario presione una tecla para continuar
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();

        } while (opcion != 3); // El bucle se repite hasta que el usuario selecciona terminar la partida
    }

    // Método que muestra el menú de palabras (insertar, modificar, eliminar, regresar)
    private static void menuPalabras(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║      MENÚ PALABRAS       ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║ 1. Insertar              ║");
            System.out.println("║ 2. Modificar             ║");
            System.out.println("║ 3. Eliminar              ║");
            System.out.println("║ 4. Regresar              ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Seleccione una opción: "); // Solicita una opción
            opcion = scanner.nextInt(); // Lee la opción seleccionada
            scanner.nextLine(); // Limpia el buffer de entrada

            // Realiza la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1:
                    System.out.println("Opción para insertar palabras"); // Acción para insertar
                    break;
                case 2:
                    System.out.println("Opción para modificar palabras"); // Acción para modificar
                    break;
                case 3:
                    System.out.println("Opción para eliminar palabras"); // Acción para eliminar
                    break;
                case 4:
                    System.out.println("Regresando al menú anterior..."); // Regresa al menú anterior
                    return; // Sale del método
                default:
                    System.out.println("Opción inválida."); // Si la opción es inválida, muestra un mensaje
            }

            // Espera que el usuario presione una tecla para continuar
            System.out.print("Presione Enter para continuar...");
            scanner.nextLine();

        } while (opcion != 4); // El bucle sigue hasta que el usuario elija regresar
    }

    // Método que muestra la información del estudiante
    private static void mostrarInformacionEstudiante() {
        System.out.println("\n╔══════════════════════════════════╗");
        System.out.println("║  INFORMACIÓN DEL ESTUDIANTE  ║");
        System.out.println("╠══════════════════════════════════╣");
        System.out.println("║ Nombre: IPC 1                ║");
        System.out.println("║ Carnet: 123456789            ║");
        System.out.println("║ Sección: G                   ║");
        System.out.println("╚══════════════════════════════════╝");
    }
}
