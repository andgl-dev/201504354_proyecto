/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import bdd.Mensaje;
import bdd.Usuario;
import java.sql.SQLException;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Osman Lima
 */
@WebService(serviceName = "Mensajes")
public class Mensajes {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "setMensaje")

public boolean setMensaje(@WebParam(name = "descripcion") String descripcion,@WebParam(name = "usuario") String usuario,@WebParam(name = "amigo") String amigo)
{

Mensaje m = new Mensaje();
        try 
        {
        return m.setMensaje(descripcion, usuario, amigo);

        } 
        catch (SQLException ex) 
        {
        return false;
        }

}
}
