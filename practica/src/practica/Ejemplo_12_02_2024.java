package practica;

public class Ejemplo_12_02_2024 {

    //Funcion
    public static String resultado(){
        System.out.println("Yo soy una funcion");
        int resul = 2 + 2;
        String var = "false";
        if(resul<0){
            return var;
        } else {
            return "true";
        }
    }
    
    //Metodo
    public static void metodo(int num1, int num2, String mensaje){
        System.out.println("Yo soy un metodo");
        System.out.println("Este e num1: " + num1);
        System.out.println("Este e num2: " + num2);
        System.out.println("Este es el mensaje: "+ mensaje);
    }
    
    public static void main(String[] args) {
        String key = resultado();
        System.out.println(key);
    }
    
}
