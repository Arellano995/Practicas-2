package infijoprefijo;

import javax.swing.JOptionPane;


public class ConvertidorInfijoAPrefijo
{
    StringBuffer infijo, prefijo;//Leer expresion
    Pila pila;
 
    public void convertidorInfijoAPrefijo(StringBuffer infijo)
    {
        prefijo = new StringBuffer();
        pila = new Pila();  
        pila.push(')'); 
        infijo.insert(0, '(');
        
            for (int i = infijo.length()-1; i > -1; i--) {
            
              if (Character.isDigit(infijo.charAt(i)))
              {
                  prefijo.insert(0,infijo.charAt(i));
                  
              }else if(infijo.charAt(i) == ')'){
                  
                  pila.push(infijo.charAt(i));
                  
              } else if (esOperador(infijo.charAt(i))){
                  
                  boolean entroIf = true;
                  while (entroIf) {
                      Nodo operador = (Nodo) pila.pop();
                      System.out.println(operador.datos);
                      if (esOperador(operador.datos) && precedencia(operador.datos,infijo.charAt(i))) {
                          prefijo.insert(0,operador.datos);
                          entroIf = true;
                      } else {
                          pila.push(operador.datos);
                          pila.push(infijo.charAt(i));
                          entroIf = false;
                      }
                  }
                  
              } else if(infijo.charAt(i) == '('){
                  
                  boolean entroIf = true;
                  while (entroIf) {
                      Nodo operador = (Nodo) pila.pop();
                      System.out.println(operador.datos);
                      if (esOperador(operador.datos)) {
                          prefijo.insert(0,operador.datos);
                          entroIf = true;
                      } else {
                          System.out.println(operador.datos);
                          entroIf = false;
                      }
                  }       
                  
            }
        }
    }
    
    public boolean esOperador(char c)
    {
        if(c=='+'||c=='-'||c=='*'||c=='/'||c=='^'||c=='%'){
            return true;
        }else return false;
    }
    
    public boolean precedencia(char op1, char op2){
        
        int valorOp1 = 0;
        int valorOp2 = 0;
        
        switch (op1) {
            case '+':valorOp1=1;
                break;
            case '-':valorOp1=2;
                break;
            case '*':valorOp1=3;
                break;
            case '/':valorOp1=4;
                break;
            case '^':valorOp1=5;
                break;
            case '%':valorOp1=6;
                break;
        }

        switch (op2) {
            case '+':valorOp2=1;
                break;
            case '-':valorOp2=2;
                break;
            case '*':valorOp2=3;
                break;
            case '/':valorOp2=4;
                break;
            case '^':valorOp2=5;
                break;
            case '%':valorOp2=6;
                break;
        }
        
        if(valorOp1<valorOp2){
            return true;
        } else{
            return false;
        }
        
    }
  
    
}
