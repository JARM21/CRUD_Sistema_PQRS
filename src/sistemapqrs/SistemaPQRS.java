/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sistemapqrs;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class SistemaPQRS {
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       CRUD obj = new CRUD();
       
       // Crear o agregar un cliente
       //obj.crearcliente();
       
       //Listar todos los clientes
        System.out.println("Listado de clientes : ");
        obj.listarClientes();
       /*
        
        boolean actualizado = obj.actualizarCliente(1, "Isabel", "Marin", "Isabel.marin@gmail.com");
        if (actualizado) {
            System.out.println("Cliente actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el cliente.");
        }
*/
       
       boolean eliminado = obj.eliminarcliente(1);
        if (eliminado) {
            System.out.println("Cliente eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el cliente.");
        }
    }
}
    
        
       
    

