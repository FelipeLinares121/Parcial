 
package ListaCircular;
 
import java.util.Scanner; 

public class ListaCircular { 
    
    
    private Nodo inicio;
    private Nodo finale;
    private static Nodo puerta;
    
    
    private int size=10; 
    
    
    public ListaCircular(){
    int n=0; 
        for(int i=0; i<10 ; i++){
            if(i<1){
                Nodo nodo = new Nodo();
                nodo.setSiguiente(nodo);
                nodo.setAnterior(nodo);
                
                inicio=nodo;
                finale=inicio;  
                puerta=inicio;
            }else{
                Nodo nodo = new Nodo();
                
                finale.setSiguiente(nodo);
                nodo.setAnterior(finale);
                finale=nodo;
                inicio.setAnterior(finale);
                finale.setSiguiente(inicio);   
            }      
        }
    }
        
    
    public void aparcar(){
        Nodo save = puerta; 
        boolean seguro=true;
        if(puerta.getCarro()==null){
           crearCarro();  
        }else{
            int DistanciaX=0;
            int DistanciaY=0;
            while(puerta.getCarro()!=null && DistanciaY!=10){
                DistanciaY++;
                puerta=puerta.getSiguiente();
            }
            puerta=save;   
            if(DistanciaY!=10){
                while(puerta.getCarro()!=null && DistanciaX!=10){
                DistanciaX++;
                puerta=puerta.getAnterior();
                }
                puerta=save; 
            }else{
                System.out.println("Estacionamiento lleno");
                seguro=false;
            }
            if(seguro){ 
                if(DistanciaY<=DistanciaX){  
                    while(DistanciaY!=0){
                        puerta=puerta.getSiguiente();
                        DistanciaY--; 
                    }
                    crearCarro();
                }else{
                    while(DistanciaX!=0){ 
                        puerta=puerta.getAnterior();
                        DistanciaX--; 
                    }

                    crearCarro();
                }
            }
        }
    }
    
    
    public void retirarAutoPlaca(String placa){
        int i=0;
        Nodo actual=puerta;
        while(i!=10){
            try{
                if(puerta.getCarro().getPlaca().compareTo(placa)==0){
                    imprimir();
                    System.out.println("Vuelva pronto");
                    puerta.setCarro(null);
                    ListaCircular.Pagar();
                    break;
                }else{
                    puerta=puerta.getSiguiente(); 
                } 
            }catch(NullPointerException error){
                puerta=puerta.getSiguiente();  
            }
            i=i+1;
        } 
            if(i==10){
               System.out.println("Ningun auto coincide con la placa: "+placa);
               puerta=actual;
            }
               
    }
    public void retirarAutoCedula(String cedula){
        Nodo actual=puerta;
        int i=0;
        while(i!=10){
            try{
                if(puerta.getCarro().getCedula().compareTo(cedula)==0){
                   System.out.println("Vuelva pronto");
                   puerta.setCarro(null);
                   ListaCircular.Pagar();
                   break;
               }else{
                    puerta=puerta.getSiguiente();
                                 
                    } 
            }catch(NullPointerException error){
                puerta=puerta.getSiguiente();           
                   }
            i=i+1;
        }
        if(i==10){
            System.out.println("Ningun auto coincide con la placa: "+cedula);
            puerta=actual;
        }
    }
     
    
    public static void Pagar(){
        int tiempo;
        Scanner orden = new Scanner(System.in);
        System.out.println("Horas de uso");
        while(true){
            try{
            tiempo = Integer.parseInt(orden.nextLine());
            break;
        }catch(NumberFormatException nn){
            System.out.println("valor introducido incorrecto, no se ira hasta decirnos el tiempo de uso");
        }
        }
        int precioHora=550;
        int total = precioHora*tiempo; 
        System.out.println("Pagar "+total+" al vigilante");
    }

    
    public void imprimir(){
        puerta.getCarro().informacion();
    }
    
    public void circular(){
        int i=0;
        Nodo actual=inicio;
        while(i!=10){
            try{ 
                actual.getCarro().informacion(); 
                actual=actual.getSiguiente();
                i=i+1;
                System.out.println("i:"+i+"\n");  
                
                
            }catch(NullPointerException error){   
                actual=actual.getSiguiente();
                i=i+1;
                 
            } 
        
        }   

    }
    
    
    public Nodo getPrimero() {
        return inicio;
    }

    
    public Nodo getFinale() {
        return finale;
    }
     

    public void crearCarro(){
        Scanner orden = new Scanner(System.in);
        
        System.out.println("PLACA");
        String placa = orden.nextLine();
        
        System.out.println("CEDULA");
        String cedula = orden.nextLine();
        
        System.out.println("MARCA");
        String marca = orden.nextLine();
        
        System.out.println("¿AFILIADO? Si o No"); 
        String afiliado = orden.nextLine(); 
 
        Carro auto = new Carro(placa, marca,cedula,afiliado);
        puerta.setCarro(auto); 
    }

    

}


