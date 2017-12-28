/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import bdd.Estado;
import bdd.Usuario;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Osman Lima
 */
@WebService(serviceName = "Estados")
public class Estados {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "setEstado")

public boolean setEstado(@WebParam(name = "descripcion") String descripcion,@WebParam(name = "user") String user)
{

Estado e = new Estado();
        try 
        {
        return e.setEstado(descripcion, user);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}

@WebMethod(operationName = "setComentario")

public boolean setComentario(@WebParam(name = "descripcion") String descripcion,@WebParam(name = "cod_estado") int cod_estado,@WebParam(name = "user") String user)
{

Estado e = new Estado();
        try 
        {
        return e.setComentario(descripcion, cod_estado, user);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}

}
