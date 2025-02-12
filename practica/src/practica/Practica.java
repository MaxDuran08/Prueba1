package practica;

import java.util.Scanner; // Importación de la clase Scanner para leer entradas del usuario
import java.util.Random;  // Importación de la clase Random para generar números aleatorios

public class Practica {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Creación del objeto scanner para leer entradas
        String[] palabras = new String[50]; // Arreglo para almacenar hasta 50 palabras
        int palabraCount = 0; // Contador de palabras ingresadas
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
                    nuevaPartida(scanner, palabras, palabraCount); // Inicia una nueva partida
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
        } while (opcion != 3); // El bucle sigue hasta que el usuario seleccione la opción 3
    }

    // Método que maneja la lógica de la nueva partida
    private static void nuevaPartida(Scanner scanner, String[] palabras, int palabraCount) {
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
                    palabraCount = menuPalabras(scanner, palabras, palabraCount); // Muestra el menú de palabras
                    break;
                case 2:
                    jugar(scanner, palabras, palabraCount); // Inicia el juego
                    break;
                case 3:
                    System.out.println("Terminando partida..."); // Mensaje al terminar la partida
                    return; // Sale del método y termina la partida
                default:
                    System.out.println("Opción inválida."); // Si la opción es inválida, muestra un mensaje
            }
        } while (opcion != 3); // El bucle se repite hasta que el usuario selecciona terminar la partida
    }

    // Método que muestra el menú de palabras (insertar, modificar, eliminar, regresar)
    private static int menuPalabras(Scanner scanner, String[] palabras, int palabraCount) {
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
            mostrarPalabras(palabras, palabraCount); // Muestra las palabras actuales
            System.out.print("Seleccione una opción: "); // Solicita una opción
            opcion = scanner.nextInt(); // Lee la opción seleccionada
            scanner.nextLine(); // Limpia el buffer de entrada

            // Realiza la acción correspondiente según la opción seleccionada
            switch (opcion) {
                case 1:
                    palabraCount = insertarPalabras(scanner, palabras, palabraCount); // Permite insertar una palabra
                    break;
                case 2:
                    modificarPalabra(scanner, palabras, palabraCount); // Permite modificar una palabra
                    break;
                case 3:
                    palabraCount = eliminarPalabra(scanner, palabras, palabraCount); // Permite eliminar una palabra
                    break;
                case 4:
                    return palabraCount; // Regresa al menú anterior
                default:
                    System.out.println("Opción inválida."); // Mensaje si la opción es inválida
            }
        } while (opcion != 4); // El bucle sigue hasta que el usuario elija regresar
        return palabraCount; // Retorna el número de palabras después de las modificaciones
    }

    // Método que inserta una palabra en el arreglo de palabras
    private static int insertarPalabras(Scanner scanner, String[] palabras, int palabraCount) {
        if (palabraCount >= palabras.length) {
            System.out.println("Error: Límite de palabras alcanzado."); // Mensaje si se ha alcanzado el límite de palabras
            return palabraCount; // Retorna sin hacer modificaciones
        }
        System.out.print("Ingrese la palabra: "); // Solicita la palabra al usuario
        String palabra = scanner.nextLine().toUpperCase(); // Lee la palabra y la convierte a mayúsculas
        if (palabra.length() >= 3 && palabra.length() <= 10) { // Verifica si la longitud es válida
            palabras[palabraCount++] = palabra; // Agrega la palabra al arreglo y aumenta el contador
            System.out.println("Palabra agregada correctamente."); // Mensaje de éxito
        } else {
            System.out.println("Error: Longitud no permitida."); // Mensaje de error si la longitud es incorrecta
        }
        mostrarPalabras(palabras, palabraCount); // Muestra las palabras actuales
        return palabraCount; // Retorna el contador de palabras
    }

    // Método que permite modificar una palabra existente en el arreglo
    private static void modificarPalabra(Scanner scanner, String[] palabras, int palabraCount) {
        System.out.print("Ingrese la palabra a modificar: "); // Solicita la palabra a modificar
        String palabraVieja = scanner.nextLine().toUpperCase(); // Lee la palabra y la convierte a mayúsculas
        for (int i = 0; i < palabraCount; i++) { // Recorre el arreglo de palabras
            if (palabras[i].equals(palabraVieja)) { // Si encuentra la palabra a modificar
                System.out.print("Ingrese la nueva palabra: "); // Solicita la nueva palabra
                String palabraNueva = scanner.nextLine().toUpperCase(); // Lee la nueva palabra
                if (palabraNueva.length() >= 3 && palabraNueva.length() <= 10) { // Verifica si la longitud es válida
                    palabras[i] = palabraNueva; // Reemplaza la palabra vieja por la nueva
                    System.out.println("Palabra modificada correctamente."); // Mensaje de éxito
                    mostrarPalabras(palabras, palabraCount); // Muestra las palabras actuales
                    return; // Termina el método
                } else {
                    System.out.println("Error: Longitud no permitida."); // Mensaje de error si la longitud es incorrecta
                }
            }
        }
        System.out.println("Error: Palabra no encontrada."); // Si no encuentra la palabra, muestra un error
    }

    // Método que elimina una palabra del arreglo
    private static int eliminarPalabra(Scanner scanner, String[] palabras, int palabraCount) {
        System.out.print("Ingrese la palabra a eliminar: "); // Solicita la palabra a eliminar
        String palabra = scanner.nextLine().toUpperCase(); // Lee la palabra y la convierte a mayúsculas
        for (int i = 0; i < palabraCount; i++) { // Recorre el arreglo de palabras
            if (palabras[i].equals(palabra)) { // Si encuentra la palabra a eliminar
                palabras[i] = palabras[palabraCount - 1]; // Reemplaza la palabra eliminada por la última
                palabras[palabraCount - 1] = null; // Elimina la última palabra
                System.out.println("Palabra eliminada correctamente."); // Mensaje de éxito
                mostrarPalabras(palabras, palabraCount - 1); // Muestra las palabras actuales después de la eliminación
                return palabraCount - 1; // Retorna el nuevo número de palabras
            }
        }
        System.out.println("Error: Palabra no encontrada."); // Si no encuentra la palabra, muestra un error
        return palabraCount; // Retorna el número de palabras sin cambios
    }

    // Método que muestra las palabras actuales almacenadas
    private static void mostrarPalabras(String[] palabras, int palabraCount) {
        if (palabraCount <= 0) { // Si no hay palabras, no muestra nada
            return;
        }
        System.out.println("Palabras actuales:"); // Muestra las palabras actuales
        for (int i = 0; i < palabraCount; i++) { // Recorre el arreglo y muestra cada palabra
            System.out.println((i + 1) + ") " + palabras[i]); // Muestra el índice y la palabra
        }
    }

    // Método que maneja la lógica del juego
    private static void jugar(Scanner scanner, String[] palabras, int palabraCount) {
        char[][] tablero = new char[16][16]; // Crea una matriz de 16x16 para el tablero del juego
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                tablero[i][j] = '-'; // Inicializa el tablero con guiones
            }
        }
        Random rand = new Random(); // Crea un objeto Random para generar números aleatorios

        // Coloca las palabras aleatoriamente en el tablero
        for (int i = 0; i < palabraCount; i++) {
            String palabra = palabras[i]; // Toma una palabra del arreglo
            boolean colocada = false; // Indica si la palabra se ha colocado en el tablero

            while (!colocada) { // Intenta colocar la palabra hasta que se logre
                int direccion = rand.nextInt(4); // Selecciona una dirección aleatoria (0=horizontal, 1=vertical, 2=horizontal inverso, 3=vertical inverso)
                int x = rand.nextInt(16); // Selecciona una posición aleatoria en el eje X
                int y = rand.nextInt(16); // Selecciona una posición aleatoria en el eje Y
                if (direccion == 0 && y + palabra.length() <= 16) { // Si la palabra puede colocarse horizontalmente
                    boolean espacioLibre = true; // Indica si hay espacio libre para colocar la palabra
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[x][y + j] != '-') { // Si ya hay algo en la posición, no se puede colocar
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x][y + j] = palabra.charAt(j); // Coloca la palabra en el tablero
                        }
                        colocada = true; // Marca que la palabra ha sido colocada
                    }
                } else if (direccion == 1 && x + palabra.length() <= 16) { // Si la palabra puede colocarse verticalmente
                    boolean espacioLibre = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[x + j][y] != '-') { // Si ya hay algo en la posición, no se puede colocar
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x + j][y] = palabra.charAt(j); // Coloca la palabra en el tablero
                        }
                        colocada = true;
                    }
                } else if (direccion == 2 && y - palabra.length() >= -1) { // Si la palabra puede colocarse horizontalmente en reverso
                    boolean espacioLibre = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[x][y - j] != '-') {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x][y - j] = palabra.charAt(j); // Coloca la palabra en el tablero
                        }
                        colocada = true;
                    }
                } else if (direccion == 3 && x - palabra.length() >= -1) { // Si la palabra puede colocarse verticalmente en reverso
                    boolean espacioLibre = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (tablero[x - j][y] != '-') {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x - j][y] = palabra.charAt(j); // Coloca la palabra en el tablero
                        }
                        colocada = true;
                    }
                }
            }
        }

        // Mostrar el tablero
        System.out.println("\n╔════════════════════════════════════════════════════════╗");
        System.out.println("║                    TABLERO                     ║");
        System.out.println("╚════════════════════════════════════════════════════════╝");
        System.out.print("   ");
        for (int i = 0; i < 16; i++) {
            System.out.printf("%2d ", i); // Muestra los números de las columnas
        }
        System.out.println();
        for (int i = 0; i < 16; i++) {
            System.out.printf("%2d ", i); // Muestra los números de las filas
            for (int j = 0; j < 16; j++) {
                System.out.print(" " + tablero[i][j] + " "); // Muestra cada celda del tablero
            }
            System.out.println();
        }
        System.out.println("Palabras descubiertas: 0 | Palabras no descubiertas: " + palabraCount); // Muestra las estadísticas del juego
        System.out.println("Presione Enter para salir..."); // Mensaje para que el jugador presione Enter para continuar
        scanner.nextLine(); // Espera que el jugador presione Enter
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