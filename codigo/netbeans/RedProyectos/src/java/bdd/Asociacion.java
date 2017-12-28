
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Asociacion {



public boolean crearAsociacion(String nombre, String descripcion, String user) throws SQLException
{

    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;
    Usuario u = new Usuario();
    int cod_admin= u.getCodigoUsuario(user);
String insertTableSQL = "INSERT INTO asociacion(nombre,descripcion,cod_admin)" + "VALUES(?,?,?)";

		try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, descripcion);
			preparedStatement.setInt(3, cod_admin);
			
                        preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se logro crear Asociacion");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se creo asiciacion: "+e);
			
			return false;
		}finally{
			if(preparedStatement!=null){
				preparedStatement.close();
			}
			if(dbConnection!=null){
				dbConnection.close();
			}
		}
}

public int getCodigoAsociacion(String nombre)
{
Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
                int a=0;
                
        String selectSQL2="SELECT cod_asociacion as codigo FROM asociacion "
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
