package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class Conexion 
{
    
      private static  Connection conn;
   
    private static final String DB_DRIVE ="org.mariadb.jdbc.Driver";
   
    private static final String cHOST = "localhost";
    private static final String cPORT = "3306";
    private static final String cDATABASE = "red";
            
    private static final String cUser="root";
    private static final String cPassword="galaxya2000";
    
    private static final String DB_CONNECTION="jdbc:mariadb://"+cHOST+":"+cPORT+"/"+cDATABASE+"";
 

    
    public Conexion ()
    {
    conn=null;
    
    try
    {
    Class.forName(DB_DRIVE);
    conn=DriverManager.getConnection(DB_CONNECTION, cUser, cPassword);
    if(conn != null)
    {
        System.out.println("Conexion establecida");
    }
    
    }catch (ClassNotFoundException | SQLException e)
            {
                System.out.println("Error al conectar: " + e);
            }
    }

    //este metodo nos retornara la conexion
    public Connection getConnection()
    {
    
        return conn;
    }

    //con este desconectaremos a la base de datos
    public void desconectar()
    {
    conn=null;
    if(conn==null)
    {
        System.out.println("Conexion terminada");
    }
    }
    
public static void main(String[] args) 
    {
        Conexion con=new Conexion();
        Connection reg= con.getConnection();
        
    }    
}