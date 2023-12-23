/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemapqrs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;

/**
 *
 * @author Usuario
 */
public class CRUD {
    
    String URL = "jdbc:mysql://localhost:3306/bd_sistema_pqrs_v2";  
    
    String usuario = "root";
            
    String contraseña = "";
    
    
           
    Statement statement;
    
    ResultSet rs;
    
    public boolean crearcliente(){
        try(Connection conexion = DriverManager.getConnection(URL, usuario, contraseña)){
            
            statement = conexion.createStatement();
            Integer rows = statement.executeUpdate("INSERT INTO CLIENTES(CLIENTENOMBRE,CLIENTEAPELLIDOS,CLIENTECORREO) VALUES('Jaime','Remso','Jaimealfonso@gmail.com')");
            
            if(rows > 0){
                return true;
            }
                    
        } catch (SQLException ex) {
           System.out.println(""+ ex.getMessage());
           
           return false;
        }
        return false;
       
      }
    
    
    public void listarClientes() {
        try (Connection conexion = DriverManager.getConnection(URL, usuario, contraseña)) {
            String sql = "SELECT CLIENTEID, CLIENTENOMBRE, CLIENTEAPELLIDOS, CLIENTECORREO FROM CLIENTES";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql);
                 ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int clienteId = resultSet.getInt("CLIENTEID");
                    String clienteNombre = resultSet.getString("CLIENTENOMBRE");
                    String clienteApellidos = resultSet.getString("CLIENTEAPELLIDOS");
                    String clienteCorreo = resultSet.getString("CLIENTECORREO");

                    System.out.println("ID: " + clienteId + ", Nombre: " + clienteNombre + ", Apellidos: " + clienteApellidos + ", Correo: " + clienteCorreo);
                }
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
        }
    }
   
    
    
    public boolean actualizarCliente(int clienteId, String nuevoNombre, String nuevosApellidos, String nuevocorreo) {
        try (Connection conexion = DriverManager.getConnection(URL, usuario, contraseña)) {
            String sql = "UPDATE CLIENTES SET CLIENTENOMBRE = ?, CLIENTEAPELLIDOS = ?, CLIENTECORREO = ? WHERE CLIENTEID = ?";
            try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
                preparedStatement.setString(1, nuevoNombre);
                preparedStatement.setString(2, nuevosApellidos);
                preparedStatement.setString(3, nuevocorreo);
                preparedStatement.setInt(4, clienteId);

                int rows = preparedStatement.executeUpdate();

                return rows > 0;
            }
        } catch (SQLException ex) {
            System.out.println("" + ex.getMessage());
            return false;
        }
    }
    
    public boolean eliminarcliente(int clienteId){
        try(Connection conn = DriverManager.getConnection(URL, usuario, contraseña)){
        
            String eliminar = "DELETE FROM CLIENTES " + "WHERE CLIENTEID = " + clienteId;
            PreparedStatement ps = conn.prepareStatement(eliminar);
            Integer rows = ps.executeUpdate();
            if(rows > 0){
               return true; 
            }
        
        }catch(SQLException e){
            System.out.println(""+ e.getMessage());
            return false;  
        }
        return false; 
    }
    
}
