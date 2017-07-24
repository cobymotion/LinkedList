
import java.util.Scanner;

public class FuncionamientoLista {
    
    static NodoCliente raiz, ant, ite; 

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int op = 0; // opciones para el menu 
        while(op!=4){
            menu(); 
            op = Integer.parseInt(sc.nextLine());
           switch(op)
           {
               case 1: 
                   NodoCliente nuevo = new NodoCliente(); 
                   System.out.println("Nombre: ");
                   nuevo.nombre = sc.nextLine();
                   if(raiz==null)
                       raiz = nuevo; 
                   else 
                       acomodar(raiz,nuevo);
                   break;
               case 2: 
                   System.out.println("Nombre a borrar");
                   String nombre = sc.nextLine(); 
                   borrar(raiz, nombre);
               case 3: 
                   System.out.println("La lista es: ");
                   mostrar(raiz);
                   break;
               case 4:
                   System.out.println("Saliendo ......");
                   break;
               default: 
                   System.out.println("Opcion no valida");
           }
        }
        
}
    
    public static void menu() {
        System.out.println("1) Agregar ");
        System.out.println("2) Eliminar ");
        System.out.println("3) Mostrar");
        System.out.println("4) Salir");
        System.out.print("Opcion: ");
    }

    private static void acomodar(NodoCliente raiz, NodoCliente nuevo) {
        if(raiz.sig==null)
            raiz.sig = nuevo; 
        else 
            acomodar(raiz.sig, nuevo);
    }

    private static void mostrar(NodoCliente raiz) {
        if(raiz!=null)
        {
            
            mostrar(raiz.sig);
            System.out.println("Nombre: " + raiz.nombre);
        }
    }

    public static void borrar(NodoCliente raiz, String nombre) {
        // tres casos        
        if(raiz.nombre.equals(nombre))
           FuncionamientoLista.raiz = raiz.sig;
        else {
            ite = raiz; 
            while(ite.sig!=null)
            {
                ant = ite; 
                ite = ite.sig; 
                if(ite.nombre.equals(nombre)){
                    ant.sig = ite.sig; 
                    break;
                }
            }
        }
    }
    
}
