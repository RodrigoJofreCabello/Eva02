/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author felipe
 */
public class RegistrarTrabajador {
    
    
    static ArrayList<Trabajador> trabajadores;
    
    public RegistrarTrabajador() {
        
        trabajadores = new ArrayList<Trabajador>();    
    }
    
    
    
    public static void agregarTrabajador(Trabajador nuevo){
        //System.out.println(nuevo.getRut());
        //if(verificarDistribuidor(nuevo.getRut())==false){
            
           
            try{  
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");  

                Connection con=DriverManager.getConnection("jdbc:sqlserver://localhost:1433","sa","qwert123");  

                PreparedStatement stmt=con.prepareStatement("insert into [Empresa].[dbo].[Trabajador] (rut, nombre, sexo, direccion, telefono) values(?,?,?,?,?)");  
                stmt.setString(1,nuevo.getRut());//1 specifies the first parameter in the query 
                stmt.setString(2,nuevo.getNombre());
                stmt.setString(3,nuevo.getSexo()); 
                stmt.setString(4,nuevo.getDireccion()); 
                stmt.setString(5,nuevo.getTelefono());	

                int i=stmt.executeUpdate();  

                System.out.println(i+" records inserted");  

                con.close();  

                }catch(Exception e){ System.out.println(e);}  

       
    }
    
}
