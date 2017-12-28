
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Mensaje {
    
    public static void main(String [] args) throws SQLException
    {
    (new Mensaje()).setMensaje("hello word", "peter", "robert");
    }
    
    
    
    
    public boolean setMensaje(String descripcion, String user, String amigo) throws SQLException
    {
    
        Usuario u = new Usuario();
        int cod_usuario = u.getCodigoUsuario(user);
        int cod_amigo= u.getCodigoUsuario(amigo);
        
        	Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO mensaje(descripcion, cod_usuario,cod_amigo)" + "VALUES(?,?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, descripcion);
			preparedStatement.setInt(2, cod_usuario);
			preparedStatement.setInt(3, cod_amigo);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se envio mensaje");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se envio mensaje: "+e);
			
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
}
