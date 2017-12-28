/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import bdd.Usuario;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Osman Lima
 */
@WebService(serviceName = "Usuarios")
public class Usuarios {

    /**
     * This is a sample web service operation
     */
@WebMethod(operationName = "AgregarUsuario")

    public boolean AgregarUsuario(@WebParam(name = "nombre") String nombre,
    @WebParam(name = "correo") String correo, @WebParam(name = "fecha_nacimiento") String fecha_nacimiento,
            @WebParam(name = "nick_name") String nick_name,@WebParam(name = "contrasenia") String contrasenia,
            @WebParam(name = "dinero") int dinero,@WebParam(name = "tipo") String tipo)
    
    {
        
        Usuario us = new Usuario();
        try 
        {
        return us.setUsuario(nombre, correo, fecha_nacimiento,
             nick_name, contrasenia, dinero, tipo);

        } 
        catch (SQLException ex) 
        {
        return false;
        }
    }
    
@WebMethod(operationName = "AddAmigo")

public boolean AddAmigo(@WebParam(name = "usuario") String usuario,@WebParam(name = "amigo") String amigo)
{

Usuario us = new Usuario();
        try 
        {
        return us.addAmigo(usuario,amigo);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}


@WebMethod(operationName = "Existente")

public String Existente(@WebParam(name = "nick_name") String nick_name)
{

Usuario us = new Usuario();
return us.existente(nick_name);

}


@WebMethod(operationName = "getDatos")

public String[] getDatos(@WebParam(name = "nick_name") String nick_name)
{

Usuario us = new Usuario();
return us.getDatos(nick_name);

}



@WebMethod(operationName = "deleteAmigo")

public boolean deleteAmigo(@WebParam(name = "user") String usuario,@WebParam(name = "amigo") String amigo)
{

Usuario us = new Usuario();
        try 
        {
        return us.deleteAmigo(usuario,amigo);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}

@WebMethod(operationName = "AddConocimiento")

public boolean AddConocimiento(@WebParam(name = "karma") int karma,@WebParam(name = "conocimiento") String conocimiento
                                ,@WebParam(name = "usuario") String usuario)
{

Usuario us = new Usuario();
        try 
        {
        return us.addConocimiento(karma, conocimiento, usuario);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}

@WebMethod(operationName = "puntarMasKarma")

public boolean puntearMasKarma(@WebParam(name = "usuario") String usuario,@WebParam(name = "conocimiento") String conocimiento)
{

Usuario us = new Usuario();
        try 
        {
        return us.puntearMasKarma(usuario, conocimiento);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}

@WebMethod(operationName = "puntarMenosKarma")

public boolean puntearMenosKarma(@WebParam(name = "usuario") String usuario,@WebParam(name = "conocimiento") String conocimiento)
{

Usuario us = new Usuario();
        try 
        {
        return us.puntearMenosKarma(usuario, conocimiento);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}
    
    
@WebMethod(operationName = "aplicarAsociacion")

public boolean aplicarAsociacion(@WebParam(name = "tipo") String tipo,@WebParam(name = "asociacion") String asociacion,@WebParam(name = "usuario") String usuario)
{

Usuario us = new Usuario();
        try 
        {
        return us.aplicarAsociacion(tipo, asociacion, usuario);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}



}
