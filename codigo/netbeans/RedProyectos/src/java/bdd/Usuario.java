package bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Osman Lima
 */
public class Usuario {
    
    public static void main(String [] args) throws SQLException
    {
    (new Usuario()).existente("PETER");
    
    }
    
    
    
    public boolean setUsuario(String nombre,String correo,String fecha_nacimiento,
            String nick_name,String contrasenia,int dinero,String tipo) throws SQLException{
		Connection dbConnection = null;

		PreparedStatement preparedStatement = null;

String insertTableSQL = "INSERT INTO usuario(nombre,correo,fecha_nacimiento,nick_name,contrasenia,dinero,tipo)" + "VALUES(?,?,?,?,?,?,?)";




/*"UPDATE USUARIO" + "SET nickname=? AND password=?";*/

		try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, nombre);
			preparedStatement.setString(2, correo);
                        //la fecha se da yyyy/mmmm/dddd
			preparedStatement.setString(3, fecha_nacimiento);
			preparedStatement.setString(4, nick_name);
			preparedStatement.setString(5, contrasenia);
			preparedStatement.setInt(6, dinero);
			preparedStatement.setString(7, tipo);
			



	
			preparedStatement.executeUpdate();
			dbConnection.close();
		                        System.out.println("Se logro ingresar cliente");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se ingreso cliente: "+e);
			
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
    
    public String existente(String nick_name)
    {
        String existe="no";
        Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
               
                
        String selectSQL2="SELECT cod_usuario as codigo FROM usuario "
                +" where nick_name = "+"'"+nick_name+"'" ;
      try 
            {
            
                dbConnection = new Conexion().getConnection();
		preparedStatement = dbConnection.prepareStatement(selectSQL2);
		
		ResultSet rs;
		rs = preparedStatement.executeQuery();
             
              if(rs.next())
              {
                  
                  existe="si";
                  System.out.println(existe);
              }
              else
              {
                  existe ="no";
                  System.out.println(existe);
              }
              return existe;
            }
            catch(Exception e)
            {
                existe="si";
                System.out.println("No se pudo contar" +e);
                
        return existe;
            }

    
    
    
    
    
    }
    
    
public String[] getDatos(String nick_name)
{
    String[] datos = new String[8];
    
                Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
               
                
        String selectSQL2="SELECT cod_usuario as codigo, nombre, correo, fecha_nacimiento, nick_name, contrasenia, dinero, tipo FROM usuario "
                +" where nick_name ="+"'"+nick_name+"'" ;
        
            try 
            {
            
                dbConnection = new Conexion().getConnection();
		preparedStatement = dbConnection.prepareStatement(selectSQL2);
		
		ResultSet rs;
		rs = preparedStatement.executeQuery();
             
              if(rs.next())
              {
                             datos[0]=rs.getString("codigo");
                             datos[1]=rs.getString("nombre");
                             datos[2]=rs.getString("correo");
                             datos[3]=rs.getString("fecha_nacimiento");
                             datos[4]=rs.getString("nick_name");
                             datos[5]=rs.getString("contrasenia");
                             datos[6]=rs.getString("dinero");
                             datos[7]=rs.getString("tipo");
                             
                             System.out.println(datos[0]);
              }
              else
              {
                  datos[0]="no";
                  System.out.println(datos[0]);
              }
              return datos;
            }
            catch(Exception e)
            {
                datos[0]="no";
                System.out.println("No se pudo contar" +e);
                
        return datos;
            }



}    
public int getCodigoUsuario(String nick_name)
{
    
                Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
                int a=0;
                
        String selectSQL2="SELECT cod_usuario as codigo FROM usuario "
                +" where nick_name ="+"'"+nick_name+"'" ;
        
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

   public boolean addAmigo(String usuario, String amigo) throws SQLException
   {
   
   	Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        int cod_usuario=this.getCodigoUsuario(usuario);
        int cod_amigo= this.getCodigoUsuario(amigo);

        String insertTableSQL = "INSERT INTO amigo(cod_usuario,cod_amigo)" + "VALUES(?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, cod_usuario);
			preparedStatement.setInt(2, cod_amigo);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se agrego amigo");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se agrego amigo: "+e);
			
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
 
public boolean deleteAmigo(String user, String amigo) throws SQLException
{

    Connection dbConnection = null;
    PreparedStatement preparedStatement = null;

    int cod_user= this.getCodigoUsuario(user);
    int cod_amigo= this.getCodigoUsuario(amigo);
    
String insertTableSQL = "DELETE FROM AMIGO" 
                        + " WHERE cod_usuario = "+cod_user
                        +" and cod_amigo = "+cod_amigo;

try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
	
			preparedStatement.executeUpdate();
			dbConnection.close();

                        System.out.println("Se logro borrar amigo");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se borro amigo: "+e);
			
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

public boolean addConocimiento(int Karma,String conocimiento, String user) throws SQLException
{

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        int cod_usuario=this.getCodigoUsuario(user);
        Conocimiento c= new Conocimiento();
        int cod_conocimiento= c.getCodigoConocimiento(conocimiento);

        String insertTableSQL = "INSERT INTO conocimiento_usuario(karma,cod_conocimiento,cod_usuario)" + "VALUES(?,?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setInt(1, Karma);
                	preparedStatement.setInt(2, cod_conocimiento);
			preparedStatement.setInt(3, cod_usuario);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se agrego conocimiento");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se agrego conocimiento: "+e);
			
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
   
public boolean puntearMasKarma(String user, String conocimiento) throws SQLException
{
int karma = this.getKarma(user, conocimiento);
karma = karma+1;

Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        int cod_usuario=this.getCodigoUsuario(user);
        Conocimiento c= new Conocimiento();
        int cod_conocimiento= c.getCodigoConocimiento(conocimiento);

        String insertTableSQL = "UPDATE conocimiento_usuario set karma = "+karma 
                +" where cod_usuario = "+cod_usuario
                +" and cod_conocimiento = "+cod_conocimiento;
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se agrego karma");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se agrego karma: "+e);
			
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

public boolean puntearMenosKarma(String user, String conocimiento) throws SQLException
{
int karma = this.getKarma(user, conocimiento);
if(karma>0){
karma = karma-1;

Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        int cod_usuario=this.getCodigoUsuario(user);
        Conocimiento c= new Conocimiento();
        int cod_conocimiento= c.getCodigoConocimiento(conocimiento);

        String insertTableSQL = "UPDATE conocimiento_usuario set karma = "+karma 
                +" where cod_usuario = "+cod_usuario
                +" and cod_conocimiento = "+cod_conocimiento;
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("Se agrego karma");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se agrego karma: "+e);
			
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
else
{

return true;
}

}

public int getKarma(String user, String conocimiento)
{
Connection dbConnection = null;
		PreparedStatement preparedStatement= null;
                int a=0;
                
        String selectSQL2="SELECT c.karma as karma FROM usuario u, conocimiento_usuario c , conocimiento k "
                +" where c.cod_usuario = u.cod_usuario " 
                + "and u.nick_name = "+"'"+user+"'"
                +" and c.cod_conocimiento = k.cod_conocimiento"
                +" and k.nombre = "+"'"+conocimiento+"'";
        
            try 
            {
            
                dbConnection = new Conexion().getConnection();
		preparedStatement = dbConnection.prepareStatement(selectSQL2);
		
		ResultSet rs;
		rs = preparedStatement.executeQuery();
             
              if(rs.next())
              {
                              System.out.println(rs.getString("karma"));
                              a=Integer.parseInt(rs.getString("karma"));
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

public boolean aplicarAsociacion(String tipo, String asociacion, String user) throws SQLException
{
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        
        int u_miembro=this.getCodigoUsuario(user);
       Asociacion aso = new Asociacion();
       int cod_asociacion= aso.getCodigoAsociacion(asociacion);
        
        String insertTableSQL = "INSERT INTO miembro_asociacion(tipo,u_miembro,cod_asociacion)" + "VALUES(?,?,?)";
            
        try{
			dbConnection = new Conexion().getConnection();
			preparedStatement = dbConnection.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, tipo);
                	preparedStatement.setInt(2, u_miembro);
			preparedStatement.setInt(3, cod_asociacion);
                        
			preparedStatement.executeUpdate();
			dbConnection.close();
		        System.out.println("ahora es miembro de la asociacion");

                        return true;

                }catch(SQLException e){
                        System.out.println("No se pudo agregar miembro: "+e);
			
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
