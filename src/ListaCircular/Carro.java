 
package ListaCircular;
 
import javax.swing.JOptionPane;

public class Carro {  
    
    private String marca;
    private String cedula;
    private String afiliado;
    private String placa;

    public String getPlaca() {
        return placa;
    }

    public String getMarca() {
        return marca;
    }

    public String getIdentificacion() {
        return cedula;
    }

    public String isAfiliacion() {
        return afiliado;
    }
 
    public Carro(String placa, String marca,String cedula,String afiliado){
        this.placa=placa;
        this.marca=marca;
        this.cedula=cedula;
        this.afiliado=afiliado;
                
    }
    
    public void setPlaca(String placa) {
        if(placa==null){
            this.placa = placa;
        }else{
            System.out.println("Carro ");
        }
    }
 
    public void setMarca(String marca) {
        if(placa==null){
            this.marca = marca;
        }else{
            System.out.println("Carro busy");
        }
        
    }
 
    public void setCedula(String cedula) {
        if(placa==null){
            this.cedula = cedula;
        }else{
            System.out.println("Carro busy");
        }
        
    }
 
    public void setAfiliado(String afiliado) {
        if(placa==null){
            this.afiliado = afiliado;
        }else{
            System.out.println("Carro busy");
        }
        
    }

    public String getCedula() {
        return cedula;
    }
    
    
    public void informacion(){ 
        
            System.out.println("cedula:  "+cedula
                +"\nPLACA:     "+placa
                +"\nMODELO:    "+marca
                +"\nAFILIACION:  "+afiliado );
                 
        
    }
    
    
    
       
}
