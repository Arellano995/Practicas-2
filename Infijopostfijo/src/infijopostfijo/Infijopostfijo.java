package infijopostfijo;
 import java.util.*;
/**
 *
 * @author noear
 */
public class Infijopostfijo {

     /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Entrada de datos
        System.out.println("Escribe una expresion algebraica: ");
        Scanner leer = new Scanner(System.in);
        //Depurar la expresion algebraica
        String expr = depurar(leer.nextLine());
        String[] arrayInfix = expr.split(" ");
        //Declaracion de las pilas
        Stack < String > E = new Stack < String > (); //Pila entrada
        Stack < String > P = new Stack < String > (); //Pila temporal para
        Stack < String > S = new Stack < String > (); //Pila salida
        
        //Añadir la array a la Pila de entrada (E)
        for (int i = arrayInfix.length - 1; i >=0; i--){
            E.push(arrayInfix[i]);
        }
        try {
            //Algoritmo Infijo a Posfijo
            while (!E.isEmpty()){
                switch (pref(E.peek())){
                    case 1:
                        P.push(E.pop());
                        break;
                    case 3:
                    case 4:
                        while(pref(P.peek()) >= pref(E.peek())) {
                            S.push(P.pop());
                        }
                        P.push(E.pop());
                        break;
                    case 2:
                        while(!P.peek().equals("(")){
                            S.push(P.pop());
                        }
                        P.pop();
                        E.pop();
                        break;
                    default:
                        S.push(E.pop());
                }
            }
            //Eliminacion de 'impurezas' en la expresiones algbraicas
            String infix = expr.replace(" ", "");
            String postfix = S.toString().replaceAll("[\\]\\[,]","");
            //Mostrar resultados;
            System.out.println("Expresion infija: " + infix);
            System.out.println("Expresion Postfija: " + postfix);
        }catch(Exception ex){
            System.out.println("Error en la expresion algebraica");
            System.err.println(ex);
        }
    }
    //Deputar expresion algebraica.
    private static String depurar(String s) {
        s = s.replaceAll("\\s", ""); //Elimina espacios en blanco
        s = "(" + s + ")";
        String simbols = "+-*/()";
        String str = "";
        //Deja espacios entre operadores
        for (int i = 0; i < s.length (); i++){
            if (simbols.contains("" + s.charAt(i))){
                str += " " + s.charAt (i) + " ";
            }else str += s.charAt(i);
        }
        return str.replaceAll("\\s+", " ").trim();
    }
    //Jerarquia de los operadores
    private static int pref(String op){
        int prf = 99;
        if (op.equals("^")) prf = 5;
        if (op.equals("*") || op.equals("/")) prf = 4;
        if (op.equals("+") || op.equals("-")) prf = 3;
        if (op.equals(")")) prf = 2;
        if (op.equals("(")) prf = 1;
        return prf;
    }
}
