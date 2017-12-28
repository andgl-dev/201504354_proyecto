
package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Estado {

public static void main(String [] args) throws SQLException
{
(new Estado()).setComentario("sin falta",1, "peter");
    
}


public boolean setEstado(String descripcion, String user) throws SQLException
    {
    
        Usuario u = new Usuario();
        int cod_usuario = u.getCodigoUsuario(user);
        
        	Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO estado(descripcion, cod_usuario)" + "VALUES(?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, descripcion);
			preparedStatement.setInt(2, cod_usuario);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se envio estado");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se envio estado: "+e);
			
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


public boolean setComentario(String descripcion, int cod_estado, String user) throws SQLException
{

    Usuario u = new Usuario();
        int cod_usuario_com = u.getCodigoUsuario(user);
        
        	Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        String insertTableSQL = "INSERT INTO comentario(descripcion, cod_estado, cod_usuario_com)" + "VALUES(?,?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, descripcion);
			preparedStatement.setInt(2, cod_estado);
			preparedStatement.setInt(3, cod_usuario_com);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se envio comentario");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se envio comentario: "+e);
			
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
