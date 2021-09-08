 
package ListaCircular;
 
import ListaCircular.ListaCircular; 
import java.util.Scanner; 


public class Main {
    public static void main(String[] args){
        
        Scanner orden = new Scanner(System.in);
        ListaCircular circular = new ListaCircular();
        
        boolean bool = true;
        while(bool){
            System.out.println("1-Retirar auto con la placa          2-retirar auto con cedula             3-Aparcar            4-salir             5-Imprimir lista circular");
            int Opciones=Integer.parseInt(orden.nextLine());
            switch(Opciones){
                case 1: System.out.println("Numero de placa");
                        String placa = orden.nextLine();
                        circular.retirarAutoPlaca(placa);
                break;
                
                
                case 2: System.out.println("Numero de la cedula ");
                        String cedula = orden.nextLine();
                        circular.retirarAutoPlaca(cedula);
                break;
                
                
                case 3: circular.aparcar();
                break;
                
                
                case 4: bool=false;
                break;
                
                
                case 5: circular.circular();
                break;
                 
            }  
            
        }  
    } 
}

