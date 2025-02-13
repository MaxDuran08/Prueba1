package practica;

public class Ejemplo_12_02_2024 {

    public static void main(String[] args) {

        // Expresiones aritméticas
        int num1 = 10000;
        int num2 = 30000;
        int suma = num1 + num2;
        int resta = num1 - num2;
        int multiplicacion = num1 * num2;
        double division = (num2 != 0) ? (double) num1 / num2 : 0;
        int residuo = 10 % 2;
        //operador ternario (? :)
        
        System.out.println("Suma: " + suma);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicacion: " + multiplicacion);
        System.out.println("Division: " + division);
        System.out.println("Residuo: " + residuo);
    }
    
}
