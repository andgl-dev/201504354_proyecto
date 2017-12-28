
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Conocimiento 
{

    
    public static void main(String []args)
    {
    (new Conocimiento()).getCodigoConocimiento("Java");
    
    
    }

public int getCodigoConocimiento(String nombre)
{
Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
                int a=0;
                
        String selectSQL2="SELECT cod_conocimiento as codigo FROM conocimiento "
                +" where nombre ="+"'"+nombre+"'" ;
        
            try 
            {
            
                dbConnection = new Conexion().getConnection();
		preparedStatement = dbConnection.prepareStatement(selectSQL2);
		
		ResultSet rs;
		rs = preparedStatement.executeQuery();
             
              if(rs.next())
              {
                              System.out.println(rs.getString("codigo"));
                              a=Integer.parseInt(rs.getString("codigo"));
              }
              else
              {
                  System.out.println("no hay nada");
              }
              
              
              
                
              return a;
            }
            catch(Exception e)
            {
                System.out.println("No se pudo contar" +e);
                a=0;
        return a;
            }
            



}






    
}
