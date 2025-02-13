package practica;

import java.util.Scanner;
import java.util.Random;

public class Explicacion {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] palabras = new String[50][4]; // Cambié a una matriz bidimensional
        int palabraCount = 0;
        int opcion;

        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (Exception e) {
            System.out.println("Error al establecer codificación UTF-8.");
        }

        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      MENÚ PRINCIPAL      ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Nueva Partida         ║");
            System.out.println("║ 2. Mostrar Información   ║");
            System.out.println("║ 3. Salir del Juego       ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    nuevaPartida(scanner, palabras, palabraCount);
                    break;
                case 2:
                    mostrarInformacionEstudiante();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }

    private static void nuevaPartida(Scanner scanner, String[][] palabras, int palabraCount) {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      NUEVA PARTIDA       ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Menú de palabras      ║");
            System.out.println("║ 2. Jugar                 ║");
            System.out.println("║ 3. Terminar partida      ║");
            System.out.println("╚════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    palabraCount = menuPalabras(scanner, palabras, palabraCount);
                    break;
                case 2:
                    jugar(scanner, palabras, palabraCount);
                    break;
                case 3:
                    System.out.println("Terminando partida...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    private static int menuPalabras(Scanner scanner, String[][] palabras, int palabraCount) {
        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════╗");
            System.out.println("║      MENÚ PALABRAS       ║");
            System.out.println("╠════════════════════════════════╣");
            System.out.println("║ 1. Insertar              ║");
            System.out.println("║ 2. Modificar             ║");
            System.out.println("║ 3. Eliminar              ║");
            System.out.println("║ 4. Regresar              ║");
            System.out.println("╚════════════════════════════════╝");
            mostrarPalabras(palabras, palabraCount);
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    palabraCount = insertarPalabras(scanner, palabras, palabraCount);
                    break;
                case 2:
                    modificarPalabra(scanner, palabras, palabraCount);
                    break;
                case 3:
                    palabraCount = eliminarPalabra(scanner, palabras, palabraCount);
                    break;
                case 4:
                    return palabraCount;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 4);
        return palabraCount;
    }

    private static int insertarPalabras(Scanner scanner, String[][] palabras, int palabraCount) {
        System.out.print("Ingrese la cantidad de palabras que desea ingresar: ");
        int numPalabras = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer de entrada

        for (int i = 0; i < numPalabras; i++) {
            System.out.print("Ingrese la palabra #" + (i + 1) + ": ");
            String palabra = scanner.nextLine().toUpperCase();

            // Verificar longitud de palabra según la sección
            int longitudMin = 6; // Longitud mínima (se puede ajustar dependiendo de la sección)
            int longitudMax = 10; // Longitud máxima (se puede ajustar dependiendo de la sección)

            // Verificar que la palabra esté en el rango permitido
            if (palabra.length() >= longitudMin && palabra.length() <= longitudMax) {
                palabras[palabraCount][0] = palabra; // Asignar palabra a la matriz
                palabraCount++;
            } else {
                System.out.println("Error: La palabra debe tener entre " + longitudMin + " y " + longitudMax + " caracteres.");
                i--; // Devolver para intentar nuevamente
            }
        }
        return palabraCount;
    }

    private static void modificarPalabra(Scanner scanner, String[][] palabras, int palabraCount) {
        System.out.print("Ingrese la palabra a modificar: ");
        String palabraOriginal = scanner.nextLine().toUpperCase();
        boolean encontrado = false;

        for (int i = 0; i < palabraCount; i++) {
            if (palabras[i][0].equals(palabraOriginal)) {
                System.out.print("Ingrese la nueva palabra: ");
                String nuevaPalabra = scanner.nextLine().toUpperCase();
                // Verificar la longitud de la nueva palabra
                if (nuevaPalabra.length() >= 6 && nuevaPalabra.length() <= 10) {
                    palabras[i][0] = nuevaPalabra;
                    System.out.println("Palabra modificada exitosamente.");
                } else {
                    System.out.println("Error: La nueva palabra debe tener entre 4 y 10 caracteres.");
                }
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("La palabra no se encontró en el banco.");
        }
    }

    private static int eliminarPalabra(Scanner scanner, String[][] palabras, int palabraCount) {
        System.out.print("Ingrese la palabra a eliminar: ");
        String palabraEliminar = scanner.nextLine();
        boolean encontrado = false;

        for (int i = 0; i < palabraCount; i++) {
            if (palabras[i][0].equals(palabraEliminar)) {
                palabras[i][0] = palabras[--palabraCount][0]; // Reemplazar la palabra a eliminar con la última
                System.out.println("Palabra eliminada exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("La palabra no se encontró en el banco.");
        }

        return palabraCount;
    }

    private static void mostrarPalabras(String[][] palabras, int palabraCount) {
        if (palabraCount <= 0) {
            return;
        }
        System.out.println("Palabras actuales:");
        for (int i = 0; i < palabraCount; i++) {
            System.out.println((i + 1) + ") " + palabras[i][0]); // Accedemos al primer elemento de la fila
        }
    }

    private static void jugar(Scanner scanner, String[][] palabras, int palabraCount) {
        if (palabraCount == 0) {
            System.out.println("No hay palabras guardadas. Agregue palabras antes de jugar.");
            return;
        }

        char[][] tablero = new char[16][16];
        // Inicializamos el tablero
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                tablero[i][j] = '-';
            }
        }

        Random rand = new Random();
        boolean[][] ocupado = new boolean[16][16]; // Para verificar posiciones ocupadas

        // Colocamos las palabras de manera aleatoria en el tablero
        for (int i = 0; i < palabraCount; i++) {
            String palabra = palabras[i][0]; // Obtenemos la palabra de la matriz
            boolean colocada = false;
            while (!colocada) {
                int direccion = rand.nextInt(2); // 0 horizontal, 1 vertical
                palabras[i][1] = Integer.toString(direccion);
                int x = rand.nextInt(16);
                palabras[i][2] = Integer.toString(x);
                int y = rand.nextInt(16);
                palabras[i][3] = Integer.toString(y);

                // Verificamos si la palabra cabe en la dirección seleccionada
                if (direccion == 0 && y + palabra.length() <= 16) { // Horizontal
                    boolean espacioLibre = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (ocupado[x][y + j]) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x][y + j] = palabra.charAt(j);
                            ocupado[x][y + j] = true; // Marcar las casillas como ocupadas
                        }
                        colocada = true;
                    }
                } else if (direccion == 1 && x + palabra.length() <= 16) { // Vertical
                    boolean espacioLibre = true;
                    for (int j = 0; j < palabra.length(); j++) {
                        if (ocupado[x + j][y]) {
                            espacioLibre = false;
                            break;
                        }
                    }
                    if (espacioLibre) {
                        for (int j = 0; j < palabra.length(); j++) {
                            tablero[x + j][y] = palabra.charAt(j);
                            ocupado[x + j][y] = true; // Marcar las casillas como ocupadas
                        }
                        colocada = true;
                    }
                }
            }
        }

        // Rellenar las casillas vacías con letras aleatorias
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 16; j++) {
                if (tablero[i][j] == '-') {
                    tablero[i][j] = (char) ('A' + rand.nextInt(26)); // Asignar letra aleatoria
                }
            }
        }

        int puntos = 25;
        int fallos = 0;
        int palabrasEncontradas = 0;
        int palabrasPendientes = palabraCount;

        // Ciclo de juego
        while (fallos < 4 && palabrasEncontradas < palabraCount) {
            // Mostrar el tablero
            mostrarTablero(tablero);
            System.out.print("Ingrese una palabra: ");
            String palabraIngresada = scanner.nextLine().toUpperCase();

            boolean encontrada = false;
            int nuevosPuntos = 0;
            for (int i = 0; i < palabraCount; i++) {
                if (palabraIngresada.equals(palabras[i][0])) {
                    palabrasEncontradas++;
                    nuevosPuntos = palabras[i][0].length();
                    puntos += nuevosPuntos; // Aumentar puntos
                    // Reemplazar la palabra en el tablero con '#'

                    int direccion = Integer.parseInt(palabras[i][1]); // Obtener la dirección almacenada
                    int x = Integer.parseInt(palabras[i][2]); // Obtener la coordenada X
                    int y = Integer.parseInt(palabras[i][3]); // Obtener la coordenada Y

                    // Reemplazar la palabra encontrada por '#'
                    if (direccion == 0) { // Horizontal
                        for (int j = 0; j < palabraIngresada.length(); j++) {
                            tablero[x][y + j] = '#';
                        }
                    } else if (direccion == 1) { // Vertical
                        for (int j = 0; j < palabraIngresada.length(); j++) {
                            tablero[x + j][y] = '#';
                        }
                    }
                    
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {
                fallos++;
                puntos -= 5; // Restar puntos por fallo
                System.out.println("Palabra incorrecta. Tienes " + (4 - fallos) + " intentos restantes.");
            } else {
                System.out.println("Palabra encontrada, obtienes " + nuevosPuntos + " puntos nuevos.");
                palabrasPendientes--;
            }

            System.out.println("Puntaje actual: " + puntos);
            System.out.println("Palabras pendientes: " + palabrasPendientes);
        }
    }

    private static void mostrarTablero(char[][] tablero) {
        System.out.println("\n╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                    TABLERO                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("   ");
        for (int i = 0; i < 16; i++) {
            System.out.printf("%2d ", (i + 1)); // Muestra los números de las columnas
        }
        System.out.println();
        for (int i = 0; i < 16; i++) {
            System.out.printf("%2d ", (i + 1)); // Muestra los números de las filas
            for (int j = 0; j < 16; j++) {
                System.out.print(" " + tablero[i][j] + " "); // Muestra cada celda del tablero
            }
            System.out.println();
        }
    }

    private static void mostrarInformacionEstudiante() {
        System.out.println("\nNombre: IPC 1\nCarnet: 123456789\nSección: G");
    }
}
