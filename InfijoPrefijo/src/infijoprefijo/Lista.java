package infijoprefijo;

public class Lista 
{
   private Nodo primerNodo;
   private Nodo ultimoNodo;
   private Nodo actualNodo;
   private String nombre; 
  
   public Lista() 
   { 
      this( "lista" ); 
   } 
   
   public Lista( String nombreLista )
   {
      nombre = nombreLista;
      primerNodo = ultimoNodo = null;
   } 
   public void insertarAlFrente( char elementoInsertar )
   {
      if ( estaVacia() ) 
         primerNodo = ultimoNodo = new Nodo( elementoInsertar );
      else 
         primerNodo = new Nodo( elementoInsertar, primerNodo );
   } 

   
   public void insertarAlFinal( char elementoInsertar )
   {
      if ( estaVacia() ) 
         primerNodo = ultimoNodo = new Nodo( elementoInsertar );
      else 
         ultimoNodo = ultimoNodo.siguienteNodo = new Nodo( elementoInsertar );
   } 
   
   public Object eliminarDelFrente() throws ExcepcionListaVacia
   {
      if ( estaVacia() ) 
         throw new ExcepcionListaVacia( nombre );

      Object elementoEliminado = primerNodo; 

   
      if ( primerNodo == ultimoNodo )
         primerNodo = ultimoNodo = null;
      else
         primerNodo = primerNodo.siguienteNodo;

      return elementoEliminado;
   } 

   public Object eliminarDelFinal() throws ExcepcionListaVacia
   {
      if ( estaVacia() ) 
         throw new ExcepcionListaVacia( nombre );

      Object elementoEliminado = ultimoNodo.datos; 

    
      if ( primerNodo == ultimoNodo )
         primerNodo = ultimoNodo = null;
      else 
      { 
         Nodo actual = primerNodo;

         while ( actual.siguienteNodo != ultimoNodo )
            actual = actual.siguienteNodo;
   
         ultimoNodo = actual; 
         actual.siguienteNodo = null;
      } 

      return elementoEliminado; 
   } 
   
   public int cantidadNodos() {
        int can = 0;
        Nodo aux = primerNodo; 
        while (aux != null) { 
            can++; 
            aux = aux.siguienteNodo;
        }
        System.out.println("cant " + can);
        return can;
    }
   
   public Nodo getActual(){
       return actualNodo;
   }
   
   public boolean ultimo(){
       actualNodo = ultimoNodo;
       return true;
   }
   
   public boolean first(){
       actualNodo = primerNodo;
       return true;
   }
   
   public boolean anterior() {
       Nodo antNodo = primerNodo;
        if (ultimoNodo == null) {
            return false;
        }
        if(actualNodo == primerNodo){
            return false;
        }
        if (actualNodo == null) {
            actualNodo = ultimoNodo;
            return true;
        } else {
            while (antNodo.siguienteNodo != actualNodo) {  
                antNodo = antNodo.siguienteNodo;  
            }
            actualNodo = antNodo;
            return true;
        }
    }
   
   public boolean next() {
        if (primerNodo == null) {
            return false;
        }
        if (actualNodo == null) {
            actualNodo = primerNodo;
            return true;
        } else {
            if (actualNodo.siguienteNodo != null) {
                actualNodo = actualNodo.siguienteNodo;
                return true;
            } else {
                return false;
            }
        }
    }
     
   public boolean estaVacia()
   { 
      return primerNodo == null; 
   }
   
   public Object parteSuperiorPila() 
   {
       Object valor = ultimoNodo.datos;
       return valor;
   }
   
   public void imprimir()
   {
      if ( estaVacia() ) 
      {
         System.out.printf( "%s vacia\n", nombre );
         return;
      }

      System.out.printf( "La %s es: ", nombre );
      Nodo actual = primerNodo;

   
      while ( actual != null ) 
      {
         System.out.printf( "%s ", actual.datos );
         actual = actual.siguienteNodo;
      } 

      System.out.println( "\n" );
   } 
}
